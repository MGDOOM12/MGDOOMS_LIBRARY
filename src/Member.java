import java.util.Random;

public class Member {
    String firstname;
    String lastname;
    String dobString;
    int memberId; 
    Random rnd = new Random();

    Member(String firstname, String lastname, String dobString){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dobString = dobString;
        this.memberId = 10000000 + rnd.nextInt(899999999); 
    }

}
