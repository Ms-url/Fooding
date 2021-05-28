package com.example.fooding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.storage.StorageManager;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.fooding.data.Food;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;

import org.litepal.LitePal;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        TextView textView = findViewById(R.id.the_welcome_word);
        TextView textView1 = findViewById(R.id.zhou);
        TextView textView2 = findViewById(R.id.ge);
        TextView textView3 = findViewById(R.id.chi);
        TextView textView4 = findViewById(R.id.huo);

       final Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.welcome_anim);
       final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.welcome_anim);
       final Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.welcome_anim);
       final Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.welcome_anim);
        animation1.setInterpolator(new AnticipateOvershootInterpolator());
        animation2.setInterpolator(new AnticipateOvershootInterpolator());
        animation3.setInterpolator(new AnticipateOvershootInterpolator());
        animation4.setInterpolator(new AnticipateOvershootInterpolator());
        animation2.setStartOffset(600);
        animation3.setStartOffset(600);
        animation4.setStartOffset(600);
        textView1.startAnimation(animation1);
        textView2.startAnimation(animation1);
        textView3.startAnimation(animation1);
        textView4.startAnimation(animation1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 2400);

        SharedPreferences sp = getSharedPreferences("cook_data", MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst", true);

        if (isFirst) {
            sp.edit().putBoolean("isFirst", false).commit();
            LitePal.getDatabase();

            String whole_store[][] = {
                    {"中心","小面", "米线", "精品大众餐", "不忘出茶"},
                    {"延生","精品大众餐-延生", "铁板炒饭", "膳善堂", "烤状元", "蛋包饭", "f牛肉饭", "心意饺坊", "渝运冒菜"},
                    {"莘莘","自选餐", "香香米", "大众餐", "面", "粉", "冒菜"},
                    {"千喜鹤","千喜鹤"},
                    {"大西北","大西北"},
                    {"樱花","樱花"}
            };

            String whole_food[][]={
                    {"精品大众餐-延生","精品大众餐"},
                    {"铁板炒饭","蛋炒饭", "火腿蛋炒饭", "培根蛋炒饭", "虾仁蛋炒饭", "xxx炒饭", "金针菇盖饭", "xxx盖饭", "xxx盖饭"},
                    { "膳善堂","xxxxx盖饭", "xxx盖饭", "xxxxx盖饭", "xx盖饭", "xxx盖饭", "xxxxx盖饭", "xxx盖饭", "xxx盖饭", "xxx盖饭"},
                    { "烤状元","xx烤肉饭", "xx烤肉饭", "xx烤肉饭", "xxxxx烤肉饭", "xx烤肉饭", "xxxx锡纸饭", "xx锡纸饭", "xxxx锡纸饭", "xxxx锡纸饭"},
                    { "蛋包饭","蛋包饭"},
                    {"f牛肉饭","xxxx牛肉饭", "xxxx牛肉饭", "xxxx牛肉饭", "xxxx牛肉饭", "xxx牛肉饭", "xx牛肉饭", "xx牛肉饭"},
                    { "心意饺坊","xxx饺子", "xxx饺子", "xxx饺子", "xxx饺子", "xxx混沌", "xxx混沌", "xxx肠粉", "xxx肠粉", "xxx肠粉"},
                    { "渝运冒菜","xx冒菜", "xx冒菜", "xx冒菜"}

            };
            String r_color[] = {"#E31D1D", "#556CEA","#10AFA0" , "#51D856", "#F1DD2E", "#F63073"};

            for(int i=0;i<whole_store.length;i++){
                Restaurant restaurant = new Restaurant();
                restaurant.setName(whole_store[i][0]);
                restaurant.setMod(1);
                restaurant.setId(10001 + i);
                restaurant.setBackground(r_color[i]);
                restaurant.setColor(r_color[i]);
                restaurant.save();

                for(int k=1;k<whole_store[i].length;k++){
                    Store store = new Store();
                    store.setName(whole_store[i][k]);
                    store.setUp(whole_store[i][0]);
                    store.setName(whole_store[i][k]);
                    store.setId(20000+k);
                    store.save();
                    Log.e("jkjkjkjkjkj","jkjk-----");
                }
            }


            for(int i=0;i<whole_food.length;i++){
                for(int k=1;k<whole_food[i].length;k++){
                    Food food = new Food();
                    food.setName(whole_food[i][k]);
                    food.setStore(whole_food[i][0]);
                    food.setName(whole_food[i][k]);
                    food.setId(30000+k);
                    food.save();
                    Log.e("ghghhghghgh","hghghgh-----");
                }
            }

        }


    }
}