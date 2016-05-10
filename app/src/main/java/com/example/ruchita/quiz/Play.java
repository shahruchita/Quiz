package com.example.ruchita.quiz;

/**
 * Created by ruchita on 9/4/16.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ruchita on 9/4/16.
 */
public class Play extends AppCompatActivity {
    String name;
    ArrayAdapter<String> madapter;

    SharedPreferences settings;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

     //   name = getIntent().getStringExtra("NAME2");


         settings =getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
       name = settings.getString(MainActivity.NAME,"");


        ListView listView = (ListView) findViewById(R.id.category);
        TextView t = (TextView) findViewById(R.id.hello_player);
        t.setText("Hello" + " " + name +"." + "Choose any one Category");
        Button b1=(Button)findViewById(R.id.back);

        String[] category = getResources().getStringArray(R.array.category);
        madapter = (new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, category));


        // Binding resources Array to ListAdapter
        assert listView != null;
        listView.setAdapter(madapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String category = ((TextView) view).getText().toString();
                System.out.println(category);

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), SingleItemList.class);
                // sending data to new activity
                i.putExtra("CATEGORY", category);
                startActivity(i);
                finish();



            }
        });

        assert b1!=null;
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(Play.this, MainActivity.class);
                //to go from one activity to other
                i.putExtra("name",name);
                startActivity(i);
                finish();

            }
        });


    }

    public void onBackPressed()
    {
        Intent i=new Intent(Play.this,MainActivity.class);
        i.putExtra("name",name);
        startActivity(i);
        finish();
    }





}