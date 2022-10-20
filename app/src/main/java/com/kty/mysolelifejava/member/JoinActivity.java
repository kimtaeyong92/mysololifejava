package com.kty.mysolelifejava.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kty.mysolelifejava.R;

public class JoinActivity extends AppCompatActivity {

    EditText emailArea, passwordArea1, passwordArea2;
    Button fb_joinBtn;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance();

        emailArea = findViewById(R.id.emailArea);
        passwordArea1 = findViewById(R.id.passwordArea1);
        passwordArea2 = findViewById(R.id.passwordArea2);

        fb_joinBtn = findViewById(R.id.fb_joinBtn);

        fb_joinBtn.setOnClickListener(click);
    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String email = emailArea.getText().toString();
            String password = passwordArea1.getText().toString();
            String password_ch = passwordArea2.getText().toString();

            if( email.isEmpty()){
                Toast.makeText(getApplicationContext(), "이메일을 입력하세요",Toast.LENGTH_SHORT).show();
            }

            if( password.isEmpty()){
                Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
            }

            if( password_ch.isEmpty()){
                Toast.makeText(getApplicationContext(), "비밀번호 확인을 입력하세요", Toast.LENGTH_SHORT).show();
            }

            if( !password.equals(password_ch)){
                Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
            }

            join(email, password);

        }
    };

    private void join(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                        } else {
                            // If sign in fails, display a message to the user.
                        }
                    }
                });
    }


}