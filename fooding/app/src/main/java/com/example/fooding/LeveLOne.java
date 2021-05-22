package com.example.fooding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.fooding.adapter.EatingRestaurantAdapter;
import com.example.fooding.adapter.LevelOneReLeftAdapter;
import com.example.fooding.adapter.LevelOneReRigthAdapter;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;
import com.example.fooding.fragment.eatingsecond.LocationFragment;
import com.example.fooding.unit.SpacesItemDecoration;

import org.litepal.LitePal;

import java.util.List;

public class LeveLOne extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    TextView textView_title;
    int hi;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hi = constraintLayout.getMeasuredHeight();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leve_l_one);
        constraintLayout = findViewById(R.id.level_one_answer_body);
        textView_title = findViewById(R.id.level_one_answer_title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                hi = constraintLayout.getMeasuredHeight();
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(constraintLayout, "translationY", 0, -hi + 106 * 2);
                animator1.setStartDelay(100);
                animator1.setDuration(1000);
                animator1.start();
                Log.e("this is function", String.valueOf(hi));
                constraintLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            }
        });


        Intent intent = getIntent();
        String rest_name = intent.getStringExtra("name");
        String rest_color = intent.getStringExtra("color");

        textView_title.setText(rest_name);
        constraintLayout.setBackgroundColor(Color.parseColor(rest_color));

        RecyclerView recyclerView1 = findViewById(R.id.level_one_right_recycler);
        RecyclerView recyclerView2 = findViewById(R.id.level_one_left_recycler);
        List<Store> stores = LitePal.where("up=?", rest_name).find(Store.class);
        Log.e("kkkkkkkkkk", String.valueOf(stores.size()));

        LevelOneReRigthAdapter dataAdapter = new LevelOneReRigthAdapter(stores);
        LevelOneReLeftAdapter adapter = new LevelOneReLeftAdapter(stores);

        recyclerView1.addItemDecoration(new SpacesItemDecoration(12));
        recyclerView2.addItemDecoration(new SpacesItemDecoration(12));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView1.setAdapter(dataAdapter);
        recyclerView2.setAdapter(adapter);

    }
}