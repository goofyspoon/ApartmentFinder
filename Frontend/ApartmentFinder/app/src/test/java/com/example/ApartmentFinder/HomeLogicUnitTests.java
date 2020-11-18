package com.example.ApartmentFinder;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.ApartmentFinder.Volley.IJSONArrayRequest;
import com.example.ApartmentFinder.Volley.IJSONObjectRequest;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.app.AppController;
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
    private JSONArrayRequest mockedServerRequest;

    @Mock
    private HomeActivity mockedActivity;

    @Mock
    private ServerCallback callback;

    @Mock
    private AppController app;

    @Test
    public void testSendToServer() throws JSONException {
        //Written by Marissa

        HomeLogic logic = new HomeLogic(mockedActivity, mockedServerRequest);


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

        //public JsonArrayRequest sendToServer(String url, final boolean filter, final JSONObject parameters)
        verify(mockedServerRequest, times(1)).sendToServer(Const.postmanURL+"/Apartments", true, parameters);

    }

    @Test
    public void testOnSuccessMethod(){
        //Written by Marissa
        HomeLogic logic = new HomeLogic(mockedActivity, mockedServerRequest);
        int success = 1;
        logic.onSuccess(success);
        String expectedText = "Apartments in search parameters:";
        verify(mockedActivity).showText(expectedText);
    }


}
