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

import java.util.ArrayList;
import java.util.List;


public class StyleFragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<DataCommon> list = new ArrayList<>();
    private StyleAdapter dataAdapter = new StyleAdapter(list);
    private String responseData;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(dataAdapter);
                    Log.e("kkkkkk","kkkkkkkkkk");
                    break;

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_style, container, false);
        recyclerView = view.findViewById(R.id.style_recycler_view);
        list.clear();

        list.add(new DataCommon("中心"));
        list.add(new DataCommon("大西北"));
        list.add(new DataCommon("酒吧"));
        showResponse(1);

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