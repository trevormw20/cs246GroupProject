package com.example.retailstoresurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static int languageChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickChooseLangEng(View view) {
        languageChoice = 1;
        Intent intent = new Intent(this, ChooseRetailOrOnlineActivity.class);
        startActivity(intent);
    }
    public void onClickChooseLangUkr(View view) {
        languageChoice = 2;
        Intent intent = new Intent(this, ChooseRetailOrOnlineActivity.class);
        startActivity(intent);
    }
    public void onClickChooseLangRus(View view) {
        languageChoice = 3;
        Intent intent = new Intent(this, ChooseRetailOrOnlineActivity.class);
        startActivity(intent);
    }
    public void onClickChooseLangRom(View view) {
        languageChoice = 4;
        Intent intent = new Intent(this, ChooseRetailOrOnlineActivity.class);
        startActivity(intent);
    }
    public void onClickChooseLangArm(View view) {
        languageChoice = 5;
        Intent intent = new Intent(this, ChooseRetailOrOnlineActivity.class);
        startActivity(intent);
    }

    public static int getLanguageChoice() { return languageChoice; }
}
