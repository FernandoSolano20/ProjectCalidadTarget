package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class TargetSearchPage extends BasePage{

    TargetSearchPage(WebDriver driver){
        super(driver);
    }

    By Input_Search = By.id("search");
    By Result_Search = By.className("TypeaheadItemText");
    By H1_Title = By.className("Heading__StyledHeading-sc-1mp23s9-0");
    By items_Sold = By.className("styles__StyledTitleLink-sc-h3r0um-1");

    public boolean notCategoryFound(String category) throws InterruptedException{
        sendKeys(Input_Search, category);
        Thread.sleep(500);
        List<WebElement> lis = driver.findElements(Result_Search);
        WebElement element = lis.get(0);
        Thread.sleep(2500);
        return !element.getText().contains(category);
    }

    public boolean displayCategories(String category) throws InterruptedException{
        this.cleanInput();
        Thread.sleep(2000);
        sendKeys(Input_Search, category);
        Thread.sleep(8000);
        List<WebElement> lis = driver.findElements(Result_Search);
        WebElement li = lis.get(0);
        return li.getText().contains(category);
    }

    public boolean supportTypos(String item) throws InterruptedException{
        this.cleanInput();
        sendKeys(Input_Search, item);
        Thread.sleep(2000);
        driver.findElement(Input_Search).sendKeys(Keys.ENTER);
        Thread.sleep(8000);
        List<WebElement> lis = driver.findElements(items_Sold);
        return lis.get(0).getText().contains("Headset");
    }

    public boolean searchCategories(String category) throws InterruptedException{
        Thread.sleep(2500);
        return pressEnterBtn(category, H1_Title);
    }

    public boolean searchItem(String item) throws InterruptedException{
        this.cleanInput();
        sendKeys(Input_Search, item);
        Thread.sleep(500);
        return pressEnterBtn(item, items_Sold);
    }

    private boolean pressEnterBtn(String item, By items_sold) throws InterruptedException {
        driver.findElement(Input_Search).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        List<WebElement> lis = driver.findElements(items_sold);
        WebElement element = lis.get(0);
        return element.getText().toLowerCase(Locale.ROOT).equalsIgnoreCase(item);
    }

    private void cleanInput()throws InterruptedException{
        WebElement element = driver.findElement(Input_Search);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }
}
