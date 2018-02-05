package com.example.myfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Subscription> subList = new ArrayList<Subscription>();
    private ListView oldSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oldSub = (ListView) findViewById(R.id.SubscriptionList);

        oldSub.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                Intent change = new Intent( v.getContext(), EditSub.class);
                Object subClicked = oldSub.getItemAtPosition(pos);
                Subscription clicked = (Subscription) subClicked;
                String sname = clicked.getName();
                String sdate = clicked.getDate();
                int scost = clicked.getCost();
                String scomment = clicked.getComment();

                change.putExtra("sname", sname);
                change.putExtra("scost", scost);
                change.putExtra("sdate", sdate);
                change.putExtra("scomment", scomment);

                startActivityForResult(change,1);
            }
        });
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
                    String comment = data.getStringExtra("subcomment");

                    Subscription newSub = new Subscription(name, date, cost, comment);

                    subList.add(newSub);

                    ArrayAdapter<Subscription> adapter1 = new ArrayAdapter<Subscription>(this,
                            android.R.layout.simple_list_item_1, subList);
                    oldSub.setAdapter(adapter1);
                }
            }
            else if(resultCode == 2){
                //Update
            }
            else if(resultCode == 3){
                //Delete
            }
        }
    }
}