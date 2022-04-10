package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TargetPasswordRecoveryPage extends BasePage{

    TargetPasswordRecoveryPage(WebDriver driver){
        super(driver);
    }

    By AccountBtn = By.className("styles__AccountStyledLinkNamedIcon-sc-17dxxwu-17");
    By SignButton = By.cssSelector("a[href=\"/account\"][data-test=\"accountNav-signIn\"]");
    By RecoveryPassword = By.id("recoveryPassword");
    By Input_UserName = By.id("username");
    By Button_Continue = By.id("continue");
    By Spam_Fail = By.cssSelector(".AlertDisplay__AlertDisplayStyles-sc-1m3ky8a-0 div");
    By Spam_Success = By.className("Heading__StyledHeading-sc-1mp23s9-0");

    private void navigate() throws InterruptedException{
        click(AccountBtn);
        Thread.sleep(1500);
        click(SignButton);
        Thread.sleep(3000);
        click(RecoveryPassword);
        Thread.sleep(1000);
    }

    public boolean recoveryPasswordFail(String emailAddress)throws InterruptedException{
        this.navigate();
        sendKeys(Input_UserName, emailAddress);
        Thread.sleep(500);
        driver.findElement(Button_Continue).submit();
        Thread.sleep(500);
        driver.findElement(Button_Continue).submit();
        WebElement webElement = driver.findElement(Spam_Fail);
        return webElement.getText().equalsIgnoreCase("We can't find your account.");
    }

    public boolean recoveryPassword(String emailAddress)throws InterruptedException{
        driver.navigate().back();
        this.navigate();
        sendKeys(Input_UserName, emailAddress);
        Thread.sleep(1500);
        driver.findElement(Button_Continue).submit();
        Thread.sleep(500);
        driver.findElement(Button_Continue).submit();
        Thread.sleep(900);
        WebElement webElement = driver.findElement(Spam_Success);
        return webElement.getText().equalsIgnoreCase("Verification code sent");
    }

}
