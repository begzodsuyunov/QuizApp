package com.example.quizapp.contract.recordImpl;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.quizapp.contract.Contract;

import java.util.Arrays;

public class ModelRecord implements Contract.RecordModel {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String FILE_NAME = "GAME4";

    public ModelRecord(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public int[] readRecord() {
        int[] n = new int[10];
        String s = sharedPreferences.getString("s", "");
        if (!s.equals("")) {
            String[] split = s.split("");
            for (int i = 0; i < split.length; i++) {
                int parseInt = Integer.parseInt(split[i]);
                n[i] = parseInt;
            }
            Arrays.sort(n);
        }
        return n;
    }
}
