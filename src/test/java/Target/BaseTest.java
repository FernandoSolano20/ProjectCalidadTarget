package Target;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    public TargetHomePage GHP;

    @Parameters({"Browser", "URL"})
    @BeforeClass
    public void TestSetUp(String browser, String url)
    {
        switch(browser) {
            case ("Chrome"):
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("incognito");
                options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
                options.addArguments("--disable-blink-features=AutomationControlled");
                driver = new ChromeDriver(options);
                break;
            case ("Edge"):
                System.setProperty("webdriver.edge.driver","C:\\Users\\ExtremeTech\\IdeaProjects\\WebDriver_Basics\\msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }



    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
