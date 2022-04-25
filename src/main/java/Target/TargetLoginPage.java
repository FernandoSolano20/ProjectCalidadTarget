package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TargetLoginPage extends BasePage{

     TargetLoginPage(WebDriver driver){
        super(driver);
    }

    By AccountBtn = By.className("styles__AccountStyledLinkNamedIcon-sc-17dxxwu-17");
    By SignButton = By.cssSelector("a[href=\"/account\"][data-test=\"accountNav-signIn\"]");
    By Input_UserName = By.id("username");
    By Input_Password =  By.id("password");
    By Button_Login = By.id("login");
    By Spam_LogonName = By.className("styles__AccountLinkText-sc-17dxxwu-18");
    By Spam_Fail = By.className("AlertDisplay__AlertDisplayStyles-sc-1m3ky8a-0");
    By skipButton =  By.cssSelector(".styles__StyledCol-sc-ct8kx6-0 .Link__StyledLink-sc-4b9qcv-0");

    public void navigate() throws InterruptedException{
        click(AccountBtn);
        Thread.sleep(1500);
        click(SignButton);
        Thread.sleep(3000);
    }

    public boolean wrongLogin(String emailAddress, String password) throws InterruptedException{
        this.navigate();
        WebElement element = driver.findElement(Input_UserName);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        WebElement elementPassword = driver.findElement(Input_Password);
        elementPassword.sendKeys(Keys.CONTROL + "a");
        elementPassword.sendKeys(Keys.DELETE);
        Thread.sleep(1000);

        sendKeys(Input_UserName, emailAddress);
        sendKeys(Input_Password, password);
        Thread.sleep(100);
        driver.findElement(Button_Login).submit();
        Thread.sleep(1000);
        WebElement webElement = driver.findElement(Spam_Fail);
        String userName = webElement.getText();
        return userName.equalsIgnoreCase("We can't find your account.");

    }

    public boolean login(String emailAddress, String password) throws InterruptedException{
        this.navigate();
        WebElement element = driver.findElement(Input_UserName);
        element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);

        WebElement elementPassword = driver.findElement(Input_Password);
        elementPassword.sendKeys(Keys.CONTROL + "a");
        elementPassword.sendKeys(Keys.DELETE);

        Thread.sleep(1000);
        sendKeys(Input_UserName, emailAddress);
        sendKeys(Input_Password, password);
        Thread.sleep(100);
        driver.findElement(Button_Login).submit();
        Thread.sleep(8000);
        WebElement webElement = driver.findElement(Spam_LogonName);
        String userName = webElement.getText();
        return userName.equalsIgnoreCase("Hi, Fernando");
    }

    public void createAccount (String name, String lastName, String email, String password) throws InterruptedException{
        By CreateAccountBtn = By.cssSelector("#createAccount");
        By Input_FirstName = By.id("firstname");
        By Input_LastName =  By.id("lastname");
        this.navigate();
        click(CreateAccountBtn);
        sendKeys(Input_UserName, email);
        sendKeys(Input_FirstName, name);
        sendKeys(Input_LastName, lastName);
        sendKeys(Input_Password, password);
        click(CreateAccountBtn);
    }
}
