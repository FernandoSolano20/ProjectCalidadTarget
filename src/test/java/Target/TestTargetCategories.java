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
        String[] results = driver.findElement(By.cssSelector("[data-test=\"resultsHeading\"]")).getText().split(" ");
        return Integer.parseInt(results[0]);
    }


    @Test
    public void regressionDeliveryFilters() throws InterruptedException  {
        By sameDay = By.cssSelector("[data-icon-name=\"FulfillmentSameDay\"]");
        By editButton = By.cssSelector("[data-test=\"@web/site-top-of-funnel/ProductCardWrapper\"]");
        int originalResults = getCurrentResults();
        TC.click(sameDay);
        Thread.sleep(3000);
        Assert.assertTrue(originalResults >= getCurrentResults());
        List<WebElement> list= driver.findElements(editButton);
        Assert.assertTrue(!list.isEmpty());
    }
    @Test
    public void regressionClothesFilters() throws InterruptedException {
        By FitStraigth = By.cssSelector(".styles__PillContainer-sc-1mpm9rk-0 [aria-label*=\"Fit\"]");
        By FitStraigthLabel = By.cssSelector("[for=\"chk-dm592\"]");
        By Size28x30 =  By.cssSelector(".styles__PillContainer-sc-1mpm9rk-0 [aria-label*=\"Size\"]");
        By Size28x30Label =  By.cssSelector("[for=\"chk-54ytw\"]");
        By brands =  By.cssSelector(".styles__PillContainer-sc-1mpm9rk-0 [aria-label*=\"Brand\"]");
        By brandsLabel =  By.cssSelector("[for=\"chk-q643lesi29d\"]");

        int originalResults = getCurrentResults();
        TC.clickFilter(FitStraigth, FitStraigthLabel);
        Assert.assertTrue(originalResults >= getCurrentResults());
        TC.clickFilter(FitStraigth, FitStraigthLabel);
        Assert.assertTrue(originalResults == getCurrentResults());
        TC.clickFilter(Size28x30, Size28x30Label);
        Assert.assertTrue(originalResults >= getCurrentResults());

        TC.clickFilter( Size28x30, null);
        TC.inputSize("2");
        Assert.assertTrue(TC.sizeResults().equals("2"));
        TC.inputSize("200");
        Assert.assertTrue(!TC.sizeResults().equals("200"));
        TC.clearResults();
        TC.clickFilter(brands, brandsLabel);
        Assert.assertTrue(originalResults >= getCurrentResults());
        TC.clickFilter(brands, brandsLabel);
        Assert.assertTrue(originalResults >= getCurrentResults());
    }

}
