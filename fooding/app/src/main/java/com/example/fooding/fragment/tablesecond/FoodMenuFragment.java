package com.example.fooding.fragment.tablesecond;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooding.R;
import com.example.fooding.adapter.TabRestaurantRecyclerAdapter;
import com.example.fooding.adapter.TabStoreRecyclerAdapter;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;
import com.google.android.material.tabs.TabLayout;

import org.litepal.LitePal;

import java.util.List;

public class FoodMenuFragment extends Fragment {
    View view;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food_menu, container, false);
        recyclerView1 = view.findViewById(R.id.tab_table_restaurant);
        recyclerView2 = view.findViewById(R.id.tab_table_stores);

        List<Store> stores = LitePal.findAll(Store.class);
        List<Restaurant> restaurants = LitePal.findAll(Restaurant.class);

        TabRestaurantRecyclerAdapter tabRestaurantRecyclerAdapter= new TabRestaurantRecyclerAdapter(restaurants);
        TabStoreRecyclerAdapter tabStoreRecyclerAdapter = new TabStoreRecyclerAdapter(stores);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView1.setAdapter(tabRestaurantRecyclerAdapter);
        recyclerView2.setAdapter(tabStoreRecyclerAdapter);



        return view;
    }

    private void showResponse(int num) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = num;
                handler.sendMessage(message);
            }
        }).start();
    }


}