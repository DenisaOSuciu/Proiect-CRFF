package com.upt.cti.smc.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class People extends RealmObject {
    @PrimaryKey
     int user_id;
     String user_name;
     String user_username;
     String password;

    public int getUser_id(){
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id=user_id;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_username(String user_username){
        this.user_username=user_username;
    }


    public String getUser_username(){
        return user_username;
    }



    public String getUser_password(){
        return password;
    }
    public void setUser_password(String password){this.password=password;}
    public void setUser_name(String user_name){
        this.user_name=user_name;
    }
}

