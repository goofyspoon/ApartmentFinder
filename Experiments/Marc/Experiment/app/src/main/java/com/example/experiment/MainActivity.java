package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnReg;
    private TextView userName;
    private TextView password;
    private TextView loadingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById (R.id.loginBtn);
        userName = (TextView) findViewById (R.id.tvUsername);
        password = (TextView) findViewById (R.id.tvPassword);
        loadingBtn = (TextView) findViewById (R.id.tvLoading);
        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.loginBtn) {
            loadingBtn.setText("Logging in...");
        }
    }
}