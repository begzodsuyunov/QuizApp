package com.example.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class DialogFinish extends AlertDialog {

    private OnButtonClickListener onButtonClickListener;

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public boolean hasListener(){
        return onButtonClickListener != null;
    }

    protected DialogFinish(@NonNull Context context) {
        super(context);
    }

    private int totalCount;
    private int rightAnswer;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    private Button restart;
    private Button finish;
    private TextView totalCountTv;
    private TextView rightAnswerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_finish);
        loadViews();
        setCancelable(false);
        totalCountTv.setText(String.valueOf(totalCount));
        rightAnswerTv.setText(String.valueOf(rightAnswer));

        restart.setOnClickListener(v -> {
            if (hasListener()){
                onButtonClickListener.onClickRestart();
            }
        });

        finish.setOnClickListener(v ->{
            if (hasListener()){
                onButtonClickListener.onClickFinish();
            }
        });
    }

    private void loadViews() {
        restart = findViewById(R.id.restart);
        finish = findViewById(R.id.finish);
        totalCountTv = findViewById(R.id.total_count);
        rightAnswerTv = findViewById(R.id.right_answer);
    }
    public interface OnButtonClickListener{
        void onClickRestart();
        void onClickFinish();
    }

}
