package com.example.ApartmentFinder.Volley;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONObject;

public interface IJSONArrayRequest {
    public JsonArrayRequest sendToServer(String url, final boolean filter, final JSONObject parameters);
    public void addVolleyListener(IVolleyListener logic);
}
