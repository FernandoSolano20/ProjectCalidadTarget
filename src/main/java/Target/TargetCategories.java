package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TargetCategories extends BasePage{

    public TargetCategories(WebDriver driver) {
        super(driver);
    }

    public void clickFilter(By selectorFilter, By selectorOption) throws InterruptedException {
        scrollTo(By.cssSelector("[data-component-id=\"WEB-c_web_dvm_v01\"]"));
        Thread.sleep(3000);
        click(selectorFilter);
        Thread.sleep(1000);
        if (selectorOption != null) {
            click(selectorOption);
            click(By.cssSelector("[aria-label=\"Update\"]"));
            Thread.sleep(1000);
        }
    }

    public void inputSize(String size) throws InterruptedException {
        By Input_Size = By.id("facetSearch-Size");
        sendKeys(Input_Size, size);
        Thread.sleep(1000);
    }

    public void clearResults() throws InterruptedException  {
        String Clear = "[aria-label=\"Reset\"]";
        click(By.cssSelector(Clear));
        Thread.sleep(3000);
    }

    public String sizeResults()  {
        try {
            return getElementText(By.cssSelector("[for=\"chk-56678\"] b"));
        }
        catch (Exception exc ) {
            return "";
        }

    }

}
