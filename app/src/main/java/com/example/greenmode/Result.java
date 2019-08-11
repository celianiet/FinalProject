package com.example.greenmode;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import Entities.DbConnectionHelper;


public class Result extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public int score;
    Bundle totalPoints;
    private TextView feedback;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //feedBack = (TextView) findViewById(R.id.feedback);

        Intent result = getIntent();
        totalPoints = getIntent().getExtras();
        int score = totalPoints.getInt("totalpoints");

        Toast.makeText(this, "total points" + score, Toast.LENGTH_LONG).show();
        feedBack();

        ///creation of an object from db connection Helper
        DbConnectionHelper admin = new DbConnectionHelper (this, "greenDb", null, 1);

        //Sqlitedatabase object to write and read the db
        SQLiteDatabase sqlDbObj = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        //registro.put("userId", "");
        registro.put("totalPoints",score);

        sqlDbObj.insert("users", null, registro);
        sqlDbObj.close();
    }

    public void feedBack() {

        feedback = (TextView)findViewById(R.id.feedback);
        String message = feedback.toString();
        image = (ImageView)findViewById(R.id.planet_icon);

        if (score >= 30) {
            //System.out.println("Congrats User! Keep that green behaivor!\n");
            feedback.setText("Congrats User! Keep that green behaivor!");
            image.setImageResource(R.drawable.planet_green);

        } else if (score >= 15) {
            //System.out.println("User you can do it better! Check it out for tips to improve it!");
            feedback.setText("You can do it better! Check out the tip section to improve!");
            image.setImageResource(R.drawable.planet_yellow);
        } else {
            //System.out.println("User the planet really needs your help! Check it out for tips to improve it!");
            feedback.setText("The planet really needs your help! Check out the tip section to improve!");
            image.setImageResource(R.drawable.planet_red);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent home = new Intent(this, MainActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_answer) {

        } else if (id == R.id.nav_tips) {
            Intent tips = new Intent(this, Tips.class);
            startActivity(tips);

        } else if (id == R.id.nav_maps) {
            //Intent map = new Intent();
            Intent map = new Intent(this, MapsActivity.class);
            startActivity(map);


        } else if (id == R.id.nav_events) {
            Intent events = new Intent(this, News.class);
            startActivity(events);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
