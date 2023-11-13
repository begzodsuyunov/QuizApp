package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.contract.MenuContract;
import com.example.quizapp.contract.secondImpl.ModelSecondImpl;
import com.example.quizapp.contract.secondImpl.PresenterSecond;

public class SecondActivity extends AppCompatActivity implements MenuContract.ViewSecond {

    private MenuContract.PresenterSecond presenterSecond;

    private TextView record;
    private Button btnAbout;
    private Button addQuestion;
    private Button subtractQuestion;
    private Button multiplyQuestion;
    private Button divideQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        presenterSecond = new PresenterSecond(this,new ModelSecondImpl(this));
        loadViews();

    }


    public void loadViews() {
        record = findViewById(R.id.record);
        btnAbout = findViewById(R.id.about_btn);
        addQuestion = findViewById(R.id.add_question);
        subtractQuestion = findViewById(R.id.subtract_question);
        multiplyQuestion = findViewById(R.id.multiply_question);
        divideQuestion = findViewById(R.id.divide_question);


        addQuestion.setOnClickListener(v -> {
            presenterSecond.intentAddQuestion();
        });
        subtractQuestion.setOnClickListener(v -> {
            presenterSecond.intentSubtractQuestion();
        });
        multiplyQuestion.setOnClickListener(v ->{
            presenterSecond.intentMultiplyQuestion();
        });

        divideQuestion.setOnClickListener(v ->{
            presenterSecond.intentDivideQuestion();
        });
        record.setOnClickListener(v -> {
            presenterSecond.intentRecord();
        });

        btnAbout.setOnClickListener(v ->{
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void setRecord(int record,int totalCount) {
        this.record.setText(record+"/"+totalCount);
    }


    @Override
    public void intent(int n) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("n",n);
        startActivity(intent);
    }

    @Override
    public void intentRecord() {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }

}