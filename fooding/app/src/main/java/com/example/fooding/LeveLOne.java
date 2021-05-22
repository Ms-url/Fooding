package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;

public class LeveLOne extends AppCompatActivity {

    RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leve_l_one);

        ActionBar actionBar = getActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }


    }
}