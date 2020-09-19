package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginapplication.app.AppController;
import com.example.loginapplication.AppController2;
import com.example.loginapplication.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

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

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                //showProgressDialog();
                JSONObject object = new JSONObject();
                try {
                    //Input API parameters
                    object.put("username", "username");
                    object.put("password", "password");
                } catch (JSONException error) {
                    Log.d(TAG, "Response is: " + error.getMessage() + "");
                }

                JsonObjectRequest jRequest = new JsonObjectRequest(
                        Request.Method.GET, url, object,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                System.out.println("Response is: " + response);
                                Log.d(TAG, "Response is: " + response);
                                credentials = new Credentials(regUsername, regPassword);
                                startActivity(new Intent(RegistrationActivity.this, HomePageActivity.class));
                                Toast.makeText(RegistrationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log that
                                System.out.println("There was an error dog: " + error.getMessage() + "");
                                Log.d(TAG, "Error is: " + error.getMessage() + "");
                            }
                        }
                );


                    //

                    Log.d(TAG, "Adding the following to Request Queue: " + jRequest);
                    System.out.println("Adding the following to Request Queue: " + jRequest);
                    AppController.getInstance().addToRequestQueue(jRequest);
                    //
                }
            }
                //AppController2.getInstance(sRequest).addRequestQueue();
                //AppController.getInstance().addRequestQueue(sRequest);

        );}

//        AppController2.getInstance(sRequest).addRequestQueue();
//        AppController.getInstance().addToRequestQueue(sRequest);



//    public void makeJsonObjReq() {
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//
//        //showProgressDialog();
//        JSONObject object = new JSONObject();
//        try {
//            //Input API parameters
//            object.put("username", "username");
//            object.put("password", "password");
//        } catch (JSONException error) {
//            Log.d(TAG, "Response is: " + error.getMessage() + "");
//        }
//
//        JsonObjectRequest jRequest = new JsonObjectRequest(
//                Request.Method.POST, Const.URL_JSON_OBJECT, object,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        System.out.println("Response is: " + response);
//                        Log.d(TAG, "Response is: " + response);
//                        credentials = new Credentials(regUsername, regPassword);
//                        startActivity(new Intent(RegistrationActivity.this, HomePageActivity.class));
//                        Toast.makeText(RegistrationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //Log that
//                        System.out.println("There was an error dog: " + error.getMessage() + "");
//                        Log.d(TAG, "Error is: " + error.getMessage() + "");
//                    }
//                }
//        );
//    }

    private boolean validate(String username, String password){

        if(username.isEmpty() || password.length() < 8){
            Toast.makeText(this, "Please enter all the details, password should be at least 8 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}