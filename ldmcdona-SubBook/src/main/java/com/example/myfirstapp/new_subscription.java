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


                String subname = name.getText().toString();
                String subdate = date.getText().toString();
                String subcost = cost.getText().toString();

                Intent newintent = new Intent();
                newintent.putExtra( "subname", subname);
                newintent.putExtra( "subcost", subcost);
                newintent.putExtra( "subdate", subdate);
            //    newintent.putExtra()
                setResult(1, newintent);
                finish();
            }
        });

        //public void NewSub(View view){

        //}
    }
}
