package com.example.quizapp.contract;

import com.example.quizapp.models.TestData;

public interface Contract {

    interface RecordView{
        void setRecord(int[] n);
    }

    interface RecordModel{
        int[] readRecord();

    }

    interface RecordPresenter{
        void setRecord();
    }
}
