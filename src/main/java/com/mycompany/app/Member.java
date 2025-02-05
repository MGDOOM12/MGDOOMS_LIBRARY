package com.mycompany.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import io.github.cdimascio.dotenv.Dotenv;

public class Member {
    String firstname;
    String lastname;
    String dobString;
    String email;
    int memberId; 
    private boolean isMember;
    Random rnd = new Random();

    public Member(String firstname, String lastname, String dobString, String email, int memberId, boolean isMember){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dobString = dobString;
        this.email = email;
        this.memberId = memberId;
        this.isMember = isMember;
    }

    @Override
    public String toString(){
        return this.firstname + " " + this.lastname + " " + this.dobString + " " + this.email + " " + this.memberId + " " + this.isMember ;
    }

    public void addUser(){
        Dotenv dotenv = Dotenv.load();

        String DB_URL = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_USER_PASSWORD");
        this.isMember = true;
        String sql = "INSERT INTO MEMBER_TABLE (first_name, last_name, email, dob, member_id, is_member) VALUES (?, ?, ?, ?, ?, ?);";

        try(Connection conn = DriverManager.getConnection(DB_URL, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
                System.out.println("Adding our new member to the database...");
                stmt.setString(1, this.firstname);
                stmt.setString(2, this.lastname);
                stmt.setString(3, this.email);
                stmt.setString(4, this.dobString);
                stmt.setInt(5, this.memberId);
                stmt.setBoolean(5, this.isMember);

                int rowsInserted = stmt.executeUpdate();
                if(rowsInserted > 0){
                    System.out.println("You are now a new member.");
                }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getIsMember(){
        return isMember;
    }


}


