package com.mycompany.app;
import java.util.Random;

public class Member {
    // static final String DB_URL = "jdbc:mysql://192.168.0.55";
    // static final String member = "";
    // static final String password = "";
    String firstname;
    String lastname;
    String dobString;
    String email;
    int memberId; 
    Random rnd = new Random();

    Member(String firstname, String lastname, String dobString, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dobString = dobString;
        this.email = email;
        this.memberId = 10000000 + rnd.nextInt(899999999); 
    }

    @Override
    public String toString(){
        return this.firstname + " " + this.lastname + " " + this.dobString + " " + this.email + " " + this.memberId;
    }

}
