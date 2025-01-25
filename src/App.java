
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        // Library object that we do not want any changes being made.
        Library library = new Library("MGDOOM'S LIBRARY", "MGDOOM", 2025, false);

        // System.out.println(library);
        boolean isMember = false;
        String answer = "";

        isMember = checkIsMember( library, answer, isMember);

        System.out.println(isMember);

        scanner.close();
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



}