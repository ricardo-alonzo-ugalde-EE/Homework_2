package org.electricuniverse.homework_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class AboutUs extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        drawerLayout = findViewById(R.id.drawer_layout);
        Window window = AboutUs.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(AboutUs.this, R.color.colorAccent));
    }

    public void ClickMenu(View view)
    {
        //open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view)
    {
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view)
    {
        //Redirect Activity to home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickDashboard(View view)
    {
        //redirect activity to dashboard
        MainActivity.redirectActivity(this, newActivity.class);
    }

    public void ClickAboutUs(View view)
    {
        //recreate activity
        recreate();
    }

    public void ClickLogout(View view)
    {
        //close app
        MainActivity.logout(this);
    }

//    public void ClickViewPager(View view)
//    {
//        //redirect activity to dashboard
//        MainActivity.redirectActivity(this, Dashboard.class);
//    }

    @Override
    protected void onPause()
    {
        super.onPause();

        //close drawer
        MainActivity.closeDrawer(drawerLayout);

    }
}