package org.electricuniverse.homework_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {
    List<Movie> list_movie;
    public DemoCollectionPagerAdapter(FragmentManager fm, List<Movie> list_m ) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.list_movie=list_m;
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new DemoObjectFragment();
        Bundle args = new Bundle();
        args.putString(DemoObjectFragment.ARG_TITLE, list_movie.get(i).getName());
        args.putString(DemoObjectFragment.ARG_YEAR, list_movie.get(i).getYear());
        args.putInt(DemoObjectFragment.ARG_POSTER, list_movie.get(i).getPoster_id());
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getCount() {
        return list_movie.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return list_movie.get(position).getName();
    }
}
