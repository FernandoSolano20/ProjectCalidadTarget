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

    public void logoNavTest() throws InterruptedException
    {
        driver.get("https://www.target.com/c/jeans-women-s-clothing/-/N-5xtc8");
        Thread.sleep(1500);
        THP.clickMenuLogo();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.target.com/");
    }

    public void logoNavTestOnHome() throws InterruptedException
    {
        String baseUrl = "https://www.target.com/";
        THP.clickMenuLogo();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, baseUrl);
    }

    public void invalidZipCode() throws InterruptedException
    {
        THP.searchLocation("00000000000");
        By errorBox = By.id("zip-or-city-state--ErrorMessage");
        String errorMessage = driver.findElement(errorBox).getText();
        Assert.assertEquals(errorMessage.toLowerCase(), "please enter a valid location");
    }
    public void searchLocationByValidZip() throws InterruptedException
    {
        By item = By.cssSelector("[data-test=\"@web/StoreSearchBlockContainer/StoresList-2083\"] h4");
        THP.searchLocation("85364");
        String itemTitle = driver.findElement(item).getText();
        Assert.assertEquals(itemTitle.toLowerCase(), "yuma");
    }

    public void regressionSearchStores()  throws InterruptedException {
        By selectedStore = By.cssSelector("[data-test=\"@web/StoreMessage/StoreName\"] .styles__StyledMessage-sc-1ghv6mc-5");
        String firstStore;
        //By ZipCode
        THP.searchLocation("60191");
        firstStore = getElementText("//*[@data-test='@web/StoreSearchBlockContainer/StoresList-893']", "h4");
        Assert.assertEquals(firstStore, "Wood Dale");
        By close =  By.className("styles__IconButtonStyles-sc-1ymnlhk-0");
        THP.click(close);

        //By State
        THP.searchLocation("Austin, Texas");
        firstStore = getElementText("//*[@data-test='@web/StoreSearchBlockContainer/StoresList-1908']", "h4");
        Assert.assertEquals(firstStore, "Katy Cinco Ranch");

        //CheckDetails
        THP.clickDetails();
        Thread.sleep(500);
        By hours = By.cssSelector("[data-test=\"@web/StoreDetails/Hours\"]");
        List<WebElement> details = driver.findElements(hours);
        Assert.assertTrue(!details.isEmpty());
        THP.closeDetails();
        Thread.sleep(500);
        THP.selectStore();
        firstStore = driver.findElement(selectedStore).getText();
        Assert.assertEquals(firstStore, "Katy Cinco Ranch");

    }

    @Test
    public void regressionUseLocation()  throws InterruptedException {
        By errorMessage = By.cssSelector(".h-text-orangeDark");
        THP.useLocation();
        String message = driver.findElement(errorMessage).getText();
        Assert.assertTrue(message.contains("We are unable to retrieve your location. Please try again later."));

    }




}
