package Target;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFindMyStore extends BaseTest{
    TargetFindMyStore TFMS;
    @BeforeMethod
    public void methodLevelSetUp()
    {
        driver.get("https://www.target.com/store-locator/find-stores");
        TFMS = new TargetFindMyStore(driver);
    }


    @Test
    public void smokeTestFilterStore() throws InterruptedException{
        TFMS.filterStoreByAll();
        By errorBox = By.xpath("//*[@class='h-text-center']//h2");
        String errorMessage = driver.findElement(errorBox).getText();
        Assert.assertEquals(errorMessage, "Sorry, no stores matched your search.");
        TFMS.filterStoreByAll();
        TFMS.filterStoreByPharmacy();
        TFMS.makeItMyStore();
        By activeStore = By.xpath("//*[@data-test='@web/StoreMessage/StoreName']");
        String activeStoreStr = driver.findElement(activeStore).getText();
        Assert.assertEquals(activeStoreStr, "Minneapolis NE");

    }

}
