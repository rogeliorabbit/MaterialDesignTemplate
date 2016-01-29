package com.hitglynorthz.fragments;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hitglynorthz.beta.MainActivity;
import com.hitglynorthz.beta.R;

/**
 * Created by rogeliorabbit on 14/01/2016.
 */
public class Fragment_Routes extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    public Fragment_Routes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_routes, container, false);

        tabLayout = ((MainActivity) getActivity()).getTabLayout();
        viewPager = (ViewPager) rootView.findViewById(R.id.routes_viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return rootView;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new TabOne();
                case 1 : return new TabTwo();
                case 2 : return new TabThree();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "tab1";
                case 1 :
                    return "tab2";
                case 2 :
                    return "tab3";
            }
            return null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(tabLayout != null) {
            tabLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        tabLayout.removeAllTabs();
        tabLayout.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroy();
        //Toast.makeText(getActivity(), "onDestroy", Toast.LENGTH_SHORT).show();
    }

}
