package com.kty.mysolelifejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.kty.mysolelifejava.member.IntroActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() == null){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                    startActivity(intent);
                }
            },3000); // postDelayed to LoginActivity (current uid not exist)
        }else if(mAuth.getCurrentUser() != null){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            },3000); // postDelayed to MainActivity (current uid exist)
        }


    }//onCreate
}