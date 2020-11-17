package com.example.ApartmentFinder;

import com.example.ApartmentFinder.Volley.IJSONObjectRequest;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.net_utils.Const;
import com.example.ApartmentFinder.Volley.IView;

import com.example.ApartmentFinder.registration.RegistrationLogic;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationLogicUnitTests {

    @Mock
    private IView mockedIView;

    @Mock
    private IJSONObjectRequest mockedServerRequest;

    @Mock
    private Apartment mockedApartment;

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

    @Test
    public void testApartmentRent() throws JSONException {
        JSONObject testObject = new JSONObject();
        int testRent = 0;
        testObject.put("rent", testRent);
        Apartment testApartment = new Apartment(testObject);
        Assert.assertEquals(testRent, testApartment.getRent());
    }

    @Test
    public void testApartmentRating() throws JSONException {
        JSONObject testObject = new JSONObject();
        int testRating = 0;
        testObject.put("rating", testRating);
        Apartment testApartment = new Apartment(testObject);
        Assert.assertEquals(testRating, testApartment.getRating());
    }

    @Test
    public void testApartmentID() throws JSONException {
        JSONObject testObject = new JSONObject();
        int testApartmentID = 0;
        testObject.put("apartment_id", testApartmentID);
        Apartment testApartment = new Apartment(testObject);
        Assert.assertEquals(testApartmentID, testApartment.getApartment_id());
    }

    @Test
    public void testApartmentNumRooms() throws JSONException {
        JSONObject testObject = new JSONObject();
        int testNumRooms = 0;
        testObject.put("num_rooms", testNumRooms);
        Apartment testApartment = new Apartment(testObject);
        Assert.assertEquals(testNumRooms, testApartment.getNum_rooms());
    }

    @Test
    public void testOnSuccessMethod3(){
        //Written by Kent
        RegistrationLogic logic = new RegistrationLogic(mockedIView, mockedServerRequest);
        String testUsername = "KennyMark";
        logic.onSuccess(testUsername);
        String expectedText = "You are registered!";
        verify(mockedIView).showText(expectedText);
    }

    @Test
    public void testOnSuccessMethod4(){
        //Written by Kent
        RegistrationLogic logic = new RegistrationLogic(mockedIView, mockedServerRequest);
        String testUsername = "";
        logic.onSuccess(testUsername);
        String expectedText = "Error with request, please try again.";
        verify(mockedIView).showText(expectedText);
    }


}
