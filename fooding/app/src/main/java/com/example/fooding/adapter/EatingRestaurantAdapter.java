package com.example.fooding.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooding.LeveLOne;
import com.example.fooding.R;
import com.example.fooding.RestaurantSetting;
import com.example.fooding.data.DataCommon;
import com.example.fooding.data.Restaurant;

import java.util.List;


public class EatingRestaurantAdapter extends RecyclerView.Adapter<EatingRestaurantAdapter.ViewHolder> {
    private List<Restaurant> mdata;
    private Context mcontext;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ConstraintLayout constraintLayout;
        Button button_cancel;
        Button button_setting;
        ImageButton button_delete;
        public ViewHolder(View view) {
            super(view);
            title=view.findViewById(R.id.eating_restaurant_item_title);
            constraintLayout=view.findViewById(R.id.eating_restaurant_item_body);
            button_cancel=view.findViewById(R.id.eating_rest_re_it_but_cancel);
            button_delete=view.findViewById(R.id.eating_rest_re_it_but_delete);
            button_setting=view.findViewById(R.id.eating_rest_re_it_but_setting);
        }
    }

    public EatingRestaurantAdapter(List<Restaurant> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_eating_restaurant, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        if (mcontext == null) {
            mcontext = parent.getContext();
        }

        holder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Animation animation2= AnimationUtils.loadAnimation(mcontext,R.anim.show_form_zero);
                final Animation animation3= AnimationUtils.loadAnimation(mcontext,R.anim.show_form_zero);
                final Animation animation4= AnimationUtils.loadAnimation(mcontext,R.anim.show_form_zero);
                ObjectAnimator animator = ObjectAnimator.ofFloat(holder.constraintLayout,"scaleX",1, (float) 0.5);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(holder.constraintLayout,"translationX",1,-(float)(holder.constraintLayout.getWidth())/4);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(holder.title,"translationX",1,(float)(holder.title.getWidth())/2);
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(holder.title,"scaleX",1,2);
                animator.setDuration(420);
                animator2.setDuration(420);
                animator3.setDuration(420);
                animator4.setDuration(420);
                animator.start();
                animator2.start();
                animator3.start();
                animator4.start();
                animation2.setStartOffset(420);
                animation3.setStartOffset(480);
                animation4.setStartOffset(560);
                holder.button_cancel.startAnimation(animation4);
                holder.button_setting.startAnimation(animation3);
                holder.button_delete.startAnimation(animation2);
                return true;
            }
        });

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, LeveLOne.class);
                int position = holder.getAdapterPosition();
                Restaurant restaurant = mdata.get(position);
                intent.putExtra("name",restaurant.getName());
                mcontext.startActivity(intent);

            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Restaurant restaurant = mdata.get(position);
                Toast.makeText(mcontext,restaurant.getName(),Toast.LENGTH_SHORT).show();
                Toast.makeText(mcontext,"click",Toast.LENGTH_LONG).show();
            }
        });

        holder.button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation animation2= AnimationUtils.loadAnimation(mcontext,R.anim.show_to_zero);
                final Animation animation3= AnimationUtils.loadAnimation(mcontext,R.anim.show_to_zero);
                final Animation animation4= AnimationUtils.loadAnimation(mcontext,R.anim.show_to_zero);
                ObjectAnimator animator = ObjectAnimator.ofFloat(holder.constraintLayout,"scaleX",1,2);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(holder.constraintLayout,"translationX",1,(float)(holder.constraintLayout.getWidth())/4);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(holder.title,"scaleX",1,(float)0.5);
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(holder.title,"translationX",1,(float)(holder.title.getWidth())/4);

                animator.setStartDelay(420);
                animator2.setStartDelay(420);
                animator3.setStartDelay(420);
                animator4.setStartDelay(420);
                animator.setDuration(420);
                animator2.setDuration(420);
                animator3.setDuration(420);
                animator4.setDuration(420);
                animator.start();
                animator2.start();
                animator3.start();
                animator4.start();
                animation3.setStartOffset(60);
                animation4.setStartOffset(120);
                holder.button_cancel.startAnimation(animation4);
                holder.button_setting.startAnimation(animation3);
                holder.button_delete.startAnimation(animation2);
            }
        });

        holder.button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, RestaurantSetting.class);
                int position = holder.getAdapterPosition();
                Restaurant restaurant = mdata.get(position);
                intent.putExtra("name",restaurant.getName());
                mcontext.startActivity(intent);

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = mdata.get(position);
        holder.title.setText(restaurant.getName());
        holder.constraintLayout.setBackgroundColor(Color.parseColor(restaurant.getColor()));

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
