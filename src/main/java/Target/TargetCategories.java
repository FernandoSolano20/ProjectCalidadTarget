package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TargetCategories extends BasePage{

    public TargetCategories(WebDriver driver) {
        super(driver);
    }

    public void clickFilter(String xpath) throws InterruptedException {
        scrollTo(By.xpath(xpath));
        Thread.sleep(1000);
        click(By.xpath(xpath));
        Thread.sleep(1000);
    }

    public void inputSize(String size) throws InterruptedException {
        By Input_Size = By.id("facetSearch-Size");
        sendKeys(Input_Size, size);
        Thread.sleep(1000);
    }

    public void clearResults() throws InterruptedException  {
        Thread.sleep(1000);
        String Clear = "//*[@data-test='facetSearchClearBtn']";
        click(By.xpath(Clear));
    }

    public String sizeResults()  {
        try {
            return getElementText("//label[@class='h-display-block h-position-relative h-padding-a-tiny']//b"); }
        catch (Exception exc ) {
            return "";
        }

    }

}
