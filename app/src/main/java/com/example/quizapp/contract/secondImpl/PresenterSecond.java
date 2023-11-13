package com.example.quizapp.contract.secondImpl;

import android.view.Menu;

import com.example.quizapp.contract.MenuContract;

public class PresenterSecond implements MenuContract.PresenterSecond {

    private MenuContract.ViewSecond viewSecond;

    private MenuContract.ModelSecond modelSecond;

    public PresenterSecond(MenuContract.ViewSecond viewSecond, MenuContract.ModelSecond modelSecond) {
        this.viewSecond = viewSecond;
        this.modelSecond = modelSecond;

    }

    @Override
    public void intentRecord() {
        viewSecond.intentRecord();
    }


    @Override
    public void intentAddQuestion() {
        viewSecond.intent(1);
    }

    @Override
    public void intentSubtractQuestion() {
        viewSecond.intent(2);
    }

    @Override
    public void intentMultiplyQuestion() {
        viewSecond.intent(3);
    }

    @Override
    public void intentDivideQuestion() {
        viewSecond.intent(4);
    }

}
