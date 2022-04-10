package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TargetFavoritePage extends BasePage{

    TargetFavoritePage(WebDriver driver){
        super(driver);
    }

    By FavoriteBtn = By.xpath("//button[@data-test='crushButton']");
    By FavoriteSave = By.xpath("//a[@data-test='product-title']");
    By FavoriteTxt = By.className("Heading__StyledHeading-sc-1mp23s9-0");

    public boolean saveFavorite()throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(FavoriteBtn).click();
        return true;
    }

    public boolean showFavorite(String savedItem)throws InterruptedException {
        Thread.sleep(10000);
        String favoriteSave = driver.findElement(FavoriteSave).getText();
        return favoriteSave.equalsIgnoreCase(savedItem);
    }

    public boolean noFavoritesSaved()throws InterruptedException {
        Thread.sleep(8000);
        String favorites = driver.findElements(FavoriteTxt).get(2).getText();
        return favorites.equalsIgnoreCase("Show some love!");
    }

}
