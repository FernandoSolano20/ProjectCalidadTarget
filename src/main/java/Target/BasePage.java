package Target;

import org.openqa.selenium.*;

public class BasePage {

    WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;

        js = (JavascriptExecutor) driver;
    }

    public void click(By element)
    {
        driver.findElement(element).click();
    }

    public void scrollTo(By element) {
        WebElement el =  driver.findElement(element);
        js.executeScript("arguments[0].scrollIntoView()", el);
    }

    public void sendKeys(By element, String text)
    {
       WebElement input =  driver.findElement(element);
       input.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }
    public String getElementText(String xpath) {
        By element = By.xpath(xpath);
        return driver.findElement(element).getText();
    }
}
