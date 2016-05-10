package com.example.ruchita.quiz;

/**
 * Created by ruchita on 9/4/16.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Business  extends AppCompatActivity {

    private int index = 0; // kee track of the number of questions
    private int score = 0; // to keep track of the score

    String question[], optionA[], optionB[], optionC[], optionD[], answer[];
    TextView t;
    CheckBox A, B, C, D;
    Button n;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        question = getResources().getStringArray(R.array.question1);
        optionA = getResources().getStringArray(R.array.optionA1);
        optionB = getResources().getStringArray(R.array.optionB1);
        optionC = getResources().getStringArray(R.array.optionC1);
        optionD = getResources().getStringArray(R.array.optionD1);
        answer = getResources().getStringArray(R.array.answer1);


        t = (TextView) findViewById(R.id.question);
        A = (CheckBox) findViewById(R.id.optionA);
        B = (CheckBox) findViewById(R.id.optionB);
        C = (CheckBox) findViewById(R.id.optionC);
        D = (CheckBox) findViewById(R.id.optionD);
        n = (Button) findViewById(R.id.next);

        changeText(); //initially display the contents of the string

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(A.isChecked() || B.isChecked() || C.isChecked() || D.isChecked())) //no option is selected
                    Toast.makeText(getApplicationContext(), "You have to select one option", Toast.LENGTH_SHORT).show();

                else {
                    checkAnswer();


                    if (index < question.length) {
                        uncheck();
                        changeText();
                    } else {
                        Intent i = new Intent(Business.this, Score.class);

                        String s = Integer.toString(score);
                        i.putExtra("SCORE", s);
                        //to go from one activity to other
                        startActivity(i);
                        finish();
                    }
                }


            }
        });


    }


    public void changeText() {
        t.setText(question[index]);
        A.setText(optionA[index]);
        B.setText(optionB[index]);
        C.setText(optionC[index]);
        D.setText(optionD[index]);

    }


    public void onCheckboxClicked(View view) {

        switch (view.getId()) {

            case R.id.optionA:

                B.setChecked(false);
                C.setChecked(false);
                D.setChecked(false);

                break;

            case R.id.optionB:

                C.setChecked(false);
                D.setChecked(false);
                A.setChecked(false);

                break;

            case R.id.optionC:

                A.setChecked(false);
                B.setChecked(false);
                D.setChecked(false);

                break;

            case R.id.optionD:

                A.setChecked(false);
                B.setChecked(false);
                C.setChecked(false);
        }
    }

    public void checkAnswer() //check answer and increasing the score if it is right
    {
        String a;
        int flag = 0;
        if (A.isChecked())
            a = A.getText().toString();
        else if (B.isChecked())
            a = B.getText().toString();
        else if (C.isChecked())
            a = C.getText().toString();
        else a = D.getText().toString();

        if (!(a.equals(answer[index]))) {
            Toast.makeText(getApplicationContext(), "YOUR ANSWER IS INCORRECT", Toast.LENGTH_SHORT).show();
            flag = 1;

        }

        if (flag == 0) {
            Toast.makeText(getApplicationContext(), "YOUR ANSWER IS CORRECT", Toast.LENGTH_SHORT).show();
            score = score + 100;
        }
        index++;
    }


    public void uncheck() {

        A.setChecked(false);
        B.setChecked(false);
        C.setChecked(false);
        D.setChecked(false);
    }

    public void onBackPressed() {

        Intent i = new Intent(Business.this, Play.class);
        startActivity(i);
        finish();

    }


}