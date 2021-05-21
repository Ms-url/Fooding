package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.fooding.data.Restaurant;

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
        }


    }
}