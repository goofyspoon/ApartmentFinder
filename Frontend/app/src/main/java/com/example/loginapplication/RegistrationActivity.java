package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.loginapplication.app.AppController;
import com.example.loginapplication.AppController2;

public class RegistrationActivity extends AppCompatActivity {
    public static final String TAG = RegistrationActivity.class.getSimpleName();
    private EditText eRegName;
    private EditText eRegPassword;
    private Button eRegister;

    public static Credentials credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Log.d(TAG, "Got to registration Page");
        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById((R.id.btnRegister));

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String regUsername = eRegName.getText().toString();
                final String regPassword = eRegPassword.getText().toString();

//                if(validate(regUsername, regPassword)){
//                    credentials = new Credentials(regUsername,regPassword);
//                    startActivity(new Intent(RegistrationActivity.this, HomePageActivity.class));
//                    Toast.makeText(RegistrationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
//                }

                String url = "http://google.com";
                StringRequest sRequest = new StringRequest(
                        Request.Method.GET, url,
                        new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response){
                                Log.d(TAG, "Response is: "+ response);
                              credentials = new Credentials(regUsername,regPassword);
                              startActivity(new Intent(RegistrationActivity.this, HomePageActivity.class));
                              Toast.makeText(RegistrationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error){
                                //Log that
                                Log.d(TAG, "Error is: " + error.getMessage()+"");
                            }
                        }
                );}
                AppController2.getInstance();
                AppController2.getInstance(RegistrationActivity.this).addRequestQueue(sRequest);
                AppController.getInstance().addRequestQueue(sRequest);

        });


    }

    private boolean validate(String username, String password){

        if(username.isEmpty() || password.length() < 8){
            Toast.makeText(this, "Please enter all the details, password should be at least 8 characters", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}