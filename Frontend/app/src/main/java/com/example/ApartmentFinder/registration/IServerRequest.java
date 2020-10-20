package com.example.ApartmentFinder.registration;

import org.json.JSONObject;

public interface IServerRequest {
    public void sendToServer(String url, JSONObject newUserObj, String methodType);
    public void addVolleyListener(IVolleyListener logic);
}
