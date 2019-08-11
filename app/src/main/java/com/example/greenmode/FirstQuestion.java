package com.example.greenmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;


import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entities.DbConnectionHelper;
import Entities.Question;


public class FirstQuestion extends AppCompatActivity {

    private TextView firstQuestion;
    private CheckBox answ1, answ2, answ3, answ4;
    private int score;


    //random position in the array list
    Random rposition = new Random();
    //Declare array list of questions objects
    List<Question> questionsList = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        firstQuestion = (TextView)findViewById(R.id.question1);

        answ1 = (CheckBox)findViewById(R.id.answer1_first);
        answ2 = (CheckBox)findViewById(R.id.answer2_first);
        answ3 = (CheckBox)findViewById(R.id.answer3_first);
        answ4 = (CheckBox)findViewById(R.id.answer4_first);



        //Call method with the array inside onCreate
        questionsList = Read();;

        int position = (rposition.nextInt(questionsList.size()));
        Question randomQuestion = questionsList.get(position);


        String question1 = randomQuestion.getDescription().toString();
        firstQuestion.setText(question1);
        String answer1 = randomQuestion.getFirstAnswer().toString();
        answ1.setText(answer1);
        String answer2 = randomQuestion.getSecondAnswer().toString();
        answ2.setText(answer2);
        String answer3 = randomQuestion.getThirdAnswer().toString();
        answ3.setText(answer3);
        String answer4 = randomQuestion.getFourthAnswer().toString();
        answ4.setText(answer4);
        questionsList.remove(randomQuestion);

    }


    public List<Question> Read() {

        // Creation of a new Object DbConnectionHelper type:
        DbConnectionHelper admin = new DbConnectionHelper (this, "greenDb", null, 1);
        List<Question> QuestionDisplay = new ArrayList<>();
        String sql = "SELECT * FROM questions ORDER BY questionId DESC";
        SQLiteDatabase getQuestion = admin.getWritableDatabase();
        Cursor cursor = getQuestion.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("questionId")));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String first = cursor.getString(cursor.getColumnIndex("firstAnswer"));
                String second = cursor.getString(cursor.getColumnIndex("secondAnswer"));
                String third = cursor.getString(cursor.getColumnIndex("thirdAnswer"));
                String fourth = cursor.getString(cursor.getColumnIndex("fourthAnswer"));

                Question question = new Question();

                question.questionId = id;
                question.description = description;
                question.firstAnswer = first;
                question.secondAnswer = second;
                question.thirdAnswer = third;
                question.fourthAnswer = fourth;

                QuestionDisplay.add(question);


            } while (cursor.moveToNext());

        }
        cursor.close();
        admin.close();
        return QuestionDisplay;

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

    public void nextActivityQ2(View view) {
        Intent nextToQ2 = new Intent ( FirstQuestion.this, SecondQuestion.class);

        getPunctuation();
        Bundle args = new Bundle();

        args.putSerializable("ARRAYLIST",(Serializable)questionsList);

        nextToQ2.putExtra("BUNDLE",args);


        Toast.makeText(this, "score" + this.score, Toast.LENGTH_LONG).show();
        startActivity(nextToQ2);


    }

}


