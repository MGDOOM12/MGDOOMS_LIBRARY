import java.util.Random;

public class Member {
    String firstname;
    String lastname;
    String dobString;
    String email;
    int memberId; 
    Random rnd = new Random();

    // String url = "jdbc:mysql://localhost:3306/mydatabase"; // change to your MySQL DB info
    // String user = "root";  // replace with your MySQL username
    // String password = "password";  // replace with your MySQL password

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
