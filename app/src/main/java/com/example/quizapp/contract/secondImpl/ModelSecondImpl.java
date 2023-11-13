package com.example.quizapp.contract.secondImpl;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.quizapp.contract.MenuContract;

public class ModelSecondImpl implements MenuContract.ModelSecond {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String FILE_NAME = "GAME4";

    public ModelSecondImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}
