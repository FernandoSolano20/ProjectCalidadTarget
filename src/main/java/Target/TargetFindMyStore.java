package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TargetFindMyStore  extends BasePage{
    public TargetFindMyStore(WebDriver driver) {
        super(driver);
    }
    By makeItMyStoreButton = By.xpath("//*[@data-test='@store-locator/StoreCard/MakeItMyStoreBtn']");
    By filterButton = By.xpath("//*[@data-test='@store-locator/StoreLocatorPage/FilterByServicesBtn']");
    By allCheckboxes = By.xpath("//*[@aria-labelledby='results_heading']//label[@for]");
    By PharmacyButton = By.xpath("//*[@aria-labelledby='results_heading']//label[@for='CVS pharmacy']");

    public void clickAllFilters(){
        List<WebElement> list =  super.driver.findElements(allCheckboxes);

        for(WebElement el : list){
                el.click();
        }
    }

    public void filterStoreByAll() throws InterruptedException{
        click(filterButton);
        Thread.sleep(2000);
        clickAllFilters();
        Thread.sleep(1000);
        click(filterButton);
        Thread.sleep(1000);
    }
    public void filterStoreByPharmacy() throws InterruptedException{
        click(filterButton);
        Thread.sleep(1000);
        click(PharmacyButton);
        Thread.sleep(1000);
        click(filterButton);
        Thread.sleep(1000);
    }

    public void makeItMyStore() throws  InterruptedException {
        click(makeItMyStoreButton);
        Thread.sleep(1000);
    }

}
