package com.example.ibrahim.fook;

public class user_formul {

    private String Name;
    private String Formul;
    private int Photo;

    public user_formul() {
    }

    public user_formul(String name, String formul, int photo) {
        Name = name;
        Formul = formul;
        Photo = photo;

    }

    //getter

    public String getName() {
        return Name;
    }

    public String getFormul() {
        return Formul;
    }

    public int getPhoto() {
        return Photo;
    }


    //setter

    public void setName(String name) {
        Name = name;
    }

    public void setFormul(String formul) {
        Formul = formul;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
