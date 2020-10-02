package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {
    public static final String TAG = RegistrationActivity.class.getSimpleName();
    private Button eAdminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Log.d(TAG, "Got to registration Page");

        eAdminButton = findViewById((R.id.AdminButton));
        eAdminButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, AdminUsersDataActivity.class));
            }
         });
    }
}