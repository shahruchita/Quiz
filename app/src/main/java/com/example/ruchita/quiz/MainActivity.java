package com.example.ruchita.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;

    EditText name;

    public static final String MyPREFERENCES = "MyPrefs" ;
     SharedPreferences sharedpreferences;
    public static final String NAME="name";
    SharedPreferences settings;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1 = (Button) findViewById(R.id.instructions);
        b2 = (Button) findViewById(R.id.play);
        name = (EditText) findViewById(R.id.name);


        String n=getIntent().getStringExtra("name");
        name.setText(n);

        sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n1 = name.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(NAME,n1);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Instruction.class); //to go from one activity to other
                startActivity(i);
                finish();





            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = name.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(NAME,n1);
                editor.commit();


                Intent i = new Intent(MainActivity.this, Play.class); //to go from one activity to other
                startActivity(i);
                finish();


            }
        });



    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }



}
