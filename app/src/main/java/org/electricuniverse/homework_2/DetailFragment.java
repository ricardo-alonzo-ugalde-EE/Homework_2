package org.electricuniverse.homework_2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment
{

    ListFragment.OnItemSelectedListener clickListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        // Inflate the layout for this fragment
        View rooView=inflater.inflate(R.layout.detail_fragment, container, false);
        ImageView imageView=(ImageView)rooView.findViewById(R.id.img_poster);
        TextView title=(TextView)rooView.findViewById(R.id.title);
        TextView year=(TextView)rooView.findViewById(R.id.year);
        Bundle args=getArguments();
        imageView.setImageResource(args.getInt("img_id"));
        title.setText(args.getString("mtitle"));
        year.setText(args.getString("myear"));

      //  Button lebutton = (Button) rooView.findViewById(R.id.le_button);

        //lebutton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//                Intent intent = new Intent(getActivity(), MasterDetail.class);
//                startActivity(intent);
//            }
//        });
        return rooView;
    }

//    public void openNewActivity()
//    {
//        Intent intent = new Intent(DetailFragment.this, MainActivity.class);
//        startActivity(intent);
//
//    }

}
