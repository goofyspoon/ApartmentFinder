package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginapplication.app.AppController;
import com.example.loginapplication.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

public class AdminUsersDataActivity extends AppCompatActivity {
    public static final String TAG = AdminUsersDataActivity.class.getSimpleName();
    private EditText SearchUserName;
    private Button ebtnSearch;

    public static Credentials credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_users_data);
        Log.d(TAG, "Got to Admin User Data Page");
        SearchUserName = findViewById(R.id.SearchUserName);
        ebtnSearch = findViewById((R.id.btnSearch));

        ebtnSearch.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             final String regUsername = SearchUserName.getText().toString();

                                             RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                                             JSONObject object = new JSONObject();
                                             try {
                                                 //Input API parameters
                                                 object.put("userName", ""+ SearchUserName);
                                             } catch (JSONException error) {
                                                 Log.d(TAG, "Response is: " + error.getMessage() + "");
                                             }

                                             JsonObjectRequest jRequest = new JsonObjectRequest(
                                                     Request.Method.GET, Const.URL_JSON_OBJECT + "/Users/?user_id=32", object,
                                                     new Response.Listener<JSONObject>() {
                                                         @Override
                                                         public void onResponse(JSONObject response) {
                                                             System.out.println("Response is: " + response);
                                                             Log.d(TAG, "Response is: " + response);
                                                             //startActivity(new Intent(RegistrationActivity.this, HomePageActivity.class));
                                                             Toast.makeText(AdminUsersDataActivity.this, "User Found successfully!", Toast.LENGTH_SHORT).show();
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
                                             Log.d(TAG, "Adding the following to Request Queue: " + jRequest);
                                             System.out.println("Adding the following to Request Queue: " + jRequest);
                                             AppController.getInstance().addToRequestQueue(jRequest);
                                         }
                                     }
        );}


    private boolean validate(String username, String password){

        if(username.isEmpty() || password.length() < 8){
            Toast.makeText(this, "Please enter all the details, password should be at least 8 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}