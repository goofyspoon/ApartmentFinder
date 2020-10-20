package com.example.ApartmentFinder.search_page;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ApartmentFinder.JsonRequestActivity;
import com.example.ApartmentFinder.net_utils.Const;
import com.example.ApartmentFinder.R;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchPageActivity extends AppCompatActivity {

    private static final String TAG = "SearchPage";
    private EditText textBudget;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Log.d(TAG, "Got to search Page");
        textBudget = findViewById(R.id.textBudget);
        btnSearch = findViewById((R.id.btnSearch));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String budget = textBudget.getText().toString();
                JSONObject object = new JSONObject();
                try {
                    //Input API parameters
                    object.put("rent", ""+budget);
                } catch (JSONException error) {
                    Log.d(TAG, "Response is: " + error.getMessage() + "");
                }

                JsonRequestActivity.getInstance().GETJsonObjectRequest(Const.postmanURL+ "/Search?rent="+ textBudget, object);

            }
            });
    }
}