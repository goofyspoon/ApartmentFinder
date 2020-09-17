package com.example.loginapplication;

//import android.app.ProgressDialog;

import android.app.ProgressDialog;

import com.android.volley.Request;

public class StringRequestActivity{
    //Tag used to cancel the request:
    String tag_string_req = "string_req";

    //Change later, skater
    String url = "https://api.androidhive.info/volley/string_response.html";

    ProgressDialog pDiaglog = newProgressDialog(this);
    pDialog.setMessage("Loading my dear...");
    pDialog.show();

    StringRequest strReq = newStringRequest(Request.Method.GET,
                                                url, newResponse.Listener<String>()

    {
        @Override
                publicvoidonResponse(String response) {
        Log.d(TAG, response.toString());
        pDialog.hide();
    }
    },newResponse.ErrorListener(){
         @Override
            publicvoidonErrorResponse(){
                VolleyLog.d(TAG, "Error: "+error.getMessage());
                pDialog.hide();
            }
    });

    AppController.getInstance().addToRequestQueue(strReq, tag_string_req);


}
