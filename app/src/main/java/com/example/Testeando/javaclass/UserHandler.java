package com.example.Testeando.javaclass;

import com.google.firebase.database.IgnoreExtraProperties;



@IgnoreExtraProperties
public class UserHandler {

    public String nombre,email,telef;

    public UserHandler() {

    }

    public void User (String email){

        this.email=email;
    }

    public UserHandler(String email, String nombre, String telef) {
        this.nombre = nombre;
        this.email = email;
        this.telef=telef;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }
}







