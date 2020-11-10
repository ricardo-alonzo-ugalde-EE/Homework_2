package org.electricuniverse.homework_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DemoObjectFragment extends Fragment {
    public static final String ARG_TITLE = "title";
    public static final String ARG_YEAR = "year";
    public static final String ARG_POSTER = "poster";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
        Bundle args = getArguments();
        ((TextView) rootView.findViewById(R.id.movie_title)).setText(args.getString(ARG_TITLE));
        ((TextView) rootView.findViewById(R.id.movie_year)).setText(args.getString(ARG_YEAR));
        ((ImageView) rootView.findViewById(R.id.movie_poster)).setImageResource(args.getInt(ARG_POSTER));
        return rootView;
    }
}
