package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.storage.StorageManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;

import org.litepal.LitePal;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        TextView textView= findViewById(R.id.the_welcome_word);

        final Animation animation1= AnimationUtils.loadAnimation(this,R.anim.welcome_anim);
        animation1.setInterpolator(new AnticipateOvershootInterpolator());
        textView.startAnimation(animation1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },2000);

        SharedPreferences sp=getPreferences(MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst",true);

        if (isFirst) {

            sp.edit().putBoolean("isFirst",false).commit();

            LitePal.getDatabase();
            String r_name[] = {"中心", "延生", "樱花", "千喜鹤", "大西北", "莘莘"};
            String z_s_name[] = {"中心食堂"};
            String z_s_food[] = {"小面","米线","精品大众餐","不忘出茶"};
            String shenshen_s[] = {"自选餐", "香香米", "大众餐", "面", "粉", "冒菜"};
            String yansheng_s[] = {"精品大众餐", "铁板炒饭", "膳善堂", "烤状元", "蛋包饭", "牛肉饭", "心意饺坊", "冒菜"};
            String yansheng_s_f1[] = {"精品大众餐"};
            String yansheng_s_f2[] = {"蛋炒饭","火腿蛋炒饭","培根蛋炒饭","虾仁蛋炒饭","xxx炒饭","金针菇盖饭","xxx盖饭","xxx盖饭"};
            String yansheng_s_f3[] = {"xxxxx盖饭","xxx盖饭","xxxxx盖饭","xx盖饭","xxx盖饭","xxxxx盖饭","xxx盖饭","xxx盖饭","xxx盖饭"};
            String yansheng_s_f4[] = { "xx烤肉饭","xx烤肉饭","xx烤肉饭","xxxxx烤肉饭","xx烤肉饭", "xxxx锡纸饭","xx锡纸饭","xxxx锡纸饭","xxxx锡纸饭"};
            String yansheng_s_f5[] = {"蛋包饭"};
            String yansheng_s_f6[] = {"xxxx牛肉饭","xxxx牛肉饭","xxxx牛肉饭","xxxx牛肉饭","xxx牛肉饭","xx牛肉饭","xx牛肉饭"};
            String yansheng_s_f7[] = {"xxx饺子","xxx饺子","xxx饺子","xxx饺子","xxx混沌","xxx混沌","xxx肠粉","xxx肠粉","xxx肠粉" };
            String yansheng_s_f8[] = { "xx冒菜","xx冒菜","xx冒菜"};

            String r_color[] = {"#E31D1D", "#556CEA", "#556CEA", "#51D856", "#F1DD2E", "#FF03DAC5"};

            for (int i = 0; i < r_name.length; i++) {
                Restaurant restaurant = new Restaurant();
                restaurant.setName(r_name[i]);
                restaurant.setMod(1);
                restaurant.setId(10000 + i);
                restaurant.setBackground(r_color[i]);
                restaurant.setColor(r_color[i]);
                restaurant.save();
            }

            for(int i=0;i<z_s_name.length;i++){
                Store store = new Store();
                store.setName(z_s_name[i]);
                store.setUp("中心");
                store.setId(20100+i);
                store.save();
            }
            for(int i=0;i<shenshen_s.length;i++){
                Store store = new Store();
                store.setName(shenshen_s[i]);
                store.setUp("莘莘");
                store.setId(20200+i);
                store.save();
            }
             for(int i=0;i<yansheng_s.length;i++){
                Store store = new Store();
                store.setName(yansheng_s[i]);
                store.setUp("延生");
                store.setId(20300+i);
                store.save();
            }

        }


    }
}