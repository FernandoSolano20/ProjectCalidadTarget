package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TargetShoppingCart extends BasePage{
    public TargetShoppingCart(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart()throws InterruptedException {
        By item = By.cssSelector("[data-test=\"@web/ProductCard/body\"]");
        By addToCard = By.id("addToCartButtonOrTextIdFor54566851");
        By checkout = By.cssSelector("[href=\"/cart\"]");
        click(item);
        Thread.sleep(1000);
        click(addToCard);
        Thread.sleep(1000);
        click(checkout);
        Thread.sleep(2000);
    }

    public void deleteItemFromCart() throws InterruptedException{
        By cartMenu =  By.cssSelector("[data-test=\"@web/CartLink\"]");
        By cartItemDeleteBtn = By.xpath("//*[@data-test='cartItem-deleteBtn']");
        click(cartMenu);
        Thread.sleep(1000);
        click(cartItemDeleteBtn);
        Thread.sleep(1000);
    }
}
