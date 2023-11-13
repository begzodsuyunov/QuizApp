package com.example.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;


public class DialogExit extends AlertDialog {

    protected DialogExit(@NonNull Context context) {
        super(context);
    }


    private OnButtonClickListener onButtonClickListener;

    public void setOnButtonClickListener(OnButtonClickListener onButtomClickListener) {
        this.onButtonClickListener = onButtomClickListener;
    }


    public boolean hasListener() {
        return onButtonClickListener != null;
    }



    private TextView ok;
    private TextView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_exit1);

        loadView();

        setCancelable(false);
        cancel.setOnClickListener(v -> {
            if (hasListener()) {
                onButtonClickListener.onClickCancel();
            }
        });

        ok.setOnClickListener(v -> {
            if (hasListener()) {
                onButtonClickListener.onClickOk();
            }
        });
    }

    private void loadView() {
        cancel = findViewById(R.id.cancel_btn);
        ok = findViewById(R.id.ok_btn);
    }

    interface OnButtonClickListener {
        void onClickOk();
        void onClickCancel();
    }
}
