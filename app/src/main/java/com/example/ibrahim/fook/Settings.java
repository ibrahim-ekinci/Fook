package com.example.ibrahim.fook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Settings extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signOut(View view){
        mAuth.signOut();
        Intent intent = new Intent(getApplicationContext(),SingUpActivity.class);
        startActivity(intent);
    }


}
