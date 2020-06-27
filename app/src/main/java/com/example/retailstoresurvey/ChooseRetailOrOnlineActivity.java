package com.example.retailstoresurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChooseRetailOrOnlineActivity extends AppCompatActivity {

    private EditText feedback;
    private Button submitButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioButton radioButton10;
    private RadioButton radioButton11;
    private RadioButton radioButton12;
    private RadioButton radioButton13;
    private RadioButton radioButton14;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String RADIO_BUTTON1 = "radioButtons";
    public static final String RADIO_BUTTON2 = "radioButtons";
    public static final String FEEDBACK = "feedback";

    private String loadFeedback;
    private String radioFeedback1;
    private String radioFeedback2;
    private String radioFeedback3;
    private String radioFeedback4;
    private String radioFeedback5;
    private String radioFeedback6;
    private String radioFeedback7;
    private String radioFeedback8;
    private String radioFeedback9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_retail_or_online);

        feedback = (EditText) findViewById(R.id.feedback_text);
        submitButton = (Button) findViewById(R.id.submit_review);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton14);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton11);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton12);
        radioButton7 = (RadioButton) findViewById(R.id.radioButton13);
        radioButton8 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton9 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton10 = (RadioButton) findViewById(R.id.radioButton7);
        radioButton11 = (RadioButton) findViewById(R.id.radioButton6);
        radioButton12 = (RadioButton) findViewById(R.id.radioButton8);
        radioButton13 = (RadioButton) findViewById(R.id.radioButton10);
        radioButton14 = (RadioButton) findViewById(R.id.radioButton9);

        //set destination to read from
        //radioButtons = (RadioButton) findViewById(R.id.radioButton14);

        //sets radio button auto checked
        //radioButton1.setChecked(true);

        //checks if radio is checked
        //radioButtons[0].isChecked();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        updateFeedback();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(FEEDBACK, feedback.getText().toString());


        editor.putString(RADIO_BUTTON1, String.valueOf(radioButton4.isChecked()));
        editor.putString(RADIO_BUTTON2, String.valueOf(radioButton2.isChecked()));
        //editor.putString(RADIO_BUTTONS, String.valueOf(radioButton4.isChecked()));
        //editor.putString(RADIO_BUTTONS, String.valueOf(radioButton4.isChecked()));
        //editor.putString(RADIO_BUTTONS, String.valueOf(radioButton4.isChecked()));
        //editor.putString(RADIO_BUTTONS, String.valueOf(radioButton4.isChecked()));

        editor.apply();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public  void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        loadFeedback = sharedPreferences.getString(FEEDBACK, "");
        radioFeedback1 = sharedPreferences.getString(RADIO_BUTTON1, "");
        radioFeedback2 = sharedPreferences.getString(RADIO_BUTTON1, "");
        //radioFeedback = sharedPreferences.getString(RADIO_BUTTONS, "");
        //radioFeedback = sharedPreferences.getString(RADIO_BUTTONS, "");
        //radioFeedback = sharedPreferences.getString(RADIO_BUTTONS, "");
        //radioFeedback = sharedPreferences.getString(RADIO_BUTTONS, "");
        //radioFeedback = sharedPreferences.getString(RADIO_BUTTONS, "");
        //radioFeedback = sharedPreferences.getString(RADIO_BUTTONS, "");
    }

    public void updateFeedback() {
        feedback.setText(loadFeedback);
        radioButton4.setChecked(Boolean.parseBoolean(radioFeedback1));
        radioButton2.setChecked(Boolean.parseBoolean(radioFeedback2));
        //radioButton4.setChecked(Boolean.parseBoolean(radioFeedback));
        //radioButton4.setChecked(Boolean.parseBoolean(radioFeedback));
        //radioButton4.setChecked(Boolean.parseBoolean(radioFeedback));
        //radioButton4.setChecked(Boolean.parseBoolean(radioFeedback));
        //radioButton4.setChecked(Boolean.parseBoolean(radioFeedback));

       // radioButtons[1].setText(radioFeedback);
    }
}
