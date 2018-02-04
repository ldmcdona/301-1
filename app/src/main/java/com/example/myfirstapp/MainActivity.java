package com.example.myfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Subscription> subList;
    private ArrayAdapter<Subscription> adapater;
    private ListView oldSub;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oldSub = (ListView) findViewById(R.id.SubscriptionList);

        Bundle subData = getIntent().getExtras();
        if(getIntent().getStringExtra( "subname") != null){
            String name = getIntent().getStringExtra("subname");
            String date = getIntent().getStringExtra("subdate");
            int cost = subData.getInt("subcost");

            //TextView test = findViewById(R.id.textView2);
            //test.setText(name + " $" + cost + " " + date);

            Subscription newSub = new Subscription(name, date, cost);

            ArrayList<String> printout = new ArrayList<String>();
            printout.add(name + '\n' + date + '\n' + cost);

            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, printout);
            oldSub.setAdapter(adapter1);
        }

        //String[] subArray = new String[]{"yes", "no"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_list_item_1, subArray);

        //oldSub.setAdapter(adapter);

        //StringJoiner joiner = new StringJoiner(",");
       // joiner.add("foo");
        //joiner.add("bar");
        //joiner.add("baz");
        //String joined = joiner.toString(); // "foo,bar,baz"
    }

    //public void addSubscription(View view){
       // Subscription newSub = new Subscription(name, date, cost);

    //}

    public void createSub(View view){
        Intent intent = new Intent( this, new_subscription.class);
        startActivity(intent);
    }
}