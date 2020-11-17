package com.example.ApartmentFinder.registration;

import com.example.ApartmentFinder.Volley.IJSONObjectRequest;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.Volley.IVolleyListener;
import com.example.ApartmentFinder.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationLogic implements IVolleyListener {
    IView r;
    IJSONObjectRequest serverRequest;

    public RegistrationLogic(IView r, IJSONObjectRequest serverRequest){
        this.r = r;
        this.serverRequest = serverRequest;
        serverRequest.addVolleyListener(this);
    }
//http://coms-309-cy-04.cs.iastate.edu:8080/Users?email=mag@iastate.edu&userName=testingFromPostman&password=testingFromPostman
    public JSONObject registerUser(String name, String email, String password) throws JSONException {
        final String url = Const.URL_JSON_OBJECT + "/User?email="+email+"&userName="+name+"&password="+password;
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
