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

import java.util.ArrayList;
import java.util.List;

public class fragment_user_formuls extends Fragment {

    View v;
    private RecyclerView myRecylerview;
    private List<user_formul> lstUserFormul;

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

        lstUserFormul = new ArrayList<>();
        lstUserFormul.add(new user_formul("Kare Alanı","a^2",R.drawable.geo));
        lstUserFormul.add(new user_formul("Kare Çevresi","a*4",R.drawable.geo));
        lstUserFormul.add(new user_formul("Genel Hız Formülü","x/t",R.drawable.fiz));
        lstUserFormul.add(new user_formul("İvmeli Hareket Formülü","m*a",R.drawable.fiz));
        lstUserFormul.add(new user_formul("Yıllık Faiz Formülü","x/t",R.drawable.mat));
        lstUserFormul.add(new user_formul("Aylık Faiz Formülü","x/t",R.drawable.mat));
        lstUserFormul.add(new user_formul("Kare Alanı","a^2",R.drawable.geo));
        lstUserFormul.add(new user_formul("Kare Çevresi","a*4",R.drawable.geo));
        lstUserFormul.add(new user_formul("Genel Hız Formülü","x/t",R.drawable.fiz));
        lstUserFormul.add(new user_formul("İvmeli Hareket Formülü","m*a",R.drawable.fiz));
        lstUserFormul.add(new user_formul("Yıllık Faiz Formülü","x/t",R.drawable.mat));
        lstUserFormul.add(new user_formul("Aylık Faiz Formülü","x/t",R.drawable.mat));
        lstUserFormul.add(new user_formul("Kare Alanı","a^2",R.drawable.geo));
        lstUserFormul.add(new user_formul("Kare Çevresi","a*4",R.drawable.geo));
        lstUserFormul.add(new user_formul("Genel Hız Formülü","x/t",R.drawable.fiz));
        lstUserFormul.add(new user_formul("İvmeli Hareket Formülü","m*a",R.drawable.fiz));
        lstUserFormul.add(new user_formul("Yıllık Faiz Formülü","x/t",R.drawable.mat));
        lstUserFormul.add(new user_formul("Aylık Faiz Formülü","x/t",R.drawable.mat));


    }
}
