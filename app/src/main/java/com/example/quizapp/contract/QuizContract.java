package com.example.quizapp.contract;

import com.example.quizapp.models.TestData;

public interface QuizContract {

    interface Model{
        void initQuestion(int n);

        TestData getQuestion(int index);

        void shuffle();

        int totalCount();

        void writeRecord(int newRecord);

        int[] readRecord();
    }

    interface View{


        void initViews();

        void loadQuestion(TestData testData);

        void clearCheck(int position);

        void changeState(int currentQuestionIndex, int totalQuestionIndex);

        void nextButtonState(boolean state);

        void result(int correctAnswerCount, int totalQuestionCount);

        void finishView();


        void setFinishbtn(String str);
    }

    interface Presenter{
        void selectedAnswer(int position);

        void nextQuestion();

        void init(int n);

        void restart();

        void finish();
    }
}
