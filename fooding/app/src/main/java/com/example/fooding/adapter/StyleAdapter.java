package com.example.fooding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooding.R;
import com.example.fooding.data.DataCommon;

import java.util.List;


public class StyleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mlayoutInflater;
    private List<DataCommon> mdata;
    private Context mcontext;

    private final static int ITEM_CONTENT = 0;
    private final static int ITEM_FOOT = 1;

    private int mfoot = 1;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.style_item);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public FootViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.style_item_foot);
        }
    }

    public StyleAdapter(List<DataCommon> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
            mlayoutInflater = LayoutInflater.from(mcontext);
        }

        if (viewType == ITEM_CONTENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_style, parent, false);
            final ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    DataCommon dataCommon = mdata.get(position);
                    Toast.makeText(mcontext,dataCommon.getName(),Toast.LENGTH_SHORT).show();
                }
            });
            return viewHolder;
        }
        if (viewType == ITEM_FOOT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_style_foot, parent, false);
            final FootViewHolder footViewHolder = new FootViewHolder(view);
            footViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(mcontext,"add",Toast.LENGTH_SHORT).show();

                }
            });

            return footViewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            DataCommon dataCommon = mdata.get(position);
            ((ViewHolder) holder).textView.setText(dataCommon.getName());
        }
        if (holder instanceof FootViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return mdata.size()+mfoot;
    }

    public int getItemViewType(int position) {
        if (mfoot != 0 && position >= mdata.size()) {
            return ITEM_FOOT;
        }
        return ITEM_CONTENT;
    }

}
