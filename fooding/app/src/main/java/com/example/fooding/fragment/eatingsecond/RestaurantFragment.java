package com.example.fooding.fragment.eatingsecond;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooding.R;
import com.example.fooding.adapter.EatingRestaurantAdapter;
import com.example.fooding.data.Restaurant;
import com.example.fooding.unit.SpacesItemDecoration;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment extends Fragment {
    View view;
    SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    List<Restaurant> restaurants = LitePal.findAll(Restaurant.class);
    private EatingRestaurantAdapter dataAdapter = new EatingRestaurantAdapter(restaurants);

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    restaurants = LitePal.findAll(Restaurant.class);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(dataAdapter);
                    swipeRefreshLayout.setRefreshing(false);
                    break;

            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_main);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        recyclerView = view.findViewById(R.id.eating_restaurant_recycler);
        recyclerView.addItemDecoration(new SpacesItemDecoration(15));

        showResponse(1);

        return view;
    }

    protected void refresh() {
        showResponse(1);
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