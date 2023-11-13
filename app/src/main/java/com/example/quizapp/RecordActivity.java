package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizapp.contract.Contract;
import com.example.quizapp.contract.recordImpl.ModelRecord;
import com.example.quizapp.contract.recordImpl.PresenterRecord;

public class RecordActivity extends AppCompatActivity implements Contract.RecordView {

    private Contract.RecordPresenter presenter;
    private TextView record1;
    private TextView record2;
    private TextView record3;
    private TextView record4;
    private TextView record5;
    private TextView record6;
    private TextView record7;
    private TextView record8;
    private TextView record9;
    private TextView record10;
    private ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        presenter = new PresenterRecord(this, new ModelRecord(this));

        loadView();
        presenter.setRecord();
    }
    private void loadView() {
        record1 = findViewById(R.id.record1);
        record2 = findViewById(R.id.record2);
        record3 = findViewById(R.id.record3);
        record4 = findViewById(R.id.record4);
        record5 = findViewById(R.id.record5);
        record6 = findViewById(R.id.record6);
        record7 = findViewById(R.id.record7);
        record8 = findViewById(R.id.record8);
        record9 = findViewById(R.id.record9);
        record10 = findViewById(R.id.record10);
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void setRecord(int[] ints) {
        if (ints[9] != 0) {
            record1.setText(String.valueOf(ints[9]) + "/" + 10);
        }
        if (ints[8] != 0) {
            record2.setText(String.valueOf(ints[8])+"/"+10);
        }
        if (ints[7] != 0) {
            record3.setText(String.valueOf(ints[7])+"/"+10);
        }
        if (ints[6] != 0) {
            record4.setText(String.valueOf(ints[6])+"/"+10);
        }
        if (ints[5] != 0) {
            record5.setText(String.valueOf(ints[5])+"/"+10);
        }
        if (ints[4] != 0) {
            record6.setText(String.valueOf(ints[4])+"/"+10);
        }
        if (ints[3] != 0) {
            record7.setText(String.valueOf(ints[3])+"/"+10);
        } if (ints[2] != 0) {
            record8.setText(String.valueOf(ints[2])+"/"+10);
        } if (ints[1] != 0) {
            record9.setText(String.valueOf(ints[1])+"/"+10);
        }
        if (ints[0] != 0) {
            record10.setText(String.valueOf(ints[0])+"/"+10);
        }

    }
}