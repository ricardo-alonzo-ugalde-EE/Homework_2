package org.electricuniverse.homework_2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.Map;

import java.util.Map;

public class ActivityMaster extends FragmentActivity
 {
     MovieData md = new MovieData();
     private int pages = md.getSize();
     private boolean twoPane;
     private int backCheck;

     @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     @Override
     protected void onCreate(final Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.master_layout);
         Window window = ActivityMaster.this.getWindow();
         window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
         window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
         window.setStatusBarColor(ContextCompat.getColor(ActivityMaster.this, R.color.colorAccent));
         twoPane = false;
         if (findViewById(R.id.detailFragment) != null) {
             twoPane = true;
         }
         backCheck = 0;

         final LinearLayout layout = (LinearLayout) findViewById(R.id.content);
         LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                 LinearLayout.LayoutParams.MATCH_PARENT,
                 LinearLayout.LayoutParams.WRAP_CONTENT);

         for (int i = 0; i < pages; i++) {
             final Map hashMap = md.moviesList.get(i);
             Button btn = new Button(this);
             btn.setId(i);
             btn.setText(hashMap.get("name").toString());
             btn.setTextSize(12);
//            btn.setBackgroundColor(Color.rgb(70, 80, 90));
             btn.setLayoutParams(params);
             layout.addView(btn);
             btn = ((Button) findViewById(i));
             final int finalI = i;
             final int finalI1 = i;
             btn.setOnClickListener(new View.OnClickListener() {
                 @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                 @Override
                 public void onClick(View view) {
                     int img_id = (int)hashMap.get("image");
                     String mtitle = hashMap.get("name").toString();
                     String myear = hashMap.get("year").toString();
                     String mdes = hashMap.get("description").toString();
                     String mactor = hashMap.get("stars").toString();
                     double mrating = (double)hashMap.get("rating");
                     onMovieStart(img_id, mtitle, myear, mdes, mactor, mrating, twoPane);
                 }
             });
         }
     }

     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
     protected void onMovieStart(int img, String mtitle, String myear, String mdes, String mactor, double mrating, boolean twoPane) {

         backCheck = 1;
         Bundle args = new Bundle();
         args.putInt("img_id", img);
         args.putDouble("mrating", mrating);
         args.putString("mtitle", mtitle);
         args.putString("myear", myear);
         args.putString("mdes", mdes);
         args.putString("mactor", mactor);
         Fragment detailFragment = new DetailFragment();
         detailFragment.setArguments(args);

         if (twoPane) {
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 detailFragment.setEnterTransition(new Slide(Gravity.TOP));
             }
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 detailFragment.setExitTransition(new Slide(Gravity.BOTTOM));
             }
             getSupportFragmentManager().beginTransaction().replace(R.id.main_container, detailFragment).addToBackStack(null).commit();
         } else {
             setContentView(R.layout.fragment_movie_detail);
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 detailFragment.setSharedElementEnterTransition(new DetailsTransition());
             }
             detailFragment.setEnterTransition(new Fade());
             detailFragment.setExitTransition(new Fade());
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 detailFragment.setSharedElementReturnTransition(new DetailsTransition());
             }
             getSupportFragmentManager().beginTransaction().replace(R.id.main_container, detailFragment).addToBackStack(null).commit();
         }

     }
     @Override
     public void onBackPressed() {
         if (backCheck == 1) {
             Intent intent = new Intent(this, ActivityMaster.class);
             startActivity(intent);
         }
         else {
             Intent intent2 = new Intent(this, MainActivity.class);
             startActivity(intent2);
         }
     }
 };
