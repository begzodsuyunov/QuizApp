package com.example.quizapp.contract;

public interface MenuContract {
    interface ViewSecond{
        void setRecord(int record,int totalCount);

        void intent(int n);

//        void showDialog();

        void intentRecord();
    }

    interface ModelSecond{


    }

    interface PresenterSecond{

        void intentAddQuestion();
        void intentSubtractQuestion();
        void intentMultiplyQuestion();
        void intentDivideQuestion();
        void intentRecord();
    }
}
