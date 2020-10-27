package com.example.ApartmentFinder.Volley;

import com.example.ApartmentFinder.Volley.IVolleyListener;

import org.json.JSONObject;

public interface IServerRequest {
    public void sendToServer(String url, JSONObject newUserObj, String methodType);
    public void addVolleyListener(IVolleyListener logic);
}
