package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TargetDetailPage extends BasePage{

    TargetDetailPage(WebDriver driver){
        super(driver);
    }

    By items_Sold = By.className("styles__StyledTitleLink-sc-h3r0um-1");
    By H1_Title = By.className("Heading__StyledHeading-sc-1mp23s9-0");
    By Not_Found = By.className("styles__ProductNotFoundTitle-sc-1cgwp7u-1");

    public String FavoriteItem;

    public boolean getDetailElement() throws InterruptedException{
        Thread.sleep(10000);
        List<WebElement> lis = driver.findElements(items_Sold);
        WebElement element = lis.get(0);
        String detailName = element.getText();
        element.click();
        Thread.sleep(5000);
        List<WebElement> titles = driver.findElements(H1_Title);
        WebElement title = titles.get(0);
        FavoriteItem = detailName;
        Thread.sleep(5000);
        return title.getText().equalsIgnoreCase(detailName);
    }

    public void goToPage(String url){
        driver.navigate().to(url);
    }

    public boolean getNotFoundElement() throws InterruptedException{
        driver.navigate().to("https://www.target.com/p/singing-machine-wired-microphone/-/A-5384753#lnk=sametab");
        Thread.sleep(5000);
        WebElement title = driver.findElement(Not_Found);
        return title.getText().equalsIgnoreCase("product not available");
    }
}
