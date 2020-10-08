package com.example.loginapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.example.loginapplication.app.AppController;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonRequestActivity extends AppCompatActivity {

    private String TAG = JsonRequestActivity.class.getSimpleName();
    private String tag_json_obj = "jobj_req", tag_json_array = "jarray_req";

    private static JsonRequestActivity mInstance;

    String url1 = "https://api.androidhive.info/volley/person_object.json";
    String url2 = "https://api.androidhive.info/volley/person_array.json";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mInstance = this;
    }

    public static synchronized JsonRequestActivity getInstance(){
        if (mInstance == null){
            mInstance = new JsonRequestActivity();
        }
        return mInstance;
    }


    //    ProgressDialog pDialog = newProgressDialog(this);
//    pDialog.setMessage("Loading little one...");
//    pDialog.show();
    public JsonObjectRequest GETJsonObjectRequest(String url, JSONObject object) {

        JsonObjectRequest jsonObjReqGet = new JsonObjectRequest(Request.Method.GET,
                url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        Log.d(TAG, "Adding the following to Request Queue: " + jsonObjReqGet);
        AppController.getInstance().addToRequestQueue(jsonObjReqGet);
        return jsonObjReqGet;
    }

    public JsonArrayRequest GETJsonArrayRequest(String url) {

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        Log.d(TAG, "Adding the following to Request Queue: " + req);
        AppController.getInstance().addToRequestQueue(req);
        return req;
    }

    public JsonObjectRequest POSTJsonObjectRequest(String url) {

        JsonObjectRequest jsonObjReqPost = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        Log.d(TAG, "Adding the following to Request Queue: " + jsonObjReqPost);
        AppController.getInstance().addToRequestQueue(jsonObjReqPost);
        return jsonObjReqPost;
    }


    /**
     //Submitting name, email, and password as request parameters:
     //@Override
     protected Map<String, String> getParams(){
     Map<String, String> params = new HashMap<String, String>();
     params.put("name", "Androidhive");
     params.put("email", "marissag@iastate.edu");
     params.put("password", "PASSWORD");

     return params;
     }
     **/
}
