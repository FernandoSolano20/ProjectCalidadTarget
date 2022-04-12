package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TargetMenuNav extends BasePage{
    public TargetMenuNav(WebDriver driver) {
        super(driver);
    }



    public void clickMenuItem(String idMenu, String subMenuId) throws InterruptedException {
        click(By.cssSelector(idMenu));
        Thread.sleep(1000);
        click(By.cssSelector(subMenuId));
        Thread.sleep(1000);
    }


    public void clickMenuItemWhatsNew(String idMenu, int index) throws InterruptedException {
        click(By.cssSelector(idMenu));
        Thread.sleep(1000);
        List<WebElement> list = super.driver.findElements(By.cssSelector(".Link__StyledLink-sc-4b9qcv-0.styles__StyledLink-sc-4iwr7b-0"));
        list.get(index).click();
        Thread.sleep(3000);
    }

}
