package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    public void sendWarning(View view) {

    Snackbar mySnackbar = Snackbar.make(view, "message", 10000);
    mySnackbar.show();

    }
}