package Target;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetMenuNav extends BaseTest{

    TargetMenuNav TMN;
    @BeforeMethod
    public void methodLevelSetUp()
    {
        driver.get("https://www.target.com/");
        TMN = new TargetMenuNav(driver);
    }


    @Test
    public void regressionDealsNav() throws InterruptedException  {
        String menu= "[aria-label=\"Deals\"]";
        String clearance = "[data-test=\"deals-clearance\"]";
        String weeklyAd = "[data-test=\"deals-weeklyAd\"]";
        String topDeals = "[data-test=\"deals-topDeals\"]";
        String targetCircle = "[data-test=\"deals-cartwheel\"]";

        TMN.clickMenuItem(menu, clearance);
        Assert.assertTrue(driver.getCurrentUrl().contains("clearance"));
        TMN.clickMenuItem(menu, topDeals);
        Assert.assertTrue(driver.getCurrentUrl().contains("top-deals"));
        TMN.clickMenuItem(menu, targetCircle);
        Assert.assertTrue(driver.getCurrentUrl().contains("offers"));
        TMN.clickMenuItem(menu, weeklyAd);
        Assert.assertTrue(driver.getCurrentUrl().contains("weeklyad"));
        driver.get("https://www.target.com/");
    }
    @Test
    public void regressionWhatsNewNav() throws InterruptedException  {
        String menu= "[aria-label=\"What’s New\"]";

        int exploreWhatIsNew = 0;
        int targetStyle = 1;
        int womenArrivals = 2;
        int beautyArrivals = 3;
        int kidsArrivals = 4;
        int menArrivals = 5;
        int homeArrivals = 6;
        int finds = 7;

        TMN.clickMenuItemWhatsNew(menu, exploreWhatIsNew);
        Assert.assertTrue(driver.getCurrentUrl().contains("what-s-new"));
        TMN.clickMenuItemWhatsNew(menu, womenArrivals);
        Assert.assertTrue(driver.getCurrentUrl().contains("WC_GDD"));
        TMN.clickMenuItemWhatsNew(menu, kidsArrivals);
        Assert.assertTrue(driver.getCurrentUrl().contains("KNA_GDD"));
        TMN.clickMenuItemWhatsNew(menu, menArrivals);
        Assert.assertTrue(driver.getCurrentUrl().contains("men"));
        TMN.clickMenuItemWhatsNew(menu, beautyArrivals);
        Assert.assertTrue(driver.getCurrentUrl().contains("beauty"));

        TMN.clickMenuItemWhatsNew(menu, homeArrivals);
        Assert.assertTrue(driver.getCurrentUrl().contains("home"));

        driver.get("https://www.target.com/");
        TMN.clickMenuItemWhatsNew(menu, finds);
        Assert.assertTrue(driver.getCurrentUrl().contains("TF_GDD"));
        driver.get("https://www.target.com/");
        TMN.clickMenuItemWhatsNew(menu, targetStyle);
        Assert.assertTrue(driver.getCurrentUrl().contains("targetstyle"));
    }

}
