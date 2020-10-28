package com.example.ApartmentFinder.home;

import com.example.ApartmentFinder.Volley.IView;

import org.json.JSONArray;

public interface ServerCallback {
    void onSuccess(JSONArray result);
}
