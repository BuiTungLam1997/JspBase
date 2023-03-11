package com.example.demo.model;

public class DatabaseManagement {
    public boolean checkUser(String username ,String password){
        //Tao DB query de check
        if(username.equals("Lam123") && password.equals("Lam123")){
            return true;
        }
        else {
           return false;
        }
    }

}
