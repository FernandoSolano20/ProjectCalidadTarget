package Target;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestTargetUserAddress extends BaseTest {
    TargetLoginPage TLP;
    TargetUserAddress TUA;

    @BeforeMethod
    public void methodLevelSetUp()
    {
        TLP =  new TargetLoginPage(driver);
        TUA = new TargetUserAddress(driver);
    }

    @Test
    public void addNewAddress()throws InterruptedException {
        TLP.login("testFernando@gmail.com", "Pass1234");
        Thread.sleep(1000);
        driver.get("https://www.target.com/account/addresses");
        String result = TUA.createNewAddress("Fernando", "Solano", "Test123", "90011", "Los Angeles",
                "California" , "3125551212");
        Thread.sleep(5000);
        Assert.assertTrue(result.contains("Fernando"));

    }
}
