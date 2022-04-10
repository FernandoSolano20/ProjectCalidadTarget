package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TargetShoppingCart extends BasePage{
    public TargetShoppingCart(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart()throws InterruptedException {
        By item = By.xpath("//*[@data-test=\"product-card-default\"]");
        By addToCard = By.xpath("//*[@data-test='shipItButton']");
        By checkout = By.xpath("//*[@data-test='addToCartModalViewCartCheckout']");
        click(item);
        Thread.sleep(1000);
        click(addToCard);
        Thread.sleep(1000);
        click(checkout);
        Thread.sleep(2000);
    }

    public void deleteItemFromCart() throws InterruptedException{
        By cartMenu =  By.id("cart");
        By cartItemDeleteBtn = By.xpath("//*[@data-test='cartItem-deleteBtn']");
        click(cartMenu);
        Thread.sleep(1000);
        click(cartItemDeleteBtn);
        Thread.sleep(1000);
    }
}
