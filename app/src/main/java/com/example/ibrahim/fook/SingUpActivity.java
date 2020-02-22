package com.example.ibrahim.fook;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingUpActivity extends AppCompatActivity {
    EditText emailText,passwordText;
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;

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
            finish();
        }


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient  = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,null)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

               signInButton=findViewById(R.id.sign_in_button_google);

             //   mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==RC_SIGN_IN){
            GoogleSignInResult result  =Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess()){
                GoogleSignInAccount acct = result.getSignInAccount();
            }
        }
    }

    public void googleSingIn(View view){
      //  Intent sinInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
       // startActivityForResult(sinInIntent,RC_SIGN_IN);
        Toast.makeText(SingUpActivity.this,"google",Toast.LENGTH_LONG).show();
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
        this.finish();


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
                          finish();
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
                            finish();
                        }else{
                            Toast.makeText(SingUpActivity.this,"Başarısız Giriş",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
