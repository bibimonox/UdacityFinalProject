package com.example.yildi.finalprojectlap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton[] radioButtons;
    RadioGroup radioGroup;
    Button button, button1;
    ArrayList trueOption;
    Questions questions;
    ImageView imageView;
    TextView textView;
    RadioButton selectedButton;
    EditText editText;
    int questionNo = 0;
    int correctNo = 0;
    int selectedButtonId;
    int wrongNumber = 0;
    boolean go = false;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueOption = new ArrayList();
        radioButtons = new RadioButton[3];
        questions = new Questions();
        imageView = new ImageView(this);
        button = new Button(this);
        button = findViewById(R.id.buttonOne);
        relativeLayout= findViewById(R.id.relaative);
        textView = findViewById(R.id.finalText);


        radioGroup = findViewById(R.id.radioGroup1);

        radioButtons[0] = findViewById(R.id.radioButton1);
        radioButtons[1] = findViewById(R.id.radioButton2);
        radioButtons[2] = findViewById(R.id.radioButton3);

        questions.answers[0] = radioButtons[0].getId();
        questions.answers[1] = radioButtons[2].getId();
        questions.answers[2] = radioButtons[1].getId();
        questions.answers[3] = radioButtons[0].getId();
        questions.answers[4] = radioButtons[2].getId();
        questions.answers[5] = radioButtons[1].getId();
        questions.answers[6] = radioButtons[1].getId();
        questions.answers[7] = radioButtons[1].getId();


        //radioGroup = findViewById(R.id.radioGroup1);
        button = findViewById(R.id.buttonOne);

        imageView = findViewById(R.id.image);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.thelordoftherings));
        Log.i("sdasd", "onCreate: questionNo" + questionNo);
    }

    public void controller(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        selectedButtonId = radioGroup.getCheckedRadioButtonId();
        selectedButton = findViewById(selectedButtonId);
        switch (v.getId()) {
            case R.id.radioButton1:
                if (checked) {
                    Toast toast = Toast.makeText(this, " A Selected", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            case R.id.radioButton2:
                if (checked) {
                    Toast toast = Toast.makeText(this, "B Selected ", Toast.LENGTH_SHORT);
                    toast.show();

                }
                break;

            case R.id.radioButton3:
                if (checked) {
                    Toast toast = Toast.makeText(this, " C Selected ", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

        }
    }

    public void TrueFalse(View v) {
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(questions.option[questionNo][i]);
        }

        if (questionNo != questions.questionNo - 1) {
            if (selectedButtonId == 0) {
                Toast.makeText(this, "Pls Select One of these ", Toast.LENGTH_SHORT).show();
            } else if (questions.answers[questionNo] == selectedButtonId) {
                Toast.makeText(this, "True.Go on!!", Toast.LENGTH_SHORT).show();
                correctNo++;
                questionNo++;
            } else if (!(questions.answers[questionNo] == selectedButtonId)) {
                Toast.makeText(this, "False.Just Try Again!", Toast.LENGTH_SHORT).show();
                wrongNumber++;
                if (questions.answers[questionNo] == selectedButtonId) {
                    questionNo++;
                }
            } else if (questions.answers[7] == selectedButtonId) {
                relativeLayout.removeAllViews();
                Toast.makeText(this, "You Won!!!", Toast.LENGTH_SHORT).show();
            }
            switch (questionNo) {
                case 1:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.backtofuture));
                    break;
                case 2:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.e_t));
                    break;
                case 3:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.harrypotter));
                    break;
                case 4:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.matrix));
                    break;
                case 5:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.starwars));
                    break;
                case 6:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.madmax));
                    break;
                case 7:
                    relativeLayout.removeAllViews();
                    textView.setText("Good Work. You Finished All Quiz Your Total Corrects "+correctNo+" Your Total Wrong"+wrongNumber);
                    break;
            }
            for (int i = 0; i < radioButtons.length; i++) {
                radioButtons[i].setText(questions.option[questionNo][i]);
            }
        }
    }
}