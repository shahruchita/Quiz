package com.example.ruchita.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * Created by ruchita on 9/4/16.
 */
public class Instruction extends AppCompatActivity {
    Button b1;
    String name;


    SharedPreferences settings;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction);
        b1=(Button)findViewById(R.id.back);


        settings =getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
       name = settings.getString(MainActivity.NAME,"");


        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(Instruction.this, MainActivity.class);
                //to go from one activity to other
                i.putExtra("name",name);
                startActivity(i);
                finish();

            }
        });
    }


   public void onBackPressed()
   {
       Intent i=new Intent(Instruction.this,MainActivity.class);
       i.putExtra("name",name);
       startActivity(i);
       finish();
    }

}
