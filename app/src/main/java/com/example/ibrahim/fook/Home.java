package com.example.ibrahim.fook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private CardView cardFormuls,cardAddFormul,cardRegformul,cardCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cardFormuls = findViewById(R.id.card_Formuls);
        cardAddFormul =findViewById(R.id.card_NewFormul);
        cardRegformul = findViewById(R.id.card_RegFormuls);
        cardCalc =findViewById(R.id.card_Calc);
        // cartların listenerleri
        cardFormuls.setOnClickListener(this);
        cardAddFormul.setOnClickListener(this);
        cardRegformul.setOnClickListener(this);
        cardCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i ;
        switch (v.getId()) {
            case R.id.card_Formuls :i=new  Intent(this,Formuls.class);startActivity(i);break;
            case R.id.card_NewFormul :i=new Intent(this,NewFormul.class);startActivity(i);break;
            case R.id.card_RegFormuls :i=new Intent(this,RegFormul.class);startActivity(i);break;
            case R.id.card_Calc :i=new Intent(this,Calc.class);startActivity(i);break;
            default:break;
        }
    }
}
