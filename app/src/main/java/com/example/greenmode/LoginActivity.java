package com.example.greenmode;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import Entities.DbConnectionHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText name, password;

    //to ask Douglas
    //private EditorInfo email_input, password_input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        name = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.pass_id);
    }
    //Method to Register the User in DB and

    public void Register(View view){

        //Intent objet to go to the next activity
        Intent next = new Intent(this, MainActivity.class);

        ///creation of an object from db connection Helper
        DbConnectionHelper admin = new DbConnectionHelper (this, "greenDb", null, 1);

        //Sqlitedatabase object to write and read the db
        SQLiteDatabase sqlDbObj = admin.getWritableDatabase();

        //get the text from the form fields
        String userName = name.getText().toString();
        String userPass = password.getText().toString();



    //form validation if it not empty proceed

        if(!userName.isEmpty() && !userPass.isEmpty()){

            ContentValues registro = new ContentValues();

            registro.put("userName",userName);
            registro.put("password",userPass);
            //registro.put("totalPoints", "");
            sqlDbObj.insert("users", null, registro);
            sqlDbObj.close();

            // get the name to display in the next activity
            next.putExtra("dataName", name.getText().toString());
            Toast.makeText(this, "processing register", Toast.LENGTH_LONG).show();
            startActivity(next);

        }

        else {
            Toast.makeText(this, "the field can not be empty", Toast.LENGTH_LONG).show();

        }

    }





}


