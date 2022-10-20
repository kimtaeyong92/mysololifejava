package com.kty.mysolelifejava.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kty.mysolelifejava.MainActivity;
import com.kty.mysolelifejava.R;

public class IntroActivity extends AppCompatActivity {
    Button loginBtn, joinBtn, noAccountBtn;
    Intent intent;

    private final String TAG = IntroActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        loginBtn = findViewById(R.id.loginBtn);
        joinBtn = findViewById(R.id.joinBtn);
        noAccountBtn = findViewById(R.id.noAccountBtn);

        loginBtn.setOnClickListener(click);
        joinBtn.setOnClickListener(click);
        noAccountBtn.setOnClickListener(click);
    }//onCreate

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.loginBtn:
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    break;

                case R.id.joinBtn:
                    intent = new Intent(getApplicationContext(), JoinActivity.class);
                    startActivity(intent);
                    break;

                case R.id.noAccountBtn:
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    break;
            }//switch
        }//onClick
    };//click()

}