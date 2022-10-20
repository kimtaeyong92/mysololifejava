package com.kty.mysolelifejava.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kty.mysolelifejava.R;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmailArea, loginPasswordArea;
    Button loginTomainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmailArea = findViewById(R.id.loginEmailArea);
        loginPasswordArea = findViewById(R.id.loginPasswordArea);
        loginTomainBtn = findViewById(R.id.loginTomainBtn);

        loginTomainBtn.setOnClickListener(click);
    }//onCreate

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String email = loginEmailArea.getText().toString();
            String password = loginPasswordArea.getText().toString();

            if( email.isEmpty()){
                Toast.makeText(getApplicationContext(), "E-Mail을 입력해주세요",Toast.LENGTH_SHORT).show();
            }

            if( password.isEmpty() ){
                Toast.makeText(getApplicationContext(), "Password를 입력해주세요",Toast.LENGTH_SHORT).show();
            }

        }
    }; // click

}