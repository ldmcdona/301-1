package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class new_subscription extends AppCompatActivity {
    private EditText name;
    private EditText date;
    private EditText cost;
    private EditText comment;
    private String subname;
    private String subdate;
    private int subcost;
    private String subcomment;
    private ArrayList<Subscription> subList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);

        name = (EditText) findViewById(R.id.sname);
        cost = (EditText) findViewById(R.id.scost);
        date = (EditText) findViewById(R.id.sdate);

        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "testing";
                TextView test = findViewById(R.id.textView);
                test.setText(message);

                String subname = name.getText().toString();
                String subdate = date.getText().toString();
                int subcost = Integer.parseInt(cost.getText().toString());

                Intent newintent = new Intent(getApplicationContext(), MainActivity.class);
                newintent.putExtra( "subname", subname);
                newintent.putExtra( "subcost", subcost);
                newintent.putExtra( "subdate", subdate);
                startActivity(newintent);
            }
        });

        //public void NewSub(View view){

        //}
    }
}
