package com.hitglynorthz.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hitglynorthz.adapters.Get_Routes;
import com.hitglynorthz.adapters.RecyclerItemClickListener;
import com.hitglynorthz.adapters.Routes_Adapter;
import com.hitglynorthz.beta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogeliorabbit on 15/01/2016.
 */
public class TabTwo extends Fragment {
    private List<Get_Routes> routes;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.tab_two, container, false);
        View rootView = inflater.inflate(R.layout.tab_two, container, false);

        rv=(RecyclerView)rootView.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Snackbar.make(view, "Pulsado el elemento: " + routes.get(position).name,Snackbar.LENGTH_SHORT).show();
                    }
                })
        );

        initializeData();
        initializeAdapter();

        return  rootView;
    }

    private void initializeData(){
        routes = new ArrayList<>();
        routes.add(new Get_Routes("Ruta2 1", "9 km", R.drawable.cardviewbackground));
        routes.add(new Get_Routes("Ruta2 2", "5 km", R.drawable.cardviewbackground));
        routes.add(new Get_Routes("Ruta2 3", "3 km", R.drawable.cardviewbackground));
        routes.add(new Get_Routes("Ruta2 4", "2 km", R.drawable.cardviewbackground));
        routes.add(new Get_Routes("Ruta2 5", "8 km", R.drawable.cardviewbackground));
    }

    private void initializeAdapter(){
        Routes_Adapter adapter = new Routes_Adapter(routes);
        rv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroy();
        //Toast.makeText(getActivity(), "onDestroy Tab2", Toast.LENGTH_SHORT).show();
    }

}
