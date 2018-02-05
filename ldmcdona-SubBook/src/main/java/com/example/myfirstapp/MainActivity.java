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

public class MainActivity extends AppCompatActivity {

    private ArrayList<Subscription> subList = new ArrayList<Subscription>();
    private ArrayAdapter<Subscription> adapater;
    private ListView oldSub;
    private ArrayList<String> printout = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oldSub = (ListView) findViewById(R.id.SubscriptionList);
    }

    public void createSub(View view) {
        Intent intent = new Intent(this, new_subscription.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
               // Bundle subData = data.getExtras();
                if (data.getStringExtra("subname") != null) {
                    String name = data.getStringExtra("subname");
                    String date = data.getStringExtra("subdate");
                    int cost = Integer.parseInt(data.getStringExtra("subcost"));

                    Subscription newSub = new Subscription(name, date, cost);

                    subList.add(newSub);

                    ArrayAdapter<Subscription> adapter1 = new ArrayAdapter<Subscription>(this,
                            android.R.layout.simple_list_item_1, subList);
                    oldSub.setAdapter(adapter1);
                }
            }
        }
    }
}