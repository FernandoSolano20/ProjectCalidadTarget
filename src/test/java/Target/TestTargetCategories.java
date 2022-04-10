package Target;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class TestTargetCategories extends BaseTest{

    TargetCategories TC;
    @BeforeMethod
    public void methodLevelSetUp()
    {
        driver.get("https://www.target.com/c/jeans-men-s-clothing/-/N-5xu2b");
        TC = new TargetCategories(driver);
    }

    public int getCurrentResults() {
        String[] results = driver.findElement(By.xpath("//*[@data-test='numberOfSearchResults']")).getText().split(" ");
        return Integer.parseInt(results[0]);
    }


    @Test
    public void regressionDeliveryFilters() throws InterruptedException {
        String outOfStocks = "//*[@for='chk-fwtfr']";
        String pickup =  "//*[@for='checkboxOrderPickupFacet']";
        String sameDay = "//*[@for='Check me!']";
        String buyIt = "//*[@for='checkboxInStoreFacet']";
        String shipping = "//*[@for='checkboxShippingFacet']";
        By editButton = By.xpath("//*[@data-test='pickUpFiatsButton']");
        int originalResults = getCurrentResults();
        TC.clickFilter(outOfStocks);
        Assert.assertTrue(originalResults <= getCurrentResults());
        TC.clickFilter(outOfStocks);
        Assert.assertTrue(originalResults == getCurrentResults());
        TC.clickFilter(pickup);
        Assert.assertTrue(originalResults >= getCurrentResults());
        TC.clickFilter(sameDay);
        TC.clickFilter(shipping);
        TC.clickFilter(buyIt);
        Assert.assertTrue(originalResults >= getCurrentResults());
        List<WebElement> list= driver.findElements(editButton);
        Assert.assertTrue(!list.isEmpty());
    }
    @Test
    public void regressionClothesFilters() throws InterruptedException {
        String FitStraigth = "//*[@for='chk-dm592']";
        String Size28x30 =  "//*[@for='chk-54ytw']";
        String brands =  "//*[@for='chk-q4e5p']";

        int originalResults = getCurrentResults();
        TC.clickFilter(FitStraigth);
        Assert.assertTrue(originalResults >= getCurrentResults());
        TC.clickFilter(FitStraigth);
        Assert.assertTrue(originalResults == getCurrentResults());
        TC.clickFilter(Size28x30);
        Assert.assertTrue(originalResults >= getCurrentResults());

        TC.inputSize("2");
        Assert.assertTrue(TC.sizeResults().equals("2"));
        TC.inputSize("200");
        Assert.assertTrue(!TC.sizeResults().equals("200"));
        TC.clearResults();
        TC.clickFilter(brands);
        Assert.assertTrue(originalResults >= getCurrentResults());
        TC.clickFilter(brands);
        Assert.assertTrue(originalResults >= getCurrentResults());
    }

}
