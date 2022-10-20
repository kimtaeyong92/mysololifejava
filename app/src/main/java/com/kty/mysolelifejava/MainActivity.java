package com.kty.mysolelifejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.kty.mysolelifejava.mainfm.BookMarkFragment;
import com.kty.mysolelifejava.mainfm.MainFragment;
import com.kty.mysolelifejava.mainfm.StoreFragment;
import com.kty.mysolelifejava.mainfm.TalkFragment;
import com.kty.mysolelifejava.mainfm.TipFragment;

public class MainActivity extends AppCompatActivity {

    Button logoutBtn;
    ImageView bottomBtnhome, bottomBtntalk, bottomBtntip, bottomBtnmark, bottomBtnstore;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    MainFragment mainFragment = new MainFragment();
    BookMarkFragment bookMarkFragment = new BookMarkFragment();
    TalkFragment talkFragment = new TalkFragment();
    TipFragment tipFragment = new TipFragment();
    StoreFragment storeFragment = new StoreFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutBtn = findViewById(R.id.logoutBtn);
        bottomBtnhome = findViewById(R.id.bottomBtnhome);
        bottomBtntalk = findViewById(R.id.bottomBtntalk);
        bottomBtntip = findViewById(R.id.bottomBtntip);
        bottomBtnmark = findViewById(R.id.bottomBtnmark);
        bottomBtnstore = findViewById(R.id.bottomBtnstore);

        transaction.replace(R.id.fragmentArea, mainFragment).commit();

        logoutBtn.setOnClickListener(click);
        bottomBtnhome.setOnClickListener(click);
        bottomBtntalk.setOnClickListener(click);
        bottomBtntip.setOnClickListener(click);
        bottomBtnmark.setOnClickListener(click);
        bottomBtnstore.setOnClickListener(click);


    }//onCreate

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.logoutBtn:
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                    startActivity(intent);
                    finish();
                    break;


                case R.id.bottomBtntalk:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentArea, talkFragment).commit();
                    //transaction.replace(R.id.fragmentArea, talkFragment).commit();
                    break;

                case R.id.bottomBtntip:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentArea, tipFragment).commit();
                    break;

                case R.id.bottomBtnmark:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentArea, bookMarkFragment).commit();
                    break;

                case R.id.bottomBtnstore:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentArea, storeFragment).commit();
                    break;

            }
        }
    };
}