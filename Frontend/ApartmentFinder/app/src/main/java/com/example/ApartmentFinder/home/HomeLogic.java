package com.example.ApartmentFinder.home;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

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

    public void getAllApartments(boolean filter, JSONObject parameters){
        GETJsonArrayRequest(Const.postmanURL+ "/Apartments", filter, parameters);
    }

    public JsonArrayRequest GETJsonArrayRequest(String url, final boolean filter, final JSONObject parameters) {

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        if(!filter) {
                            callback.onSuccess(response);
                        } else {
                            JSONArray filterResponse = response;
                            for(int i = 0; i<response.length(); i++){
                                try {
                                    Apartment compareApartment = new Apartment((JSONObject) filterResponse.get(i));
                                    if(compareApartment.getRent() < parameters.getInt("bMin")
                                            ||compareApartment.getRent() > parameters.getInt("bMax")){
                                        //Doesnt match filter, remove from list
                                        filterResponse.remove(i);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            callback.onSuccess(filterResponse);
                        }
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
