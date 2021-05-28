package com.example.fooding.fragment.eatingsecond;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooding.R;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class CountFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_count, container, false);
        PieChart pieChart = view.findViewById(R.id.restaurant_count_chart);

        List<Restaurant> restaurantss = LitePal.findAll(Restaurant.class);
        for (int i=0;i<restaurantss.size();i++) {
            Restaurant re = restaurantss.get(i);
            re.setCount(i+1);
        }

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        List<Restaurant> restaurants = LitePal.findAll(Restaurant.class);
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant r = restaurants.get(i);
            pieEntries.add(new PieEntry(Float.parseFloat(String.valueOf(r.getCount())), r.getName()));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntries, null);
        pieDataSet.setSliceSpace(1);
        pieDataSet.getSelectionShift();

        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(true);
        pieData.setValueTextColor(Color.WHITE);
        pieData.setValueTextSize(12f);
        pieData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return super.getFormattedValue(value);

            }
        });
        pieChart.setData(pieData);
        pieChart.highlightValues(null);
        pieChart.invalidate();


        return view;
    }
}