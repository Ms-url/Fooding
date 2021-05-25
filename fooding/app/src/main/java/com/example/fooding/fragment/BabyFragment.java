package com.example.fooding.fragment;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooding.R;
import com.example.fooding.data.Food;
import com.example.fooding.data.Restaurant;
import com.example.fooding.data.Store;

import org.litepal.LitePal;

import static android.content.Context.MODE_PRIVATE;


public class BabyFragment extends Fragment {
    View view;
    Button button_init;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baby, container, false);
        button_init = view.findViewById(R.id.bt_init);

        button_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Restaurant.class);
                LitePal.deleteAll(Store.class);
                LitePal.deleteAll(Food.class);
                SharedPreferences.Editor init = getActivity().getSharedPreferences("cook_data", MODE_PRIVATE).edit();
                init.putBoolean("isFirst", true).apply();

            }
        });


        final Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.scan_circle);
        final Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.scan_circle);
        final Animation animation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.scan_circle);
        final Animation animation4 = AnimationUtils.loadAnimation(getActivity(), R.anim.scan_circle);
        //   final Animation animation5= AnimationUtils.loadAnimation(getActivity(),R.anim.sleep);
        //   final Animation animation6= AnimationUtils.loadAnimation(getActivity(),R.anim.sleep);
        //   final Animation animation7= AnimationUtils.loadAnimation(getActivity(),R.anim.sleep);

        final ImageView imageView1 = view.findViewById(R.id.circle1);
        final ImageView imageView2 = view.findViewById(R.id.circle2);
        final ImageView imageView3 = view.findViewById(R.id.circle3);
        final ImageView imageView4 = view.findViewById(R.id.circle4);
        //   final TextView textView1 = view.findViewById(R.id.sleep1);
        //   final TextView textView2 = view.findViewById(R.id.sleep2);
        //   final TextView textView3 = view.findViewById(R.id.sleep3);

     /*   textView1.startAnimation(animation5);
        animation6.setStartOffset(800);
        textView2.startAnimation(animation6);
        animation7.setStartOffset(1600);
        textView3.startAnimation(animation7);
     */
        animation1.setInterpolator(new LinearInterpolator());
        animation2.setInterpolator(new LinearInterpolator());
        animation3.setInterpolator(new LinearInterpolator());
        animation4.setInterpolator(new LinearInterpolator());

        ImageButton imageButton = view.findViewById(R.id.baby_body);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageButton, "rotation", 0, 15, 0, -15, 0, 15, 0);
                animator1.setStartDelay(100);
                animator1.setDuration(1000);
                animator1.start();

                Toast.makeText(getActivity(), "API尚未写入", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();

                imageView1.startAnimation(animation1);

                animation2.setStartOffset(800);
                imageView2.startAnimation(animation2);

                animation3.setStartOffset(1800);
                imageView3.startAnimation(animation3);

                animation4.setStartOffset(2800);
                imageView4.startAnimation(animation4);
            }
        });
        return view;
    }
}