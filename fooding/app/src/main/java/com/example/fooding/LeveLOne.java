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
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView textView_answer;
    Button button_begin;
    ImageButton imageButton_cancel;
    ImageButton imageButton_restart;
    ImageView imageView;
    ImageView imageView1;
    int hi;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hi = constraintLayout.getMeasuredHeight();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    imageView.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.VISIBLE);
                    textView_answer.setVisibility(View.VISIBLE);
                    button_begin.setClickable(false);
                    break;
                case 2:
                    button_begin.setClickable(true);
                    break;
                case 3:

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leve_l_one);
        constraintLayout = findViewById(R.id.level_one_answer_body);
        textView_title = findViewById(R.id.level_one_answer_title);
        button_begin = findViewById(R.id.begin_bt);
        imageView = findViewById(R.id.level_one_answer_imageView);
        imageView1 = findViewById(R.id.level_one_answer_imageView_s);
        textView_answer = findViewById(R.id.level_one_answer_answer);
        imageButton_cancel = findViewById(R.id.level_one_cancle_button);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null)actionBar.hide();
        imageView.setVisibility(View.GONE);
        imageView1.setVisibility(View.GONE);
        textView_answer.setVisibility(View.GONE);

        imageButton_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(constraintLayout, "translationY", 0, -hi + 91 * 2);
                animator1.setStartDelay(100);
                animator1.setDuration(1000);
                animator1.start();
                showResponse(2);
            }
        });

        imageButton_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 15, 0, -15, 0, 15, 0);
                animator1.setStartDelay(100);
                animator1.setDuration(1000);
                animator1.start();
            }
        });

        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                hi = constraintLayout.getMeasuredHeight();
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(constraintLayout, "translationY", 0, -hi + 91 * 2);
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

        button_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(constraintLayout, "translationY", -hi + 106 * 2,0);
                animator1.setStartDelay(100);
                animator1.setDuration(1000);
                animator1.start();



                showResponse(1);
            }
        });

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