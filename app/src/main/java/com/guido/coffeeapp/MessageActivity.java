package com.guido.coffeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.guido.coffeeapp.justjava.R;

public class MessageActivity extends AppCompatActivity {
    TextView textMsg;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        textMsg = (TextView) findViewById(R.id.message);
        message = getIntent().getStringExtra("message");
        textMsg.setText(message);
    }
}
