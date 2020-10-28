package com.example.ApartmentFinder.home;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.ApartmentFinder.JsonRequestActivity;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.app.AppController;
import com.example.ApartmentFinder.net_utils.Const;
import com.example.ApartmentFinder.Volley.IServerRequest;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.Volley.IVolleyListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HomeLogic implements IVolleyListener{
    private String TAG = HomeLogic.class.getSimpleName();
    IView r;
    IServerRequest serverRequest;
    ServerCallback callback;
    ArrayList<Apartment> allApartments = new ArrayList<>();
    boolean requestFinished;

    public HomeLogic(IView r, IServerRequest serverRequest, final ServerCallback callback){
        this.r = r;
        this.serverRequest = serverRequest;
        serverRequest.addVolleyListener(this);
        requestFinished = false;
        this.callback = callback;
    }

    public ArrayList<Apartment> getAllApartments() throws InterruptedException {
        GETJsonArrayRequest(Const.postmanURL+ "/Apartments");
        /**
        long waitTime = (long) 0.001;
        while(!requestFinished){
            TimeUnit.SECONDS.sleep(waitTime);
        }
         **/
        Log.d(TAG, "allApartments: "+ allApartments);
        while(allApartments.size() == 0){
            Log.d(TAG, "allApartments: "+ allApartments);
        }
        Log.d(TAG, "10: allApartments: "+ allApartments);

        return allApartments;
    }

    public JsonArrayRequest GETJsonArrayRequest(String url) {

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        callback.onSuccess(response);
//                        try{
//                            for(int i = 0; i<response.length(); i++){
//                                allApartments.add(new Apartment(response.getJSONObject(i)));
//                            }
//
//                        }catch(JSONException e){
//                            e.printStackTrace();
//                        }

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


















    /**

//http://coms-309-cy-04.cs.iastate.edu:8080/Users?email=mag@iastate.edu&userName=testingFromPostman&password=testingFromPostman
    public JSONObject registerUser(String name, String email, String password) throws JSONException {
        final String url = Const.URL_JSON_OBJECT + "/Users?email="+email+"&userName="+name+"&password="+password;
        JSONObject newUserObj = new JSONObject();
        newUserObj.put("name", name);
        newUserObj.put("email", email);
        newUserObj.put("password", password);

        serverRequest.sendToServer(url, newUserObj, "POST");
        return newUserObj;
    }
     **/
    public void onSuccess(String password){
        if(password.length()>0){
            r.showText("You are registered!");
        }else{
            r.showText("Error with request, please try again.");
        }
    }

    @Override
    public void onError(String s) {

    }

}
