package com.example.ApartmentFinder;//package com.example.loginapplication;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import com.android.volley.Request.Method;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.VolleyLog;
//import com.android.volley.toolbox.StringRequest;
//
//
//import android.app.ProgressDialog;
//
//import com.android.volley.Request;
//import com.example.loginapplication.app.AppController;
//
//public class StringRequestActivity extends Activity{
//    //Tag used to cancel the request:
//    String tag_string_req = "string_req";
//    private String TAG = StringRequestActivity.class.getSimpleName();
//    private Button btnStringReq;
//    private TextView msgResponse;
//    //QUESTION: ProgressDialog was deprecated in API level 26..no longer available?
//    private ProgressDialog pDialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_string);
//
//        btnStringReq = (Button) findViewById(R.id.btnStringReq);
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    //Change later, skater
//    String url = "https://api.androidhive.info/volley/string_response.html";
//
//    ProgressDialog pDiaglog = new ProgressDialog(this);
//    pDialog.setMessage("Loading my dear...");
//    pDialog.show();
//
//    StringRequest strReq = new StringRequest(Request.Method.GET,
//                                                url, new Response.Listener<String>()
//
//    {
//        @Override
//                public void onResponse(String response) {
//        Log.d(TAG, response.toString());
//        pDialog.hide();
//    }
//    },new Response.ErrorListener(){
//         @Override
//            public void onErrorResponse(){
//                VolleyLog.d(TAG, "Error: "+error.getMessage());
//                pDialog.hide();
//            }
//    });
//
//    AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
//
//
//}
