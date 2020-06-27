package com.example.retailstoresurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        radioButtons[0] = (RadioButton) findViewById(R.id.radioButton14);
        radioButtons[1] = (RadioButton) findViewById(R.id.radioButton11);
        radioButtons[2] = (RadioButton) findViewById(R.id.radioButton4);
        radioButtons[3] = (RadioButton) findViewById(R.id.radioButton);
        radioButtons[4] = (RadioButton) findViewById(R.id.radioButton2);
        radioButtons[5] = (RadioButton) findViewById(R.id.radioButton12);
        radioButtons[6] = (RadioButton) findViewById(R.id.radioButton13);
        radioButtons[7] = (RadioButton) findViewById(R.id.radioButton3);
        radioButtons[8] = (RadioButton) findViewById(R.id.radioButton5);
        radioButtons[9] = (RadioButton) findViewById(R.id.radioButton7);
        radioButtons[10] = (RadioButton) findViewById(R.id.radioButton6);
        radioButtons[11] = (RadioButton) findViewById(R.id.radioButton8);
        radioButtons[12] = (RadioButton) findViewById(R.id.radioButton10);
        radioButtons[13] = (RadioButton) findViewById(R.id.radioButton9);

*/
    }
    public void onClickChooseLangEng(View view) {
        Intent intent = new Intent(this, ChooseRetailOrOnlineActivity.class);
        startActivity(intent);
    }
}
