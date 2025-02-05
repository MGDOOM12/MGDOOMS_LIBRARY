import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.mycompany.app.Member;

public class MemberTest {
    
    @Test
    public void MemberTestSucesfullCreation(){
        Member memberTests = new Member("TestFirst","TestLast","TestDob","TestEmail",00000000, false);

        assertNotNull("Member should not be null", memberTests);
    }

    @Test
    public void MemberTestSuccefulMemberCreationInDatabase(){
        Member emptyMember = new Member("TestDBFirst","TestDBLast","TestDBDob","TestDBEmail",11111111,false);

        emptyMember.addUser();

        assertTrue("Member.isMember should be true if created succesfully", emptyMember.getIsMember());


    }

}
