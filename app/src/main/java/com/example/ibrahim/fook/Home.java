package com.example.ibrahim.fook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private CardView cardFormuls,cardAddFormul,cardRegformul,cardCalc,cardSettings;
    private FirebaseAuth mAuth;
//menü baş
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.options_menu_sign_out){
            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(),SingUpActivity.class);
            startActivity(intent);
        }if (item.getItemId()==R.id.options_menu_settings){
            //intent gelecek...
        }
        return super.onOptionsItemSelected(item);
    }

    //menü son

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cardFormuls = findViewById(R.id.card_Formuls);
        cardAddFormul =findViewById(R.id.card_NewFormul);
        cardRegformul = findViewById(R.id.card_RegFormuls);
        cardCalc =findViewById(R.id.card_Calc);
        cardSettings = findViewById(R.id.card_Settings);
        // cartların listenerleri
        cardFormuls.setOnClickListener(this);
        cardAddFormul.setOnClickListener(this);
        cardRegformul.setOnClickListener(this);
        cardCalc.setOnClickListener(this);
        cardSettings.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        Intent i ;
        switch (v.getId()) {
            case R.id.card_Formuls :i=new  Intent(this,Formuls.class);startActivity(i);break;
            case R.id.card_NewFormul :i=new Intent(this,NewFormul.class);startActivity(i);break;
            case R.id.card_RegFormuls :i=new Intent(this,RegFormul.class);startActivity(i);break;
            case R.id.card_Calc :i=new Intent(this,Calc.class);startActivity(i);break;
            case R.id.card_Settings :i=new Intent(this,Settings.class);startActivity(i);break;
            default:break;
        }
    }
}
