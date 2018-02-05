package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditSub extends AppCompatActivity {
    private EditText name;
    private EditText date;
    private EditText cost;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sub);

        name = (EditText) findViewById(R.id.namet);
        cost = (EditText) findViewById(R.id.costt);
        date = (EditText) findViewById(R.id.datet);

        final Button button1 = findViewById(R.id.save);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String subname = name.getText().toString();
                String subdate = date.getText().toString();
                String subcost = cost.getText().toString();

                Intent passintent = new Intent();
                passintent.putExtra( "subname", subname);
                passintent.putExtra( "subcost", subcost);
                passintent.putExtra( "subdate", subdate);
                setResult(2, passintent);
                finish();
            }
        });

        final Button button2 = findViewById(R.id.save);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent failintent = new Intent();
                setResult(3, failintent);
                finish();
            }
        });
    }
}
