package com.example.ruchita.quiz;

/**
 * Created by ruchita on 9/4/16.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemList extends AppCompatActivity {

   Button b1,b2;
    TextView category;
    ImageView imageView;
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item);


        b1=(Button)findViewById(R.id.start);
        b2=(Button)findViewById(R.id.back1);
        category=(TextView)findViewById(R.id.welcome_category);
        imageView=(ImageView)findViewById(R.id.category_image);

         c=getIntent().getStringExtra("CATEGORY");

        category.setText("WELCOME TO THE WORLD OF" + " " + c);

        if(c.equals("BUSINESS"))
            imageView.setImageResource(R.drawable.business);
        if(c.equals("SCIENCE"))
            imageView.setImageResource(R.drawable.science1);
        if(c.equals("PICTURE"))
            imageView.setImageResource(R.drawable.pic);
        if(c.equals("SPORTS"))
            imageView.setImageResource(R.drawable.sports1);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.equals("BUSINESS")) {
                    Intent i = new Intent(SingleItemList.this, Business.class); //to go from one activity to other
                    startActivity(i);
                    finish();
                }
                else if(c.equals("SCIENCE")){
                    Intent i = new Intent(SingleItemList.this, Science.class); //to go from one activity to other
                    startActivity(i);
                    finish();
                }
                else if(c.equals("SPORTS")) {

                    Intent i = new Intent(SingleItemList.this, Sports.class); //to go from one activity to other
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(SingleItemList.this, Series.class); //to go from one activity to other
                    startActivity(i);
                    finish();
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SingleItemList.this, Play.class); //to go from one activity to other
                startActivity(i);
                finish();
            }
        });








    }
    public void onBackPressed()
    {

        Intent i=new Intent(SingleItemList.this,Play.class);
        startActivity(i);
        finish();

    }




}
