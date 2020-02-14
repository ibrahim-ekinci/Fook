package com.example.ibrahim.fook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = findViewById(R.id.tv_spalsh);
        iv = findViewById(R.id.img_spalsh);
        // Animation myanim = new AnimationUtils.loadAnimation(this,R.anim.mytransition);
        Animation myanim = new AnimationUtils().loadAnimation(this, R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
         final Intent i = new Intent(this,SingUpActivity.class);
        Thread timer = new Thread() {
        public void run(){
            try{
                sleep(3000);
            }
            catch(
                    InterruptedException e)

            {
                e.printStackTrace();
            }
            finally{
                startActivity(i);
                finish();
            }
        }

        };
        timer.start();


    }
}
