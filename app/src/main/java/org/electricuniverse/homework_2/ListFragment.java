package org.electricuniverse.homework_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment
{
    public interface OnItemSelectedListener
    {
        public void onListItemSelected(int imageResourceID, String title, String year);
    }


    OnItemSelectedListener clickListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rooView=inflater.inflate(R.layout.fragment_list, container, false);
        Button frozen=(Button) rooView.findViewById(R.id.button_fozen);
        Button lionking=(Button) rooView.findViewById(R.id.button_lionking);
        Button startwar=(Button) rooView.findViewById(R.id.button_starwar);
        Button avatar=(Button) rooView.findViewById(R.id.button_avatar);

        frozen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clickListener.onListItemSelected(R.drawable.frozen, "Frozen","2017");
            }
        });
        lionking.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                clickListener.onListItemSelected(R.drawable.lion,"Disney's The Lion King","1995");
            }
        });
        avatar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clickListener.onListItemSelected(R.drawable.avatar,"Avatar","2009");
            }
        });
        startwar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                clickListener.onListItemSelected(R.drawable.star_wars3,
                        "Star Wars Episode III: Revenge of the Sith","2005");
            }
        });



        return rooView;
    }
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            clickListener=(OnItemSelectedListener)context;
        }
        catch (ClassCastException ex)
        {
            throw new ClassCastException(context.toString()+"must implemet EventTrack");
        }
    }
}
