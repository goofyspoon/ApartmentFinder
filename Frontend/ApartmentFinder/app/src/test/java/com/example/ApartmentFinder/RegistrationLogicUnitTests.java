package com.example.ApartmentFinder;

import com.example.ApartmentFinder.Volley.IServerRequest;
import com.example.ApartmentFinder.net_utils.Const;
import com.example.ApartmentFinder.Volley.IView;

import com.example.ApartmentFinder.registration.RegistrationLogic;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationLogicUnitTests {

    @Mock
    private IView mockedIView;

    @Mock
    private IServerRequest mockedServerRequest;

    @Test
    public void verifySendToServer() throws JSONException {
        //Written by Marissa
        RegistrationLogic logic = new RegistrationLogic(mockedIView, mockedServerRequest);
        String username = "testUsername";
        String email = "testEmail";
        String password = "testPassword";

        JSONObject returnedObject = logic.registerUser(username, email, password);

        final String url = Const.URL_JSON_OBJECT + "/User?email="+email+"&userName="+username+"&password="+password;
        JSONObject newUserObj = new JSONObject();
        newUserObj.put("name", username);
        newUserObj.put("email", email);
        newUserObj.put("password", password);

        verify(mockedServerRequest, times(1)).sendToServer(url, returnedObject, "POST");

    }

    @Test
    public void testOnSuccessMethod(){
        //Written by Marissa
        RegistrationLogic logic = new RegistrationLogic(mockedIView, mockedServerRequest);
        String testEmail = "309testemail@email.com";
        logic.onSuccess(testEmail);
        String expectedText = "You are registered!";
        verify(mockedIView).showText(expectedText);
    }

    @Test
    public void testOnSuccessMethod2(){
        //Written by Marissa
        RegistrationLogic logic = new RegistrationLogic(mockedIView, mockedServerRequest);
        String testEmail = "";
        logic.onSuccess(testEmail);
        String expectedText = "Error with request, please try again.";
        verify(mockedIView).showText(expectedText);
    }

    /**
    @Test
    public void testOnErrorMethod(){
        //Written by Marissa
        RegistrationLogic logic = new RegistrationLogic(mockedIView, mockedServerRequest);
        String testErrorMessage = "";
        logic.onError(testErrorMessage);
        String expectedText = "Error with request, please try again.";
        verify(mockedIView).toastText(testErrorMessage);
        verify(mockedIView).showText(expectedText);
    }
    **/

}
