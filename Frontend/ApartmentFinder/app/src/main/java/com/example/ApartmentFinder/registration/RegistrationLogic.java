package com.example.ApartmentFinder.registration;

import com.example.ApartmentFinder.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationLogic implements IVolleyListener{
    IView r;
    IServerRequest serverRequest;

    public RegistrationLogic(IView r, IServerRequest serverRequest){
        this.r = r;
        this.serverRequest = serverRequest;
        serverRequest.addVolleyListener(this);
    }
//http://coms-309-cy-04.cs.iastate.edu:8080/Users?email=mag@iastate.edu&userName=testingFromPostman&password=testingFromPostman
    public void registerUser(String name, String password) throws JSONException {
        final String url = Const.URL_JSON_OBJECT + "&userName="+name+"&password="+password;
        JSONObject newUserObj = new JSONObject();
        newUserObj.put("name", name);
        newUserObj.put("password", password);

        serverRequest.sendToServer(url, newUserObj, "POST");
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
