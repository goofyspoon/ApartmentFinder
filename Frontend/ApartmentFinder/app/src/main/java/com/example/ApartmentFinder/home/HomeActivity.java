package com.example.ApartmentFinder.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ApartmentFinder.MainActivity;
import com.example.ApartmentFinder.R;
import com.example.ApartmentFinder.Volley.IView;
import com.example.ApartmentFinder.app.Apartment;
import com.example.ApartmentFinder.chat.ChatActivity;
import com.example.ApartmentFinder.registration.RegistrationActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements IView {

    RecyclerView recyclerView;
    Adapter adapter;
    private Context mContext = this;

    //Filter implementation
    EditText budgetMin;
    EditText budgetMax;
    EditText roomMin;
    EditText roomMax;
    Button filterButton;
    Button chatButton;
    Button rentAsc;
    Button rentDesc;
    Button ratingAsc;
    Button ratingDesc;
    Button roomAsc;
    Button roomDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Filter implementation:
        budgetMin = findViewById(R.id.budgetMin);
        budgetMax = findViewById(R.id.budgetMax);
        roomMin = findViewById(R.id.roomMin);
        roomMax = findViewById(R.id.roomMax);
        filterButton = findViewById((R.id.filterButton));
        chatButton = findViewById(R.id.chatButton);
        rentAsc = findViewById(R.id.rentAsc);
        rentDesc = findViewById(R.id.rentDesc);
        ratingAsc = findViewById(R.id.ratingAsc);
        ratingDesc = findViewById(R.id.ratingDesc);
        roomAsc = findViewById(R.id.roomAsc);
        roomDesc = findViewById(R.id.roomDesc);

        ServerCallback callback = new ServerCallback() {
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

                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                adapter = new Adapter(mContext, allApartments);
                recyclerView.setAdapter(adapter);
            }
        };

        final HomeLogic logic = new HomeLogic(this, new JSONArrayRequest(callback));
        JSONObject parameters = new JSONObject();
        logic.getAllApartments(false, parameters);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            adapter = new Adapter(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);

        filterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int bMin;
                int bMax;
                int rMin;
                int rMax;
                if(budgetMin.getText().toString().isEmpty()) {
                    bMin = -1;
                    bMax = -1;
                }else{
                    bMin = Integer.parseInt(budgetMin.getText().toString());
                    bMax = Integer.parseInt(budgetMax.getText().toString());
                }
                if(roomMin.getText().toString().isEmpty()) {
                    rMin = -1;
                    rMax = -1;
                }else{
                    rMin = Integer.parseInt(roomMin.getText().toString());
                    rMax = Integer.parseInt(roomMax.getText().toString());
                }
                JSONObject parameters = new JSONObject();
                try {
                    parameters.put("bMin", bMin);
                    parameters.put("bMax", bMax);
                    parameters.put("rMin", rMin);
                    parameters.put("rMax", rMax);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                logic.getAllApartments(true, parameters);
            }
        });

        filterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
            }
        });

        chatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HomeActivity.this, ChatActivity.class));
            }

        });

        rentAsc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Rent Asc", ": Trying to sort by rent ascending.");
                logic.getSortedApartments(1);
            }
        });

        rentDesc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Rent Desc", ": Trying to sort by rent descending.");
                logic.getSortedApartments(2);
            }
        });

        ratingAsc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Rating Asc", ": Trying to sort by rating ascending.");
                logic.getSortedApartments(3);
            }
        });

        ratingDesc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Rating Desc", ": Trying to sort by rating descending.");
                logic.getSortedApartments(4);
            }
        });

        roomAsc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Room Asc", ": Trying to sort by room ascending.");
                logic.getSortedApartments(5);
            }
        });

        roomDesc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Rent Asc", ": Trying to sort by rent ascending.");
                logic.getSortedApartments(6);
            }
        });


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