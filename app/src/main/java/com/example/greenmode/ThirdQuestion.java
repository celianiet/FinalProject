package com.example.greenmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import Entities.Question;

public class ThirdQuestion extends AppCompatActivity {

    private TextView thirdquiestion;
    private CheckBox answ1, answ2, answ3, answ4;
    public int score;

    //random position in the array list
    Random rposition = new Random();
    Bundle args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        thirdquiestion = (TextView)findViewById(R.id.question3);
        answ1 = (CheckBox)findViewById(R.id.answer1_third);
        answ2 = (CheckBox)findViewById(R.id.answer2_third);
        answ3 = (CheckBox)findViewById(R.id.answer3_third);
        answ4 = (CheckBox)findViewById(R.id.answer4_third);

        Intent nextToQ3 = getIntent();
        Bundle args = nextToQ3.getBundleExtra("BUNDLE");
        ArrayList<Question> object2 = (ArrayList<Question>) args.getSerializable("ARRAYLIST");

        int position = (rposition.nextInt(object2.size()));
        Question randomQuestion3 = object2.get(position);

        String question3 = randomQuestion3.getDescription().toString();
        thirdquiestion.setText(question3);

        String answer1 = randomQuestion3.getFirstAnswer().toString();
        answ1.setText(answer1);
        String answer2 = randomQuestion3.getSecondAnswer().toString();
        answ2.setText(answer2);
        String answer3 = randomQuestion3.getThirdAnswer().toString();
        answ3.setText(answer3);
        String answer4 = randomQuestion3.getFourthAnswer().toString();
        answ4.setText(answer4);

        object2.remove(randomQuestion3);


    }

    public int getPunctuation() {

        if (answ1.isChecked()) {
            score = 15;
            //Toast.makeText(this, "score" score, Toast.LENGTH_LONG).show();
        }
        else if (answ2.isChecked()) {
            score = 10;
            //Toast.makeText(this,  score, Toast.LENGTH_LONG).show();

        }
        else if (answ3.isChecked()) {
            score = 5;
            //Toast.makeText(this, score, Toast.LENGTH_LONG).show();
        } else {
            score = 0;
            //Toast.makeText(this, score, Toast.LENGTH_LONG).show();
        }

        return score;

    }

    public void getResult(View view) {

        getPunctuation();
        Intent result = new Intent(this, Result.class);
        //Bundle args = new Bundle();
        result.putExtra("totalpoints", score);

        startActivity(result);



        //int roundPoints = score + score1;

        Toast.makeText(this, "score" + score, Toast.LENGTH_LONG).show();

    }
}
