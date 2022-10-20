package com.kty.mysolelifejava.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kty.mysolelifejava.MainActivity;
import com.kty.mysolelifejava.R;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmailArea, loginPasswordArea;
    Button loginTomainBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

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

            signIn(email,password);

        }
    }; // click

    private void signIn (String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "입력하신 E-mail/Password 확인해주세요",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}