package com.example.ruchita.quiz;

/**
 * Created by ruchita on 12/4/16.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;


public class Score extends AppCompatActivity {

    String  score,name;
    TextView t;
    Button b1,b2;
    SharedPreferences settings;

    boolean doubleBackToExitPressedOnce = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        settings =getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        name = settings.getString(MainActivity.NAME, "");

        score=getIntent().getStringExtra("SCORE");
        int myNum = 0;

        try {
            myNum = Integer.parseInt(score);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }

        t=(TextView)findViewById(R.id.score);

        if(myNum<=200) {
            t.setText(name + " ," + "your score is" + " " + score + " out of 500 " + "!!!");
        }

         else if(myNum>=300 && myNum<=400){
            t.setText(name + " ," + " Good your score is" + " " + score + " out of 500" + "!!!");
        }

        else if(myNum==0){
            t.setText(name + " ," + "None of your answer is correct !!!");
        }

        else{
            t.setText(name + " ," + " Excellent your score is" + " " + score + " out of 500" + "!!!");
        }




        b1=(Button)findViewById(R.id.exit);
        b2=(Button)findViewById(R.id.playagain);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Score.this, MainActivity.class); //to go from one activity to other
                i.putExtra("name",name);
                startActivity(i);
                finish();


            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Score.this, Play.class); //to go from one activity to other
                startActivity(i);
                finish();

            }
        });




    }

    public void onBackPressed()
    {

        Intent i=new Intent(Score.this,Play.class);
        i.putExtra("name",name);
        startActivity(i);
        finish();

    }

}
