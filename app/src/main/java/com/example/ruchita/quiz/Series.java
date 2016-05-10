package com.example.ruchita.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ruchita on 12/4/16.
 *
 */


import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.ImageView;
import android.widget.Toast;




public class Series extends AppCompatActivity {

    ImageView hImageViewPic;
     Button iButton;
    int score = 0;
    int index=0;

    String optionA[],optionB[],optionC[],answer[];

    CheckBox A,B,C;



    private int currentImage = 0;
    int[] images = {R.drawable.sheldon, R.drawable.quantico1, R.drawable.mich, R.drawable.rachel, R.drawable.whitecollar};



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_quiz);


        optionA = getResources().getStringArray(R.array.optionA4);
        optionB = getResources().getStringArray(R.array.optionB4);
        optionC = getResources().getStringArray(R.array.optionC4);

        answer = getResources().getStringArray(R.array.answer4);



        A = (CheckBox) findViewById(R.id.image1);
        B = (CheckBox) findViewById(R.id.image2);
        C = (CheckBox) findViewById(R.id.image3);


        changeText(); //initially display the contents of the string

        hImageViewPic = (ImageView) findViewById(R.id.picture);
        assert hImageViewPic != null;
        hImageViewPic.setImageResource(images[currentImage]);
        iButton = (Button) findViewById(R.id.next1);
        ;

        assert iButton != null;
        iButton.setOnClickListener(iButtonChangeImageListener);


    }




    OnClickListener iButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {


            if (!(A.isChecked() || B.isChecked() || C.isChecked() )) //no option is selected
            {
                Toast.makeText(getApplicationContext(), "You have to select one option", Toast.LENGTH_SHORT).show();
            }

            else
            {
                checkAnswer();
                if (index<optionA.length) {
                    uncheck();

                    currentImage++;
                    currentImage = currentImage % images.length;

                    hImageViewPic.setImageResource(images[currentImage]);
                    changeText();
                    //Increase Counter to move to next Image


                }
                else {
                    Intent i = new Intent(Series.this, Score.class);

                    String s=Integer.toString(score);
                    i.putExtra("SCORE",s);
                    //to go from one activity to other
                    startActivity(i);
                    finish();
                }

            }


        }
    };


    public void changeText() {

        A.setText(optionA[index]);
        B.setText(optionB[index]);
        C.setText(optionC[index]);


    }


    public void onCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.image1:

                B.setChecked(false);
                C.setChecked(false);


                break;

            case R.id.image2:

                C.setChecked(false);

                A.setChecked(false);

                break;

            case R.id.image3:

                A.setChecked(false);
                B.setChecked(false);


                break;


        }
    }

    public void checkAnswer() //check answer and increasing the score if it is right
    {
        String a;
        int flag=0;
        if(A.isChecked())
            a=A.getText().toString();
        else if(B.isChecked())
            a=B.getText().toString();
        else
            a=C.getText().toString();


        if(!(a.equals(answer[index]))) {
            Toast.makeText(getApplicationContext(), "YOUR ANSWER IS INCORRECT", Toast.LENGTH_SHORT).show();
            flag=1;
        }

        if(flag==0) {
            Toast.makeText(getApplicationContext(), "YOUR ANSWER IS CORRECT", Toast.LENGTH_SHORT).show();
            score = score + 100;
        }
        index++;
    }


    public void uncheck()
    {

        A.setChecked(false);
        B.setChecked(false);
        C.setChecked(false);

    }

    public void onBackPressed()
    {

        Intent i=new Intent(Series.this,Play.class);
        startActivity(i);
        finish();

    }

}
