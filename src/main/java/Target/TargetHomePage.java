package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TargetHomePage extends BasePage{

    private WebDriver driver;

    By Logo = By.cssSelector(".Link__StyledLink-sc-4b9qcv-0.styles__LogoLinkDesktop-sc-17dxxwu-2.gCNFxQ.llakbT");
    By input = By.id("zip-or-city-state");
    By locationMenu =  By.id("web-store-id-msg-btn");

    TargetHomePage(WebDriver driver){
        super(driver);
    }

    public void clickMenuLogo() throws InterruptedException
    {
        click(Logo);
        Thread.sleep(1500);
    }

    public void searchLocation(String searchString) throws InterruptedException {
        By LookupButton =  By.cssSelector("[data-test=\"@web/StoreLocationSearch/button\"]");
        click(locationMenu);
        Thread.sleep(1000);
        sendKeys(input, searchString);
        Thread.sleep(1000);
        click(LookupButton);
        Thread.sleep(1000);
    }

    public void useLocation() throws InterruptedException {
        By locationText =  By.cssSelector("[data-test=\"@web/GeolocationButton/Button\"]");
        click(locationMenu);
        Thread.sleep(1000);
        click(locationText);
        Thread.sleep(1000);
    }

    public void clickDetails() {
        By details = By.cssSelector("[data-test=\"@web/StoreIdListItem/ViewStoreDetailsButton\"]");
        click(details);
    }
    public void closeDetails() {
        By details = By.cssSelector("[data-test=\"@web/StoreDetails/CloseLink\"]");
        click(details);
    }

    public void selectStore() {
        By confirmBtn = By.cssSelector("[data-test=\"@web/StoreSearchBlockContainer/StoresList-1908\"] [data-test=\"@web/StoreIdListItem/SetStoreButton\"]");
        click(confirmBtn);
    }
}
