package com.example.fooding.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooding.R;


public class BabyFragment extends Fragment {
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_baby, container, false);

        final Animation animation1= AnimationUtils.loadAnimation(getActivity(),R.anim.scan_circle);
        final Animation animation2= AnimationUtils.loadAnimation(getActivity(),R.anim.scan_circle);
        final Animation animation3= AnimationUtils.loadAnimation(getActivity(),R.anim.scan_circle);
        final Animation animation4= AnimationUtils.loadAnimation(getActivity(),R.anim.scan_circle);
        final Animation animation5= AnimationUtils.loadAnimation(getActivity(),R.anim.sleep);
        final Animation animation6= AnimationUtils.loadAnimation(getActivity(),R.anim.sleep);
        final Animation animation7= AnimationUtils.loadAnimation(getActivity(),R.anim.sleep);

        final ImageView imageView1=view.findViewById(R.id.circle1);
        final ImageView imageView2=view.findViewById(R.id.circle2);
        final ImageView imageView3=view.findViewById(R.id.circle3);
        final ImageView imageView4=view.findViewById(R.id.circle4);
        final TextView textView1 = view.findViewById(R.id.sleep1);
        final TextView textView2 = view.findViewById(R.id.sleep2);
        final TextView textView3 = view.findViewById(R.id.sleep3);

        textView1.startAnimation(animation5);
        animation6.setStartOffset(800);
        textView2.startAnimation(animation6);
        animation7.setStartOffset(1600);
        textView3.startAnimation(animation7);

        animation1.setInterpolator(new LinearInterpolator());
        animation2.setInterpolator(new LinearInterpolator());
        animation3.setInterpolator(new LinearInterpolator());
        animation4.setInterpolator(new LinearInterpolator());

        ImageButton imageButton = view.findViewById(R.id.baby_body);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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