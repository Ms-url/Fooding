package com.example.fooding.fragment.eatingsecond;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fooding.R;
import com.example.fooding.adapter.StyleAdapter;
import com.example.fooding.data.DataCommon;
import com.example.fooding.data.Restaurant;

import java.util.ArrayList;
import java.util.List;


public class StyleFragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<Restaurant> list = new ArrayList<>();
    private StyleAdapter dataAdapter = new StyleAdapter(list);
    private String responseData;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(dataAdapter);
                    Log.e("handler recycler 系列log","StyleFragment UI charge");
                    break;

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_style, container, false);
        recyclerView = view.findViewById(R.id.style_recycler_view);

        showResponse(1);
        list.clear();
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