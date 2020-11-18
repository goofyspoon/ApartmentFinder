package com.example.ApartmentFinder;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.ApartmentFinder.Volley.IJSONArrayRequest;
import com.example.ApartmentFinder.Volley.IJSONObjectRequest;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.home.HomeActivity;
import com.example.ApartmentFinder.home.HomeLogic;
import com.example.ApartmentFinder.home.JSONArrayRequest;
import com.example.ApartmentFinder.home.ServerCallback;
import com.example.ApartmentFinder.net_utils.Const;
import com.example.ApartmentFinder.registration.RegistrationLogic;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HomeLogicUnitTests {

    @Mock
    private IView mockedIView;

    @Mock
    private IJSONArrayRequest mockedServerRequest;

    @Mock
    private HomeActivity mockedActivity;

    @Mock
    private ServerCallback callback;

    @Test
    public void testSendToServer() throws JSONException {
        //Written by Marissa
        HomeLogic logic = new HomeLogic(callback, mockedActivity);


        JSONObject parameters = new JSONObject();
        try {
            parameters.put("bMin", 0);
            parameters.put("bMax", 2);
            parameters.put("rMin", 0);
            parameters.put("rMax", 1500);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonArrayRequest returnedObject = logic.getAllApartments(true,  parameters);
        //JsonArrayRequest returnedObject = request.sendToServer(Const.postmanURL+ "/Apartments", true, parameters);

        //public JsonArrayRequest sendToServer(String url, final boolean filter, final JSONObject parameters)
        verify(mockedServerRequest, times(1)).sendToServer(Const.postmanURL+"/Apartments", true, parameters);

    }

    @Test
    public void testOnSuccessMethod(){
        //Written by Marissa
        HomeLogic logic = new HomeLogic(callback, mockedActivity);
        int success = 1;
        logic.onSuccess(success);
        String expectedText = "Apartments in search parameters:";
        verify(mockedIView).showText(expectedText);
    }
/**
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
**/

}
