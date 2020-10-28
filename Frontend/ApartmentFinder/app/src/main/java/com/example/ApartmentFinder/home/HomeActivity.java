package com.example.ApartmentFinder.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ApartmentFinder.MainActivity;
import com.example.ApartmentFinder.R;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.registration.RegistrationActivity;
import com.example.ApartmentFinder.registration.ServerRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements IView {

    RecyclerView recyclerView;
    Adapter adapter;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final HomeLogic logic = new HomeLogic(new ServerCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                //do something
                ArrayList<Apartment> allApartments = new ArrayList<>();
                try{
                    for(int i = 0; i<result.length(); i++){
                        allApartments.add(new Apartment(result.getJSONObject(i)));
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }

                String[] apartmentNames = new String[allApartments.size()];
                String[] apartmentAddress = new String[allApartments.size()];
                for(int i = 0; i<allApartments.size(); i++){
                    apartmentNames[i]= allApartments.get(i).getApartment_name();
                    apartmentAddress[i]= allApartments.get(i).getAddress();
                }


                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                adapter = new Adapter(mContext,apartmentNames,apartmentAddress);
                recyclerView.setAdapter(adapter);
            }
        });

        ArrayList<Apartment> apartmentArray = new ArrayList<>();
        try {
            apartmentArray = logic.getAllApartments();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.Logout:
                Toast.makeText(this, "You have logged out successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showText(String s){
        //registerErrorTextView.setText(s);
        //registerErrorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void toastText(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}