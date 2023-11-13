package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {

    private ImageView back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v ->{
            finish();
        });
    }
}