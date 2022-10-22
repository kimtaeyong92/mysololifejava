package com.kty.mysolelifejava.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kty.mysolelifejava.fb.FBRef;
import com.kty.mysolelifejava.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {

    EditText emailArea, passwordArea1, passwordArea2;
    Button fb_joinBtn;

    private FirebaseAuth mAuth;

    FBRef fbRef = new FBRef();

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

            // 이메일 패턴 확인을 위한 정규식
            String email_pattern = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
            Pattern pattern = Pattern.compile(email_pattern);
            Matcher matcher = pattern.matcher(email);


            // 이메일 EditText 값이 있는지, E-mail 패턴인지 확인
            if( email.isEmpty()){
                Toast.makeText(getApplicationContext(), "이메일을 입력하세요",Toast.LENGTH_SHORT).show();
            }else if(!matcher.matches()){
                Toast.makeText(getApplicationContext(), "이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
            }

            // 패스워드 EditText 값이 있는지 확인
            if( password.isEmpty()){
                Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
            }

            // 패스워드확인 EditText 값이 있는지 확인
            if( password_ch.isEmpty()){
                Toast.makeText(getApplicationContext(), "비밀번호 확인을 입력하세요", Toast.LENGTH_SHORT).show();
            }

            // 패스워드-패스워드확인 EditText 값이 일치하는지 확인
            if( !password.equals(password_ch)){
                Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
            }

            //아래 join() 메서드 호출
            join(email, password);

        }
    };

    // 신규가입 시 Firebase 서버에 등록되도록 하는 메서드
    private void join(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공 시 처리되는 영역

                            /*String uid = mAuth.getCurrentUser().getUid();

                            fbRef.member.child(uid).setValue("테스트용");*/

                            Intent intent = new Intent(JoinActivity.this, IntroActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // 회원가입 실패 시 처리되는 영역

                            Toast.makeText(getApplicationContext(), "이미 가입 된 계정입니다.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


}