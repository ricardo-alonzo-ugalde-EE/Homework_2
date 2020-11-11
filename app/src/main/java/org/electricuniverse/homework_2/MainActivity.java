package org.electricuniverse.homework_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    /**
     * image lsitener
     * */

    /**
     * Master / list items************************************************************************
     * */
//    private RecyclerView recycler_view;
//    private MovieData md=new MovieData();
//    private final MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(md.getMoviesList());
    /**
     * Master / list items************************************************************************
     * */


    //initialiazle variable
    DrawerLayout drawerLayout;

    TabLayout tabLayout;
    ViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /**
         * Master / List Items********************************************************************
//         * */
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);

        /**
         * Master / List Items********************************************************************
         * */




        //assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));

        //Assign viewpager and tab layout variables
        tabLayout = findViewById(R.id.tab_layout);



    }


//    /**
//     * Master / List Items********************************************************************
//     * */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        MenuItem myActionMenuItem = menu.findItem(R.id.search_action);
//        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
//        {
//
//            /**
//             * Part 8: Filtering the list. Complete the SearchView.OnQueryTextListener() implementation to invoke the getFilter
//             * method on your adapter.
//             * */
//            @Override
//            public boolean onQueryTextSubmit(String query)
//            {
//                Toast toast = Toast.makeText(getApplicationContext(), "Query Text =" + query, Toast.LENGTH_SHORT);
//                toast.show();
//                myRecyclerAdapter.getFilter().filter(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText)
//            {
//                myRecyclerAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    protected void onStart()
//    {
//        super.onStart();
//        recycler_view = (RecyclerView) findViewById(R.id.mainRecyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager( this );
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        layoutManager.scrollToPosition(0);
//        recycler_view.setLayoutManager(layoutManager);
//        myRecyclerAdapter.setOnItemClickListener(new OnListItemClickListener()
//        {
//            @Override
//            public void onItemClick(View v, int position)
//            {
//                Map hashMap = myRecyclerAdapter.getItem(position);
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                MovieDetailFragment movieDetailFragment = MovieDetailFragment.newInstance((int)hashMap.get("image"),
//                        hashMap.get("name").toString(),hashMap.get("year").toString(),
//                        Float.parseFloat(hashMap.get("rating").toString()),hashMap.get("description").toString());
//                fragmentTransaction.replace(R.id.detailFragment,movieDetailFragment);
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
//                fragmentTransaction.commit();
//
//            }
//
//            @Override
//            public void onItemLongClick(View v, int position) {
//
//            }
//        });
//        recycler_view.setAdapter(myRecyclerAdapter);
//        recycler_view.setItemAnimator(new DefaultItemAnimator());
//
//
//    }
//    /**
//     * Master / List Items********************************************************************
//     * */



    public void ClickMenu(View view)
    {
        // open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout)
    {
        //  open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view)
    {
        //close the drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        //close drawer layout and check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            //when drawer is open, close the drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }

    public void ClickHome(View view)
    {
        // Recreate Activity
        recreate();
    }
    public void ClickDashboard(View view)
    {
        //Redirect activity to dashboard
        redirectActivity(this, newActivity.class);
    }

    public void ClickAboutUs(View view)
    {
        //redirect activity to about us
        redirectActivity(this, AboutUs.class);
    }

    public void ClickLogout(View view)
    {
        //close app
        logout(this);
    }

    public void ClickViewPager(View view)
    {
        //go to view pager
        //redirectActivity(this, MainFragment.class);
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void MasterDetail(View view)
    {
        startActivity(new Intent(this,newActivity.class));
    }


     public static void logout(Activity activity)
    {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        //set message
        builder.setMessage("Are you sure you want to logout?");
        //positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // finish activity
                activity.finishAffinity();
                //exit app
                System.exit(0);
            }
        });
        //negative button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //dismiss dialog
                dialog.dismiss();
            }
        });
        //show dialog
        builder.show();
    }


    public static void redirectActivity(Activity activity, Class aClass)
    {
        //initialize intent
        Intent intent = new Intent(activity, aClass);

        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //close
        closeDrawer(drawerLayout);
    }
}