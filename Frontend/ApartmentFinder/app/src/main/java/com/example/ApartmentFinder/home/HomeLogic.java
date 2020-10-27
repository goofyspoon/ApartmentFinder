package com.example.ApartmentFinder.home;

import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.net_utils.Const;
import com.example.ApartmentFinder.Volley.IServerRequest;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.Volley.IVolleyListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeLogic implements IVolleyListener{
    IView r;
    IServerRequest serverRequest;

    public HomeLogic(IView r, IServerRequest serverRequest){
        this.r = r;
        this.serverRequest = serverRequest;
        serverRequest.addVolleyListener(this);
    }


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
