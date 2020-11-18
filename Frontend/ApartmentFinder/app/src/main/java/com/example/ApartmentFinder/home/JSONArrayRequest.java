package com.example.ApartmentFinder.home;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.ApartmentFinder.Volley.IJSONArrayRequest;
import com.example.ApartmentFinder.Volley.IVolleyListener;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONArrayRequest implements IJSONArrayRequest {

    private String TAG = JSONArrayRequest.class.getSimpleName();
    ServerCallback callback;
    ArrayList<Apartment> allApartments = new ArrayList<>();
    boolean requestFinished;
    private IVolleyListener l;

    public JSONArrayRequest(final ServerCallback callback){
        requestFinished = false;
        this.callback = callback;
    }
    public JsonArrayRequest sendToServer(String url, final boolean filter, final JSONObject parameters) {

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
                                    if(parameters.getInt("bMin") != -1) {
                                        //Search by budget
                                        if (compareApartment.getRent() < parameters.getInt("bMin")
                                                || compareApartment.getRent() > parameters.getInt("bMax")) {
                                            //Doesnt match filter, remove from list
                                            filterResponse.remove(i);
                                        }
                                    }else if(parameters.getInt("rMin") != -1){
                                        //Search by num rooms
                                        if (compareApartment.getNum_rooms() < parameters.getInt("rMin")
                                                || compareApartment.getNum_rooms() > parameters.getInt("rMax")) {
                                            //Doesnt match filter, remove from list
                                            filterResponse.remove(i);
                                        }
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
        //AppController.getInstance().addToRequestQueue(registerUserRequest,tag_json_obj);
        AppController.getInstance().addToRequestQueue(req);
        return req;
    }

    public void addVolleyListener(IVolleyListener logic){
        l = logic;
    }
}
