package com.example.fooding.fragment.eatingsecond;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView recyclerView;
    List<Restaurant> restaurants = LitePal.findAll(Restaurant.class);
    private EatingRestaurantAdapter dataAdapter = new EatingRestaurantAdapter(restaurants);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_restaurant, container, false);
        recyclerView=view.findViewById(R.id.eating_restaurant_recycler);
        recyclerView.addItemDecoration(new SpacesItemDecoration(12));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);

        return view;
    }
}