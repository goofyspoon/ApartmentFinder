package com.example.loginapplication;//package com.example.loginapplication;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.VolleyLog;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.JsonRequest;
//import com.example.loginapplication.app.AppController;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class JsonRequestActivity extends AppCompatActivity {
//
//    private String TAG = JsonRequestActivity.class.getSimpleName();
//    private String tag_json_obj = "jobj_req", tag_json_array = "jarray_req";
//
//    String url1 = "https://api.androidhive.info/volley/person_object.json";
//    String url2 = "https://api.androidhive.info/volley/person_array.json";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.ac);
//
//        btnStringReq = (Button) findViewById(R.id.btnStringReq);
//
//    }
//
////    ProgressDialog pDialog = newProgressDialog(this);
////    pDialog.setMessage("Loading little one...");
////    pDialog.show();
//
//    JsonObjectRequest jsonObjReqGet = new JsonObjectRequest(Request.Method.GET,
//                                                        url1, null,
//                                                        new Response.Listener<JSONObject>()
//
//    {
//        @Override
//                public void onResponse(JSONObject response) {
//        Log.d(TAG, response.toString());
//    }
//    }, new Response.ErrorListener(){
//        @Override
//                public void onErrorResponse(VolleyError error){
//                    VolleyLog.d(TAG, "Error: "+error.getMessage());
//                }
//    });
//
//    JsonArrayRequest req = new JsonArrayRequest(url2,
//            new Response.Listener<JSONArray>()
//
//    {
//        @Override
//        public void onResponse (JSONArray response){
//        Log.d(TAG, response.toString());
//        }
//    }, new Response.ErrorListener(){
//        @Override
//        public void onErrorResponse(VolleyError error){
//            VolleyLog.d(TAG, "Error: "+ error.getMessage());
//        }
//    });
//
//    JsonObjectRequest jsonObjReqPost = new JsonObjectRequest(Request.Method.POST,
//            url1, null,
//            new Response.Listener<JSONObject>() {
//        @Override
//        public void onResponse(JSONObject response) {
//            Log.d(TAG, response.toString());
//        }
//    }, new Response.ErrorListener(){
//        @Override
//        public void onErrorResponse(VolleyError error){
//            VolleyLog.d(TAG, "Error: "+ error.getMessage());
//        }
//    });
//    //Submitting name, email, and password as request parameters:
//    //@Override
//    protected Map<String, String> getParams(){
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("name", "Androidhive");
//        params.put("email", "marissag@iastate.edu");
//        params.put("password", "PASSWORD");
//
//        return params;
//    }
//
//    AppController.getInstance().addToRequestQueue(jsonObjReqGet, tag_json_obj);
//    AppController.getInstance().addToRequestQueue(req, tag_json_array);
//    AppController.getInstance().addToRequestQueue(jsonObjReqPost, tag_json_obj);
//
//}
