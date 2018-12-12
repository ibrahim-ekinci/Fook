package com.example.ibrahim.fook;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Formuls extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formuls);

        tabLayout= findViewById(R.id.tablayout_id);
        viewPager=findViewById(R.id.viewpeger_id);
        adapter = new ViewPageAdapter(getSupportFragmentManager());

        //Add Fragment
       adapter.AddFragment(new fragment_user_formuls(),"Formüller");
       adapter.AddFragment(new fragment_admin_formuls(),"Önerilen");
       adapter.AddFragment(new fragment_public_formuls(),"Diğer");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_assignment_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_assignment_turned_in_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_assignment_black_24dp);






    }
}
