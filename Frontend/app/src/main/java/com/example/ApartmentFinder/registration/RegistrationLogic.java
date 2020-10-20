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
    public void registerUser(String name, String email, String password) throws JSONException {
        final String url = Const.URL_JSON_OBJECT + "/Users?email="+email+"&userName="+name+"&password="+password;
        JSONObject newUserObj = new JSONObject();
        newUserObj.put("name", name);
        newUserObj.put("email", email);
        newUserObj.put("password", password);

        serverRequest.sendToServer(url, newUserObj, "POST");
    }

    public void onSuccess(String email){
        if(email.length()>0){
            r.showText("You are registered!");
        }else{
            r.showText("Error with request, please try again.");
        }
    }

    public void onError(String errorMessage){
        r.toastText(errorMessage);
        r.showText("Error with request, please try again.");
    }
}
