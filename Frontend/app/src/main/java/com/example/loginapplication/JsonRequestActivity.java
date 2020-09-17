package com.example.loginapplication;

public class JsonRequestActivity {
    //Tag used to cancel the request
    String tag_json_obj = "json_obj_req";

    String url1 = "https://api.androidhive.info/volley/person_object.json";
    String url2 = "https://api.androidhive.info/volley/person_array.json"

    ProgressDialog pDialog = newProgressDialog(this);
    pDialog.setMessage("Loading little one...");
    pDialog.show();

    JsonObjectRequest jsonObjReq = newJsonObjectRequest(Method.GET,
                                                        url1, null,
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

    JsonArrayRequest req = newJsonArrayRequest(url2,
            newResponse.Listener<JSONArray>()

    {
        @Override
        public void onResponse (JSONArray response){
        Log.d(TAG, response.toString());
        pDialog.hide();
        }
    }, new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error){
            VolleyLog.d(TAG, "Error: "+ error.getMessage());
            pDialog.hide();
        }
    });

    AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    AppController.getInstance().addToRequestQueue(req, tag_json_array);
    AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
            url1, null,
            new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Log.d(TAG, response.toString());
            pDialog.hide();
        }
    }, new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error){
            VolleyLog.d(TAG, "Error: "+ error.getMessage());
            pDialog.hide();
        }
    })
    //Submitting name, email, and password as request parameters:
    @Override
    protectedMap<String, String>getParams(){
        Map<String, String>params = new Hashmap<String, String>();
        params.put("name", "Androidhive");
        params.put("email", "marissag@iastate.edu");
        params.put("password", "PASSWORD");

        return parameters;
    }



}
