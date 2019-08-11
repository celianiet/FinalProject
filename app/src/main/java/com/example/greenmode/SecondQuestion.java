package com.example.greenmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entities.Question;

public class SecondQuestion extends AppCompatActivity {

    private TextView secondquestion;
    private CheckBox answ1, answ2, answ3, answ4;
    private  int score;

    //random position in the array list
    Random rposition = new Random();

    ArrayList<Question> object2 = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        secondquestion = (TextView)findViewById(R.id.question2);
        answ1 = (CheckBox)findViewById(R.id.answer1_second);
        answ2 = (CheckBox)findViewById(R.id.answer2_second);
        answ3 = (CheckBox)findViewById(R.id.answer3_second);
        answ4 = (CheckBox)findViewById(R.id.answer4_second);

        //FirstQuestion firstQuestion = new FirstQuestion();

        Intent nextToQ2 = getIntent();


        Bundle args = nextToQ2.getBundleExtra("BUNDLE");
        ArrayList<Question> object = (ArrayList<Question>) args.getSerializable("ARRAYLIST");

        object2 = object;

        //


        int position = (rposition.nextInt(object.size()));
        Question randomQuestion2 = object.get(position);


       String question2 = randomQuestion2.getDescription().toString();
       secondquestion.setText(question2);

       String answer1 = randomQuestion2.getFirstAnswer().toString();
       answ1.setText(answer1);
       String answer2 = randomQuestion2.getSecondAnswer().toString();
       answ2.setText(answer2);
       String answer3 = randomQuestion2.getThirdAnswer().toString();
       answ3.setText(answer3);
       String answer4 = randomQuestion2.getFourthAnswer().toString();
       answ4.setText(answer4);
       object.remove(randomQuestion2);

    }
    public int getPunctuation() {

        if (answ1.isChecked()) {
            score = 15;

        }
        else if (answ2.isChecked()) {
            score = 10;


        }
        else if (answ3.isChecked()) {
            score = 5;

        } else {
            score = 0;

        }

        return score;

    }

    public void nextActivityQ3(View view) {
        Intent nextToQ3 = new Intent(this, ThirdQuestion.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)object2);
        nextToQ3.putExtra("BUNDLE",args);
        startActivity(nextToQ3);

        getPunctuation();

        //int roundPoints = score + score1;

        Toast.makeText(this, "score" + score, Toast.LENGTH_LONG).show();

    }
}
