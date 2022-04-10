package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TargetUserAddress extends BasePage{
    public TargetUserAddress(WebDriver driver) {
        super(driver);
    }
    By addNewAddress = By.xpath("//*[@data-test='address-add-new']");
    By firstNameInput = By.id("first_name");
    By lastNameInput = By.id("last_name");
    By address1Input = By.id("address_line1");
    By zipCodeInput = By.id("zip_code");
    By cityInput = By.id("city");
    By selectState = By.id("state");
    By phoneInput = By.id("phone_number");
    By addressCheckbox = By.id("default_address");
    By saveButton = By.xpath("//*[@type='submit']");
    By saveAddress = By.xpath("//*[@type='button']");
    By textBox = By.xpath("//*[@data-test='address-card']");


    public String createNewAddress(String firstname, String lastname, String address1, String zipcode, String city, String state, String phone)throws InterruptedException {

        click(addNewAddress);
        fillForm(firstname, lastname,address1,zipcode,city,state,phone);
        return super.driver.findElement(textBox).getText();

    }

    private void acceptAddress() {

    }

    private void fillForm(String firstname, String lastname, String address1, String zipcode, String city, String state, String phone)throws InterruptedException {
        Select states = new Select(driver.findElement(selectState));
        sendKeys(firstNameInput, firstname);
        sendKeys(lastNameInput, lastname);
        sendKeys(address1Input, address1);
        sendKeys(zipCodeInput, zipcode);
        sendKeys(cityInput, city);
        states.selectByVisibleText(state);
        sendKeys(phoneInput, phone);
        super.driver.findElements(saveButton).get(1).click();
        Thread.sleep(5000);
        super.driver.findElements(saveAddress).get(11).click();
        Thread.sleep(5000);
    }


}
