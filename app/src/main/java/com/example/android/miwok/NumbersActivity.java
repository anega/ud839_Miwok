package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        int i = 0;
        for (String word:
             words) {
            Log.v("Jopka", "Word at index " + (i++) + ": " + word);
        }
    }
}
