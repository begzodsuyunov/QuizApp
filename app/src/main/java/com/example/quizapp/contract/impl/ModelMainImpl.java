package com.example.quizapp.contract.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.quizapp.contract.QuizContract;
import com.example.quizapp.models.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ModelMainImpl implements QuizContract.Model {

    private List<TestData> questions;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String FILE_NAME = "GAME4";

    public ModelMainImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void initQuestion(int n) {
        questions = new ArrayList<>();
        if (n == 1) {
            questions.add(new TestData("14 + 9", "16", "23", "20", "18", "23"));
            questions.add(new TestData("21 + 12", "33", "29", "32", "36", "33"));
            questions.add(new TestData("19 + 8", "25", "27", "22", "33", "27"));
            questions.add(new TestData("12 + 7", "21", "18", "20", "19", "19"));
            questions.add(new TestData("16 + 28", "35", "34", "20", "28", "34"));
            questions.add(new TestData("17 + 5", "19", "22", "20", "25", "22"));
            questions.add(new TestData("16 + 35", "48", "46", "55", "51", "51"));
            questions.add(new TestData("12 + 28", "35", "28", "40", "44", "40"));
            questions.add(new TestData("17 + 25", "35", "39", "45", "42", "42"));
            questions.add(new TestData("19 + 45", "86", "64", "59", "65", "64"));
        }
        if (n == 2) {
            questions.add(new TestData("46 - 13 ", "35", "33", "42", "28", "33"));
            questions.add(new TestData("29 - 18", "16", "14", "10", "11", "11"));
            questions.add(new TestData("56 - 19", "29", "37", "35", "42", "37"));
            questions.add(new TestData("12 - 7", "3", "9", "5", "7", "5"));
            questions.add(new TestData("18 - 8", "10", "12", "8", "16", "10"));
            questions.add(new TestData("29 - 11", "12", "16", "19", "18", "18"));
            questions.add(new TestData("88 - 45", "43", "48", "40", "55", "43"));
            questions.add(new TestData("23 - 6", "17", "21", "15", "18", "17"));
            questions.add(new TestData("35 - 29", "10", "5", "6", "3", "6"));
            questions.add(new TestData("96 - 72", "24", "31", "36", "28", "24"));
        }
        if (n == 3) {
            questions.add(new TestData("4 * 2 ", "16", "6", "20", "8", "8"));
            questions.add(new TestData("7 * 3", "16", "14", "21", "18", "21"));
            questions.add(new TestData("5 * 8", "45", "40", "35", "50", "40"));
            questions.add(new TestData("12 * 7", "76", "96", "84", "92", "84"));
            questions.add(new TestData("16 * 4", "64", "56", "68", "54", "64"));
            questions.add(new TestData("16 * 9", "124", "136", "144", "148", "144"));
            questions.add(new TestData("48 * 2", "96", "90", "92", "98", "96"));
            questions.add(new TestData("8 * 7", "64", "48", "56", "40", "56"));
            questions.add(new TestData("21 * 3", "63", "72", "54", "68", "63"));
            questions.add(new TestData("9 * 7", "54", "63", "72", "45", "63"));
        }
        if (n == 4){
            questions.add(new TestData("84 / 3 ", "16", "24", "36", "28", "28"));
            questions.add(new TestData("64 / 4", "16", "14", "21", "18", "16"));
            questions.add(new TestData("72 / 8", "12", "9", "8", "11", "9"));
            questions.add(new TestData("36 / 3", "14", "12", "16", "13", "12"));
            questions.add(new TestData("42 / 7", "6", "5", "7", "8", "6"));
            questions.add(new TestData("54 / 2", "17", "23", "24", "27", "27"));
            questions.add(new TestData("48 / 8", "9", "8", "7", "6", "6"));
            questions.add(new TestData("78 / 3", "22", "24", "26", "29", "26"));
            questions.add(new TestData("21 * 7", "4", "3", "2", "5", "3"));
            questions.add(new TestData("81 / 9", "9", "8", "11", "14", "9"));
        }
    }

    @Override
    public TestData getQuestion(int index) {
        return questions.get(index);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(questions);
    }

    @Override
    public int totalCount() {
        return questions.size();
    }

    @Override
    public void writeRecord(int newRecord) {
        int[] ints = readRecord();
        if (ints[9] != 0){
            if (ints[0] < newRecord){
                ints[0] = newRecord;
            }
        }else {
            for (int i = 0; i < 10; i++) {
                if (ints[i] == 0){
                    ints[i] = newRecord;
                    break;
                }
            }
        }
        Arrays.sort(ints);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(ints[i]);
        }
        String s = stringBuffer.toString();
        editor.putString("s", s);
        editor.apply();
    }

    @Override
    public int[] readRecord() {
        int[] n = new int[10];
        String s = sharedPreferences.getString("s", "");
        if (!s.equals("")) {
            String[] split = s.split("");
            for (int i = 0; i < split.length; i++) {
                int a = Integer.parseInt(split[i]);
                n[i] = a;
            }
            Arrays.sort(n);
        }
        return n;
    }
}
