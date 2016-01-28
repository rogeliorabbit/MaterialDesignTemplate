package com.hitglynorthz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.support.v4.app.Fragment;

import com.hitglynorthz.beta.R;

/**
 * Created by rogeliorabbit on 14/01/2016.
 */
public class Fragment_Home extends Fragment {

    public Fragment_Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;

    }
}
