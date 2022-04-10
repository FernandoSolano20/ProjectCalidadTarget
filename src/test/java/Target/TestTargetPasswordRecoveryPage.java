package Target;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetPasswordRecoveryPage extends BaseTest{

    public TargetPasswordRecoveryPage TPRP;

    @BeforeMethod
    public void methodLevelSetUp(){ TPRP = new TargetPasswordRecoveryPage(driver); }

    @Test
    public void testFakePasswordRecovery() throws InterruptedException {
        Assert.assertTrue(TPRP.recoveryPasswordFail("UserCenfofake2@ucenfotec.ac.cr"));
    }

    @Test
    public void testPasswordRecovery() throws InterruptedException {
        Assert.assertTrue(TPRP.recoveryPassword("elizabethmontoyasandoval@gmail.com"));
    }


}
