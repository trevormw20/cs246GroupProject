package com.example.retailstoresurvey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import org.w3c.dom.Text;

public class ChooseRetailOrOnlineActivity extends AppCompatActivity {

    //location of buttons and radio buttons, variables
    private Button reviewButton;
    private Button submitButton;
    private static EditText feedback;
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
    private RadioButton radioButtonRetail;
    private RadioButton radioButtonOnline;

    //location of sharedpreferences
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String RADIO_BUTTON_RETAIL = "radioButtonRetail";
    public static final String RADIO_BUTTON_ONLINE = "radioButtonOnline";
    public static final String FEEDBACK = "feedback";

    //information that can be passed to another class
    private String loadFeedback;
    private static String radioFeedback1;
    private static String radioFeedback2;
    private static String radioFeedback3;
    private static String radioFeedback4;
    private static String radioFeedback5;
    private static String radioFeedback6;
    private static String radioFeedback7;
    private static String radioFeedback8;
    private static String radioFeedback9;
    private static String radioFeedback10;
    private static String radioFeedback11;
    private static String radioFeedback12;
    private static String radioFeedbackRetail;
    private static String radioFeedbackOnline;

    private static float[] negative = new float[5];
    private static float[] neutral = new float[5];
    private static float[] positive = new float[5];
    private String setter;

    //location for saved data in sharedPrefrences
    public static final String QUESTION_POSITIVE1 = "questionP1";
    public static final String QUESTION_POSITIVE2= "questionP2";
    public static final String QUESTION_POSITIVE3 = "questionP3";
    public static final String QUESTION_POSITIVE4 = "questionP4";
    public static final String QUESTION_NEGATIVE1 = "questionN1";
    public static final String QUESTION_NEGATIVE2= "questionN2";
    public static final String QUESTION_NEGATIVE3 = "questionN3";
    public static final String QUESTION_NEGATIVE4 = "questionN4";
    public static final String QUESTION_NEUTRAL1 = "questionNL1";
    public static final String QUESTION_NEUTRAL2= "questionNL2";
    public static final String QUESTION_NEUTRAL3 = "questionNL3";
    public static final String QUESTION_NEUTRAL4 = "questionNL4";

    //text that will be changed for each language
    public static int languageChoice;
    private TextView question1;
    private TextView question2;
    private TextView question3;
    private TextView question4;
    private TextView question5;
    private TextView question6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_retail_or_online);

        languageChoice = MainActivity.getLanguageChoice();
        language();
       // Toast.makeText(this, String.valueOf(languageChoice), Toast.LENGTH_SHORT).show();

        feedback = (EditText) findViewById(R.id.feedback_text);
        submitButton = (Button) findViewById(R.id.submit_review);
        reviewButton = (Button) findViewById(R.id.ReviewButton);

        //listener for review button
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reviews();
            }
        });

        //Location of each button and its state for saving reviews.
        feedback = (EditText) findViewById(R.id.feedback_text);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioButton7 = (RadioButton) findViewById(R.id.radioButton7);
        radioButton8 = (RadioButton) findViewById(R.id.radioButton8);
        radioButton9 = (RadioButton) findViewById(R.id.radioButton9);
        radioButton10 = (RadioButton) findViewById(R.id.radioButton10);
        radioButton11 = (RadioButton) findViewById(R.id.radioButton11);
        radioButton12 = (RadioButton) findViewById(R.id.radioButton12);
        radioButtonRetail = (RadioButton) findViewById(R.id.radioButtonRetail);
        radioButtonOnline = (RadioButton) findViewById(R.id.radioButtonOnline);

        // When customer presses submit it will save the review.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        //load data now so that the review chart can load everything.
        loadData();
    }

    public void saveData() {
        //Check each state of each review question to be saved.
        checkQuestion();

        //open shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //save each part of the review even if contains 0;
        editor.putString(FEEDBACK, feedback.getText().toString());
        editor.putString(QUESTION_POSITIVE1, String.valueOf(positive[1]));
        editor.putString(QUESTION_POSITIVE2, String.valueOf(positive[2]));
        editor.putString(QUESTION_POSITIVE3, String.valueOf(positive[3]));
        editor.putString(QUESTION_POSITIVE4, String.valueOf(positive[4]));
        editor.putString(QUESTION_NEGATIVE1, String.valueOf(negative[1]));
        editor.putString(QUESTION_NEGATIVE2, String.valueOf(negative[2]));
        editor.putString(QUESTION_NEGATIVE3, String.valueOf(negative[3]));
        editor.putString(QUESTION_NEGATIVE4, String.valueOf(negative[4]));
        editor.putString(QUESTION_NEUTRAL1, String.valueOf(neutral[1]));
        editor.putString(QUESTION_NEUTRAL2, String.valueOf(neutral[2]));
        editor.putString(QUESTION_NEUTRAL3, String.valueOf(neutral[3]));
        editor.putString(QUESTION_NEUTRAL4, String.valueOf(neutral[4]));

        //apply and close shared preference
        editor.apply();
    }

    public  void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        //load previous reviews for graph
        setter = sharedPreferences.getString(QUESTION_POSITIVE1, "");
        positive[1] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_POSITIVE2, "");
        positive[2] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_POSITIVE3, "");
        positive[3] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_POSITIVE4, "");
        positive[4] = Float.parseFloat(setter);

        setter = sharedPreferences.getString(QUESTION_NEGATIVE1, "");
        negative[1] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_NEGATIVE2, "");
        negative[2] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_NEGATIVE3, "");
        negative[3] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_NEGATIVE4, "");
        negative[4] = Float.parseFloat(setter);

        setter = sharedPreferences.getString(QUESTION_NEUTRAL1, "");
        neutral[1] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_NEUTRAL2, "");
        neutral[2] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_NEUTRAL3, "");
        neutral[3] = Float.parseFloat(setter);
        setter = sharedPreferences.getString(QUESTION_NEUTRAL4, "");
        neutral[4] = Float.parseFloat(setter);
    }

    //review button
    public void reviews() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    //returns for graph to acquire saved data
    public static float[] getPositive() { return positive; }
    public static float[] getNegative() { return negative; }
    public static float[] getNeutral() { return neutral; }
    public static EditText getFeedback() { return feedback; }

    //Check if a radio button is checked and then saves.
    public void checkQuestion() {
            if (radioButton1.isChecked())
                negative[1]++;
            if (radioButton2.isChecked())
                neutral[1]++;
            if (radioButton3.isChecked())
                positive[1]++;

            if (radioButton4.isChecked())
                negative[2]++;
            if (radioButton5.isChecked())
                neutral[2]++;
            if (radioButton6.isChecked())
                positive[2]++;

            if (radioButton7.isChecked())
                negative[3]++;
            if (radioButton8.isChecked())
                neutral[3]++;
            if (radioButton9.isChecked())
                positive[3]++;

            if (radioButton10.isChecked())
                negative[4]++;
            if (radioButton11.isChecked())
                neutral[4]++;
            if (radioButton12.isChecked())
                positive[4]++;
    }

    //reset reviews
    public static void resetReviews() {
        for (int i = 1; i <= 4; i++) {
            positive[i] = 0;
            negative[i] = 0;
            neutral[i] = 0;
        }
    }

    private void language() {

        //english
        if (languageChoice == 1) {
            question1 = (TextView) findViewById(R.id.textViewQ1r);
            question1.setText("Were you able to find what you were looking for?");

            question2 = (TextView) findViewById(R.id.textViewQ2r);
            question2.setText("Were you able to find the quantities you needed?");

            question3 = (TextView) findViewById(R.id.textViewQ3r);
            question3.setText("Did you receive good service from the associate(s) at the store?");

            question4 = (TextView) findViewById(R.id.textViewQ4r);
            question4.setText("Was the amount of time you spent waiting to pay for your purchase acceptable?");

            question5 = (TextView) findViewById(R.id.textViewQ5r);
            question5.setText("Do you have any additional feedback to improve your shopping experience?");
        }

        //Ukrainian
        if (languageChoice == 2) {
            question1 = (TextView) findViewById(R.id.textViewQ1r);
            question1.setText("Чи знайшли ви те, що шукали?");

            question2 = (TextView) findViewById(R.id.textViewQ2r);
            question2.setText("Чи ви змогли знайти все в потрібній кількості?");

            question3 = (TextView) findViewById(R.id.textViewQ3r);
            question3.setText("Чи добре вас обслужили працівники магазину?");

            question4 = (TextView) findViewById(R.id.textViewQ4r);
            question4.setText("Чи не надто довго ви чекали, щоб оплатити свою покупку?");

            question5 = (TextView) findViewById(R.id.textViewQ5r);
            question5.setText("Чи є у вас певні пропозиції щодо покращення обслуговування в магазині?");
        }

        //Russian
        if (languageChoice == 3) {
            question1 = (TextView) findViewById(R.id.textViewQ1r);
            question1.setText("Вам легко удалось найти то, что вы искали?");

            question2 = (TextView) findViewById(R.id.textViewQ2r);
            question2.setText("Удалось ли вам найти товар в нужном количестве?");

            question3 = (TextView) findViewById(R.id.textViewQ3r);
            question3.setText("Вас хорошо обслужили сотрудники магазина?");

            question4 = (TextView) findViewById(R.id.textViewQ4r);
            question4.setText("Время, затраченное на оплату покупки приемлемо для вас?");

            question5 = (TextView) findViewById(R.id.textViewQ5r);
            question5.setText("Есть ли у вас дополнительные рекомендации о том, как улучшить качество обслуживания покупателей?");
        }

        //Romanian
        if (languageChoice == 4) {
            question1 = (TextView) findViewById(R.id.textViewQ1r);
            question1.setText("Ai putut găsi ce căutai?");

            question2 = (TextView) findViewById(R.id.textViewQ2r);
            question2.setText("Ai putut găsi cantitățile dorite?");

            question3 = (TextView) findViewById(R.id.textViewQ3r);
            question3.setText("Ai fost servit bine de angajatul/angajații magazinului?");

            question4 = (TextView) findViewById(R.id.textViewQ4r);
            question4.setText("A fost acceptabil timpul petrecut așteptând să plătești pentru materiale?\n");

            question5 = (TextView) findViewById(R.id.textViewQ5r);
            question5.setText("Ai alte întrebări și sugestii pentru a-ți îmbunătăți experiența de cumpărare?");
        }

        //Armenian
        if (languageChoice == 5) {
            question1 = (TextView) findViewById(R.id.textViewQ1r);
            question1.setText("Արդյո՞ք կարողացաք գտնել այն, ինչ փնտրում էիք?");

            question2 = (TextView) findViewById(R.id.textViewQ2r);
            question2.setText("Արդյո՞ք կարողացաք գտնել այն քանակությամբ, որքան փնտրում էիք?");

            question3 = (TextView) findViewById(R.id.textViewQ3r);
            question3.setText("Արդյո՞ք լավ ծառայություն մատուցեցին խանութի աշխատող(ներ)ը?");

            question4 = (TextView) findViewById(R.id.textViewQ4r);
            question4.setText("Արդյո՞ք ընդունելի էր այն ժամանակը, որը դուք ծախսել եք ձեր գնումների վճարման համար սպասելիս?");

            question5 = (TextView) findViewById(R.id.textViewQ5r);
            question5.setText("Ունե՞ք լրացուցիչ կարծիքներ ձեր գնումների փորձառությունը բարելավելու համար?");
        }
    }
}
