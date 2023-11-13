package com.example.quizapp.contract.impl;

import android.content.Context;

import com.example.quizapp.contract.QuizContract;
import com.example.quizapp.models.TestData;

public class PresenterMainImpl implements QuizContract.Presenter {

    private QuizContract.View view;
    private QuizContract.Model model;
    private Context context;
    private int totalCount;
    private int index = 0;
    private int selectedAnswer = -1;
    private int correctAnswers = 0;
    private int n;

    public PresenterMainImpl(QuizContract.View view, QuizContract.Model model,int n) {
        this.view = view;
        this.model = model;
        this.n = n;
        init(n);

    }

    @Override
    public void selectedAnswer(int position) {
        view.nextButtonState(true);
        if (selectedAnswer > -1 && selectedAnswer != position) {
            view.clearCheck(selectedAnswer);
        }
        selectedAnswer = position;
    }

    @Override
    public void nextQuestion() {
        boolean isCompleted = isTestCompleted();
        if (isCompleted) {
            view.result(correctAnswers, totalCount);
            model.writeRecord(correctAnswers);
            return;
        }
        if (totalCount -2 == index){
            view.setFinishbtn("Finish");
        }

        index++;
        view.clearCheck(selectedAnswer);
        selectedAnswer = -1;
        view.nextButtonState(false);
        TestData question = model.getQuestion(index);
        view.loadQuestion(question);
        view.changeState(index + 1, totalCount);
    }

    private boolean isTestCompleted() {
        TestData testData = model.getQuestion(index);
        String userAnswer;
        switch (selectedAnswer) {
            case 0:
                userAnswer = testData.getVariantA();
                break;
            case 1:
                userAnswer = testData.getVariantB();
                break;
            case 2:
                userAnswer = testData.getVariantC();
                break;
            default:
                userAnswer = testData.getVariantD();
        }

        if (testData.getAnswer().equals(userAnswer))
            correctAnswers++;

        return totalCount - 1 == index;
    }

    @Override
    public void init(int n) {
        view.initViews();
        model.initQuestion(n);
        model.shuffle();
        view.nextButtonState(false);
        totalCount = model.totalCount();
        view.loadQuestion(model.getQuestion(index));
        view.changeState(index + 1, totalCount);
        view.setFinishbtn("Next");
    }

    @Override
    public void restart() {
        index = 0;
        correctAnswers = 0;
        view.clearCheck(selectedAnswer);
        selectedAnswer = -1;
        view.initViews();
        model.initQuestion(n);
        model.shuffle();
        view.nextButtonState(false);
        totalCount = model.totalCount();
        view.loadQuestion(model.getQuestion(index));
        view.changeState(index + 1, totalCount);
        view.setFinishbtn("Next");
    }

    @Override
    public void finish() {
        view.finishView();
    }
}
