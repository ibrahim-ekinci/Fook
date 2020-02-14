package com.example.ibrahim.fook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingUpActivity extends AppCompatActivity {
    EditText emailText,passwordText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        emailText =findViewById(R.id.girisEmail);
        passwordText=findViewById(R.id.girisParola);

        mAuth =FirebaseAuth.getInstance();
        FirebaseUser user =mAuth.getCurrentUser();

        if (user !=null){
            Intent intent = new Intent(getApplicationContext(),Home.class);
            startActivity(intent);
        }
    }

    public void signUp(View view){
        mAuth.createUserWithEmailAndPassword(emailText.getText().toString(),passwordText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){
                         // FirebaseUser user =mAuth.getCurrentUser();
                          //intent
                          Intent intent = new Intent(getApplicationContext(),Home.class);
                          startActivity(intent);
                      }else{
                          Toast.makeText(SingUpActivity.this,"Başarısız Kayıt",Toast.LENGTH_LONG).show();
                      }
                    }
                });

    }
    public  void signIn(View view){
        mAuth.signInWithEmailAndPassword(emailText.getText().toString(),passwordText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            // FirebaseUser user =mAuth.getCurrentUser();
                            //intent
                            Intent intent = new Intent(getApplicationContext(),Home.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(SingUpActivity.this,"Başarısız Giriş",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
