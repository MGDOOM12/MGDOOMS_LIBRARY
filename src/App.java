
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        // Library object that we do not want any changes being made.
        Library library = new Library("MGDOOM'S LIBRARY", "MGDOOM", 2025, false);
        Member member;
        // System.out.println(library);
        boolean isMember = false;
        String answer = "";
        Member member;

        isMember = checkIsMember( library, answer, isMember);

        // System.out.println(isMember);

        if(!isMember){
            // Create a method to create a user;
            
        }else{
            // Create a method to find a user;
        }


    }



    public static boolean checkIsMember(Library library, String answer, boolean isMember){
        Scanner scanner = new Scanner(System.in);

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
        scanner.close();

        return  isMember;
    }

    

    public static Member createMember(Library library){
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        String firstName ="";
        String lastName="";
        String dobString="";
        String email="";

        do{
            System.out.println("It look like you are not a member. Would you like to join: Yes or No:");
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

        Member newMember = new Member(firstName, lastName, dobString, email);
        scanner.close();
        return newMember;
    }
}