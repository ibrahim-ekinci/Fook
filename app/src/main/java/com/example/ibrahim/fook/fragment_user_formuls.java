package com.example.ibrahim.fook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fragment_user_formuls extends Fragment {

    View v;
    private RecyclerView myRecylerview;
    private List<user_formul> lstUserFormul;
    FirebaseAuth  mAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    public fragment_user_formuls() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v=inflater.inflate(R.layout.user_formuls,container,false);
        myRecylerview=(RecyclerView)v.findViewById(R.id.user_recyclerview);
        RecyclerViewAdapter_formuls recyclerAdapter = new RecyclerViewAdapter_formuls(getContext(),lstUserFormul);
        myRecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecylerview.setAdapter(recyclerAdapter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference =database.getReference();
        user =mAuth.getCurrentUser();


       lstUserFormul = new ArrayList<>();
        //lstUserFormul.add(new user_formul("Kare Alanı","a^2",R.drawable.geo));
       // lstUserFormul.add(new user_formul("Kare Çevresi","a*4",R.drawable.geo));
       // lstUserFormul.add(new user_formul("Genel Hız Formülü","x/t",R.drawable.fiz));
        // lstUserFormul.add(new user_formul("İvmeli Hareket Formülü","m*a",R.drawable.fiz));
       // lstUserFormul.add(new user_formul("Yıllık Faiz Formülü","x/t",R.drawable.mat));
       // lstUserFormul.add(new user_formul("Aylık Faiz Formülü","x/t",R.drawable.mat));
       // lstUserFormul.add(new user_formul("Kare Alanı","a^2",R.drawable.geo));
        //lstUserFormul.add(new user_formul("Kare Çevresi","a*4",R.drawable.geo));
       // lstUserFormul.add(new user_formul("İvmeli Hareket Formülü","m*a",R.drawable.fiz));
       // lstUserFormul.add(new user_formul("Yıllık Faiz Formülü","x/t",R.drawable.mat));
       // lstUserFormul.add(new user_formul("Aylık Faiz Formülü","x/t",R.drawable.mat));
       // lstUserFormul.add(new user_formul("Kare Alanı","a^2",R.drawable.geo));
       // lstUserFormul.add(new user_formul("Kare Çevresi","a*4",R.drawable.geo));
       // lstUserFormul.add(new user_formul("Genel Hız Formülü","x/t",R.drawable.fiz));
       // lstUserFormul.add(new user_formul("İvmeli Hareket Formülü","m*a",R.drawable.fiz));
       // lstUserFormul.add(new user_formul("Yıllık Faiz Formülü","x/t",R.drawable.mat));
       // lstUserFormul.add(new user_formul("Aylık Faiz Formülü","x/t",R.drawable.mat));

        getData();

    }
    public void getData(){
        DatabaseReference newReferance =database.getReference("Formuls/"+user.getUid().toString());

        newReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                System.out.println("DataS c"+dataSnapshot.getChildren());
                System.out.println("DataS v"+dataSnapshot.getValue());
                System.out.println("DataS k"+dataSnapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {//data okunamazsa

                Toast.makeText(getContext(), databaseError.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
