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
import com.example.fooding.data.DataCommon;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;

import java.util.List;


public class LevelOneReRigthAdapter extends RecyclerView.Adapter<LevelOneReRigthAdapter.ViewHolder> {
    private List<Store> storesData;
    private Context mcontext;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView store_name;
        RadioButton radioButton;
        public ViewHolder(View view) {
            super(view);
            store_name = view.findViewById(R.id.level_one_card_store_name);
            radioButton = view.findViewById(R.id.level_one_card_whether_click);

        }
    }

    public LevelOneReRigthAdapter(List<Store> storesData) {
        this.storesData = storesData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_common, parent, false);
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
