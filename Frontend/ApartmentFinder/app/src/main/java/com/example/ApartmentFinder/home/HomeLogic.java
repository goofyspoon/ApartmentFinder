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

public class HomeLogic{
    private String TAG = HomeLogic.class.getSimpleName();
    ServerCallback callback;
    ArrayList<Apartment> allApartments = new ArrayList<>();
    boolean requestFinished;

    public HomeLogic(final ServerCallback callback){
        requestFinished = false;
        this.callback = callback;
    }

    public void getAllApartments(){
        GETJsonArrayRequest(Const.postmanURL+ "/Apartments");
    }

    public JsonArrayRequest GETJsonArrayRequest(String url) {

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        callback.onSuccess(response);
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

}
