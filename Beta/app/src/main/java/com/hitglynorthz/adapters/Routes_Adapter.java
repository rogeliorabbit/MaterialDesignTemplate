package com.hitglynorthz.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hitglynorthz.beta.R;

import java.util.List;

/**
 * Created by rogeliorabbit on 25/01/2016.
 */
public class Routes_Adapter extends RecyclerView.Adapter<Routes_Adapter.RoutesViewHolder> {

    public static class RoutesViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView routeName;
        TextView RouteKM;
        ImageView RoutePhoto;

        RoutesViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            routeName = (TextView)itemView.findViewById(R.id.route_name);
            RouteKM = (TextView)itemView.findViewById(R.id.route_km);
            RoutePhoto = (ImageView)itemView.findViewById(R.id.route_photo);
        }

    }

    List<Get_Routes> routes;

    public Routes_Adapter(List<Get_Routes> routes){
        this.routes = routes;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RoutesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_row, viewGroup, false);
        RoutesViewHolder rvh = new RoutesViewHolder(v);

        return rvh;
    }

    @Override
    public void onBindViewHolder(RoutesViewHolder routesViewHolder, int i) {
        routesViewHolder.routeName.setText(routes.get(i).name);
        routesViewHolder.RouteKM.setText(routes.get(i).km);
        routesViewHolder.RoutePhoto.setImageResource(routes.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

}