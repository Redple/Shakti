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



public class loginActivity extends AppCompatActivity {

    EditText edtmail, edtpass;
    LinearLayout  logInbtnFinal;
    TextView signbtn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtmail = findViewById(R.id.edtMail);
        edtpass = findViewById(R.id.edtPass);

        mAuth = FirebaseAuth.getInstance();
        logInbtnFinal = findViewById(R.id.loginbtnFinal);
        signbtn = findViewById(R.id.signbtn);

        logInbtnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { 

                String email=edtmail.getText().toString();
                String pass=edtpass.getText().toString();


                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent = new Intent(loginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(loginActivity.this, "Error...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this,signupActivity.class);
                startActivity(intent);
            }
        });

    }
}