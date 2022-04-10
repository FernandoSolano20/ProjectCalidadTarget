package Target;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Locale;

public class TestTargetPage extends BaseTest{
    public TargetHomePage THP;
    By errorBox = By.xpath("//*[@data-test='storeIdSearch-error']//h2");

    @BeforeMethod
    public void methodLevelSetUp()
    {
        THP = new TargetHomePage(driver);
    }

    @AfterMethod
    public void resetTest() {
        String baseUrl = "https://www.target.com/";
        driver.get(baseUrl);
    }

    private String getElementText(String xpath, String header) {
        String template = String.format("%s//%s", xpath, header);
        By element = By.xpath(template);
        return driver.findElement(element).getText();
    }

    @Test
    public void logoNavTest() throws InterruptedException
    {
        driver.get("https://www.target.com/c/jeans-women-s-clothing/-/N-5xtc8");
        Thread.sleep(1500);
        THP.clickMenuLogo();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.target.com/");
    }

    @Test
    public void logoNavTestOnHome() throws InterruptedException
    {
        String baseUrl = "https://www.target.com/";
        THP.clickMenuLogo();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, baseUrl);
    }

    @Test
    public void invalidZipCode() throws InterruptedException
    {
        THP.searchLocation("00000000000");
        By errorBox = By.xpath("//*[@data-test='storeIdSearch-error']//h2");
        String errorMessage = driver.findElement(errorBox).getText();
        Assert.assertEquals(errorMessage.toLowerCase(), "sorry, something went wrong.");
    }
    @Test
    public void searchLocationByValidZip() throws InterruptedException
    {
        By item = By.xpath("//*[@data-test='storeIdSearch-item-2083']//h3");
        THP.searchLocation("85364");
        String itemTitle = driver.findElement(item).getText();
        Assert.assertEquals(itemTitle.toLowerCase(), "yuma");
    }

    @Test
    public void regressionSearchStores()  throws InterruptedException {
        By selectedStore = By.xpath("//*[@data-test='storeId-store-name']");
        String firstStore;
        //By ZipCode
        THP.searchLocation("60191");
        firstStore = getElementText("//*[@data-test='storeIdSearch-item-893']", "h3");
        Assert.assertEquals(firstStore, "Wood Dale");
        THP.resetMenu();
        //By State
        THP.searchLocation("New York");
        firstStore = getElementText("//*[@data-test='storeIdSearch-item-3229']", "h3");
        Assert.assertEquals(firstStore, "Tribeca");
        THP.resetMenu();
        //By city
        THP.searchLocation("Albany");
        firstStore = getElementText("//*[@data-test='storeIdSearch-item-1796']", "h3");
        Assert.assertEquals(firstStore, "East Greenbush");
        //CheckDetails
        THP.clickDetails();
        Thread.sleep(500);
        By hours = By.xpath("//*[@data-test='chooseStoreModal-storeDetails-storeInformationDayHours']");
        List<WebElement> details = driver.findElements(hours);
        Assert.assertTrue(!details.isEmpty());
        THP.closeDetails();
        Thread.sleep(500);
        THP.selectStore();
        firstStore = driver.findElement(selectedStore).getText();
        Assert.assertEquals(firstStore, "East Greenbush");

    }

    @Test
    public void regressionUseLocation()  throws InterruptedException {
        By errorMessage = By.xpath("//*[contains(@class,'h-text-orangeDark')]");
        THP.useLocation();
        String message = driver.findElement(errorMessage).getText();
        Assert.assertTrue(message.contains("Could not find your location."));

    }




}
