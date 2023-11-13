package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.contract.QuizContract;
import com.example.quizapp.contract.impl.ModelMainImpl;
import com.example.quizapp.contract.impl.PresenterMainImpl;
import com.example.quizapp.models.TestData;
import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements QuizContract.View {

    private Button btnNext;
    private TextView textQuestion;
    private TextView textTestState;
    private List<MaterialRadioButton> radioButtons;
    private QuizContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        int n = extras.getInt("n");
        presenter = new PresenterMainImpl(this,new ModelMainImpl(this),n);

    }

    @Override
    public void initViews() {
        radioButtons = new ArrayList<>();
        radioButtons.add(findViewById(R.id.radioA));
        radioButtons.add(findViewById(R.id.radioB));
        radioButtons.add(findViewById(R.id.radioC));
        radioButtons.add(findViewById(R.id.radioD));
        btnNext = findViewById(R.id.next_btn);
        btnNext.setEnabled(false);
        btnNext.setOnClickListener(v -> presenter.nextQuestion());
        textQuestion = findViewById(R.id.textQuestion);
        textTestState = findViewById(R.id.textState);
        initCheckersListener();
        findViewById(R.id.back_btn).setOnClickListener(v -> {presenter.finish();});
    }
    private void initCheckersListener() {
        for (int i = 0; i < radioButtons.size(); i++) {
            MaterialRadioButton radioButton = radioButtons.get(i);
            radioButton.setTag(i);
            radioButton.setOnClickListener(v -> presenter.selectedAnswer((Integer) v.getTag()));
        }
    }
    @Override
    public void loadQuestion(TestData testData) {
        textQuestion.setText(testData.getQuestion());
        radioButtons.get(0).setText(testData.getVariantA());
        radioButtons.get(1).setText(testData.getVariantB());
        radioButtons.get(2).setText(testData.getVariantC());
        radioButtons.get(3).setText(testData.getVariantD());
    }

    public void clearCheck(int position) {
        radioButtons.get(position).setChecked(false);
    }


    @Override
    public void changeState(int currentQuestionIndex, int totalQuestionIndex) {
        textTestState.setText(currentQuestionIndex+"/"+totalQuestionIndex);

    }

    @Override
    public void nextButtonState(boolean state) {
        btnNext.setEnabled(state);
    }

    @Override
    public void result(int correctAnswerCount, int totalQuestionCount) {
        DialogFinish dialogFinish = new DialogFinish(this);
        dialogFinish.setRightAnswer(correctAnswerCount);
        dialogFinish.setTotalCount(totalQuestionCount);
        dialogFinish.setOnButtonClickListener(new DialogFinish.OnButtonClickListener() {
            @Override
            public void onClickRestart() {
                presenter.restart();
                dialogFinish.dismiss();
            }

            @Override
            public void onClickFinish() {
                finish();
                dialogFinish.dismiss();
            }
        });
        dialogFinish.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogFinish.show();
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void setFinishbtn(String str) {
        btnNext.setText(str);

    }

    @Override
    public void onBackPressed() {
        DialogExit dialogExit = new DialogExit(this);
        dialogExit.setOnButtonClickListener(new DialogExit.OnButtonClickListener() {
            @Override
            public void onClickOk() {
                finish();
                dialogExit.dismiss();
            }

            @Override
            public void onClickCancel() {
                dialogExit.dismiss();
            }
        });
        dialogExit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogExit.show();
    }
}