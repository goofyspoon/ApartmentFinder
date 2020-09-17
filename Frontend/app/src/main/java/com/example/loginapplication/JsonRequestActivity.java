package com.example.loginapplication;

public class JsonRequestActivity {
    //Tag used to cancel the request
    String tag_json_obj = "json_obj_req";

    String url = "https://api.androidhive.info/volley/person_object.json";

    ProgressDialog pDialog = newProgressDialog(this);
    pDialog.setMessage("Loading little one...");
    pDialog.show();

    JsonObjectRequest jsonObjReq = newJsonObjectRequest(Method.GET,
                                                        url, null,
                                                        newResponse.Listener<JSONObject>()

    {
        @Override
                publicvoidonResponse(JSONObject response) {
        Log.d(TAG, response.toString());
        pDialog.hide();
    }
    }, newResponse.ErrorListener(){
        @Override
                publicvoidonErrorResponse(VolleyError error){
                    VolleyLog.d(TAG, "Error: "+error.getMessage());
                    //hide the progress dialog
                    pDialog.hide();
                }
    });

    AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
}
