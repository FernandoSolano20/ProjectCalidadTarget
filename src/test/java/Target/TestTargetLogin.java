package Target;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetLogin extends BaseTest{
    public TargetLoginPage TLP;

    @BeforeMethod
    public void methodLevelSetUp()
    {
        TLP = new TargetLoginPage(driver);
        String baseUrl = "https://www.target.com/";
        driver.get(baseUrl);
    }

    public void testFakeUserLogin() throws InterruptedException {
        Assert.assertTrue(TLP.wrongLogin("fakeUser@ucenfotec.ac.cr", "error123"));
    }

    @Test
    public void testLogin() throws InterruptedException {
        Assert.assertTrue(TLP.login("testFernando@gmail.com", "Pass1234"));
    }

    public void createAccountWithUsedEmail ()  throws InterruptedException {
        By errorMessageDiv = By.xpath("//*[@data-test='authAlertDisplay']");
        TLP.createAccount("Adrian", "Obando", "cobandol@ucenfotec.ac.cr", "Pass1234");
        String errorMessage = driver.findElement(errorMessageDiv).getText();
        Assert.assertEquals(errorMessage, "That Target.com account already exists. You can Sign In or reset your password.");

    }
}
