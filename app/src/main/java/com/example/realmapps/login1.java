package com.example.realmapps;

import io.realm.RealmObject;

public class login1 extends RealmObject {
    private String name;
    private  String password;

    public login1(){

    }
    public login1(String name, String password){
        this.name=name;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "login1{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
