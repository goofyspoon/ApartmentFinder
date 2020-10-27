package com.example.ApartmentFinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView AptContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        AptContent = findViewById(R.id.contentOfApartment);
        Intent i = getIntent();
        String title = i.getStringExtra("nameOfApartment");
        String content = i.getStringExtra("contentOfApartment");

        getSupportActionBar().setTitle(title);

        AptContent.setText(content);
        AptContent.setMovementMethod(new ScrollingMovementMethod());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}