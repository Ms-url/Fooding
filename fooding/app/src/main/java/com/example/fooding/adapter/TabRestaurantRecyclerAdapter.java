package com.example.fooding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooding.R;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;

import java.util.List;


public class TabRestaurantRecyclerAdapter extends RecyclerView.Adapter<TabRestaurantRecyclerAdapter.ViewHolder> {
    private List<Restaurant> restaurantsData;
    private Context mcontext;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tab_recycler_item);

        }
    }

    public TabRestaurantRecyclerAdapter(List<Restaurant> restaurantsData) {
        this.restaurantsData = restaurantsData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_recycler_item ,parent, false);
        final ViewHolder holder = new ViewHolder(view);
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        int position = holder.getAdapterPosition();
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurantsData.get(position);
        holder.name.setText(restaurant.getName());

    }

    @Override
    public int getItemCount() {
        return restaurantsData.size();
    }

}
