package com.example.fooding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooding.R;
import com.example.fooding.data.Food;
import com.example.fooding.data.Store;
import com.example.fooding.unit.FlowLayout;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


public class LevelOneReLeftAdapter extends RecyclerView.Adapter<LevelOneReLeftAdapter.ViewHolder> {
    private List<Store> storesData;
    private Context mcontext;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView store_name;

        public ViewHolder(View view) {
            super(view);
            store_name = view.findViewById(R.id.level_one_left_recycler_item);

        }
    }

    public LevelOneReLeftAdapter(List<Store> storesData) {
        this.storesData = storesData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_left_re_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        int position = holder.getAdapterPosition();


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Store store = storesData.get(position);
        holder.store_name.setText(store.getName());

    }

    @Override
    public int getItemCount() {
        return storesData.size();
    }

}
