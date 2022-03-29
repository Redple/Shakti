package com.project.shakti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signupActivity extends AppCompatActivity {

    LinearLayout SignUpBtnFinal;
    private FirebaseAuth mAuth;
    TextView logbtn;
    EditText emailedt, passedt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        SignUpBtnFinal = findViewById(R.id.signUpbtnFinal);
        mAuth = FirebaseAuth.getInstance();

        emailedt = findViewById(R.id.emailEdt);
        passedt = findViewById(R.id.passEdt);
        logbtn = findViewById(R.id.logbtn);

        SignUpBtnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email=emailedt.getText().toString();
                String pass=passedt.getText().toString();

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(signupActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(signupActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signupActivity.this,loginActivity.class);
                startActivity(intent);
            }
        });
    }
}