package com.example.firsttry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendWarning(View view) {

    Snackbar mySnackbar = Snackbar.make(view, "message", 10000);
    mySnackbar.show();

    AlertDialog alertDialog = alertDialogBuilder.create;



    }

    public void warningMessage(Veiw veiw){

        Snackbar mySnackbar = Snackbar.make(view, "Changing this message", 10000);
        mySnackbar.show();

    }
}