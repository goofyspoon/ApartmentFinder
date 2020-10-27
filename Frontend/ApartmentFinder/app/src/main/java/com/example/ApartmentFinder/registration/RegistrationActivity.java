package com.example.ApartmentFinder.registration;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ApartmentFinder.Credentials;
import com.example.ApartmentFinder.HomePageActivity;
import com.example.ApartmentFinder.app.AppController;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ApartmentFinder.R;
//import com.example.loginapplication.home.HomePageActivity;

import org.json.JSONException;

public class RegistrationActivity extends AppCompatActivity implements IView {
    EditText eRegEmail;
    EditText eRegName;
    EditText eRegPassword;
    Button eRegister;
    public static Credentials credentials;
    public TextView registerErrorTextView;
    public static RegistrationActivity ra;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        new AppController();
        ra = this;

        setContentView(R.layout.activity_registration);

        eRegEmail = findViewById(R.id.etRegEmail);
        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById((R.id.btnRegister));
        //registerErrorTextView = findViewById(R.id.registerErrorMessageField);

        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
            eRegEmail.setAutofillHints(View.AUTOFILL_HINT_EMAIL_ADDRESS);
            eRegName.setAutofillHints(View.AUTOFILL_HINT_USERNAME);
            eRegPassword.setAutofillHints(View.AUTOFILL_HINT_PASSWORD);
        }

        ServerRequest serverRequest = new ServerRequest();
        final RegistrationLogic logic = new RegistrationLogic(this, serverRequest);

        eRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    String username = eRegName.getText().toString();
                    String email = eRegEmail.getText().toString();
                    String password = eRegPassword.getText().toString();
                    logic.registerUser(username, email, password);
                    startActivity(new Intent(RegistrationActivity.this, HomePageActivity.class));
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void showText(String s){
        registerErrorTextView.setText(s);
        registerErrorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void toastText(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

}
