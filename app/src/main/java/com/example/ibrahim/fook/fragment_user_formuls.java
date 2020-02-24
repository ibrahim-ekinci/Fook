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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fragment_user_formuls extends Fragment {

    View v;
    private RecyclerView myRecylerview;
    private List<user_formul> lstUserFormul;
    FirebaseAuth  mAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    RecyclerViewAdapter_formuls recyclerAdapter;
    public fragment_user_formuls() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v=inflater.inflate(R.layout.user_formuls,container,false);
        myRecylerview=(RecyclerView)v.findViewById(R.id.user_recyclerview);
        recyclerAdapter = new RecyclerViewAdapter_formuls(getContext(),lstUserFormul);
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


        getData();

    }
    public void getData(){
        DatabaseReference newReferance =database.getReference("Formuls/"+user.getUid().toString());

        Query query = newReferance.orderByChild("usermessagetime");
        newReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds :dataSnapshot.getChildren()){
                    System.out.println(ds.getValue());
                    HashMap<String, Object> result = (HashMap<String, Object>) ds.getValue();
                    String formul =result.get("formul").toString();
                    String name = result.get("name").toString();
                    int photo = Integer.parseInt(result.get("photo").toString());

                    lstUserFormul.add(new user_formul(name,formul,photo));
                    recyclerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {//data okunamazsa
                System.out.println("Hata");
                Toast.makeText(getContext(), databaseError.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
