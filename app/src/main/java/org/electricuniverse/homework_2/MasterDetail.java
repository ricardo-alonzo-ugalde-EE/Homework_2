package org.electricuniverse.homework_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MasterDetail extends AppCompatActivity implements ListFragment.OnItemSelectedListener {
    private boolean twoPane;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);


        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container,new ListFragment()).commit();
        }
        twoPane=false;
        if(findViewById(R.id.detail_container)!=null)
        {
            twoPane=true;
        }
    }

    @Override
    public void onListItemSelected(int imageResourceID, String title, String year) {
        Bundle args=new Bundle();
        args.putInt("img_id",imageResourceID);
        args.putString("mtitle",title);
        args.putString("myear",year);
        Fragment detailFragment=new DetailFragment();
        detailFragment.setArguments(args);
        if(twoPane)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container,detailFragment)
                    .commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container,detailFragment)
                    .addToBackStack(null).commit();
        }

    }
}