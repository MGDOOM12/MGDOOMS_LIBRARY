package com.mycompany.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;




public class App {



    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Library object that we do not want any changes being made.
        Library library = new Library("MGDOOM'S LIBRARY", "MGDOOM", 2025, false);
        Member member = new Member("", "", "", "", 0);
        // System.out.println(library);
        boolean isMember = false;
        String answer = "";
 
        isMember = checkIsMember( library, answer, isMember, scanner);

        System.out.println(isMember);

        if(!isMember){
            // Create a method to create a user;
            member = createMember(library, scanner);

        }else{
            // Create a method to find a user;
             member = FindMember(scanner);
        }

        System.out.println(member);

        scanner.close();
    }



    public static boolean checkIsMember(Library library, String answer, boolean isMember, Scanner scanner){
        do {
            System.out.println("Welcome to " + library.getName() + " my name is " + library.getLibrarian() + ".");
            System.out.printf("Are you a member with %s? Yes or No: ", library.getName());
            answer = scanner.nextLine().toLowerCase();

            if(answer.equals("yes")){
                isMember = true;
            }
            else if(answer.equals("no")){
                isMember = false;
            }else{
                System.out.println("Please answer with yes or no. ");
            }
        } while(!answer.equals("yes") && !answer.equals("no"));
        return  isMember;
    }

    

    public static Member createMember(Library library, Scanner scanner){
        Random rnd = new Random();

        String answer = "";
        String firstName ="";
        String lastName="";
        String dobString="";
        String email="";
        int memberID = 10000000 + rnd.nextInt(89999999);

        do{
            System.out.print("It look like you are not a member. Would you like to join: Yes or No: ");
            answer = scanner.nextLine().toLowerCase();

            if(answer.equals("yes")){
                System.out.printf("Great! We are excited for you to join %s \n.", library.getName());
                System.out.println("We have a few questions we will need you to answer to create you an account");
                System.out.print("What is your first name?: ");
                firstName = scanner.nextLine();
                System.out.print("What is your last name?: ");
                lastName = scanner.nextLine();
                System.out.print("What is you date of birth?: ");
                dobString = scanner.nextLine();
                System.out.print("What is your email?: ");
                email = scanner.nextLine();
            }else{
                System.out.println("Sorry you don't want to join. Have a great day!");
            }

        }while(!answer.equals("yes") && !answer.equals("no"));

        Member newMember = new Member(firstName, lastName, dobString, email, memberID);
        newMember.addUser();
        
        System.out.print("Your new member ID is: " + memberID);
        // Create an if/else statement to handle errors if member creation fails
        return newMember;
    }


    // A method that is going to take the users memberID input and find their information in the database.
    public static Member FindMember(Scanner scanner){ 
        Dotenv dotenv = Dotenv.load();

        String DB_URL = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_USER_PASSWORD");

        String foundFirstName = "";
        String foundLastName= "";
        String foundEmail= "";
        int foundMemberId = 0;
        String foundDob= "";

        System.out.print("Great! We just need your Member number to search you: ");
        foundMemberId = scanner.nextInt();
        String selectUser = "SELECT * FROM MEMBER_TABLE WHERE member_id=" + foundMemberId + ";";

        try(Connection conn = DriverManager.getConnection(DB_URL, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectUser);
        ){
            while(rs.next()){
                foundFirstName = rs.getString("first_name");
                foundLastName = rs.getString("last_name");
                foundEmail = rs.getString("first_name");
                foundDob = rs.getString("dob");
            }
        } catch(SQLException e){
        e.printStackTrace();
        }

        Member foundMember = new Member(foundFirstName,foundLastName,foundEmail,foundDob,foundMemberId);
        return foundMember;
    }


    
}

// 703298586