package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TargetHomePage extends BasePage{

    private WebDriver driver;

    By Logo = By.id("home");
    By input = By.id("zipOrCityState");
    By locationMenu =  By.id("storeId-utilityNavBtn");

    TargetHomePage(WebDriver driver){
        super(driver);
    }

    public void clickMenuLogo() throws InterruptedException
    {
        click(Logo);
        Thread.sleep(1500);
    }

    public void searchLocation(String searchString) throws InterruptedException {

        By input = By.id("zipOrCityState");
        By LookupButton =  By.xpath("//*[@data-test='storeLocationSearch-button']");
        click(locationMenu);
        Thread.sleep(1000);
        sendKeys(input, searchString);
        Thread.sleep(1000);
        click(LookupButton);
        Thread.sleep(1000);
    }

    public void useLocation() throws InterruptedException {
        By locationText =  By.xpath("//*[contains(@class,'h-padding-h-none')]");
        click(locationMenu);
        Thread.sleep(1000);
        click(locationText);
        Thread.sleep(1000);
    }
    public void resetMenu() {
        By locationMenu =  By.id("storeId-utilityNavBtn");
        click(locationMenu);
    }

    public void clickDetails() {
        By details = By.xpath("//*[@data-test='storeId-listItem-storeDetails']");
        click(details);
    }
    public void closeDetails() {
        By details = By.xpath("//*[@data-test='close-store-details']");
        click(details);
    }

    public void selectStore() {
        By confirmBtn = By.xpath("//*[@data-test='storeId-listItem-setStore']");
        click(confirmBtn);
    }
}
