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
        String menu= "secondary";
        String clearance = "deals-clearance";
        String weeklyAd = "deals-weeklyAd";
        String topDeals = "deals-topDeals";
        String redCardE = "deals-redcardExclusives";
        String targetCircle = "deals-cartwheel";

        TMN.clickMenuItem(menu, clearance);
        Assert.assertTrue(driver.getCurrentUrl().contains("clearance"));
        TMN.clickMenuItem(menu, topDeals);
        Assert.assertTrue(driver.getCurrentUrl().contains("top-deals"));
        TMN.clickMenuItem(menu, redCardE);
        Assert.assertTrue(driver.getCurrentUrl().contains("redcard"));
        TMN.clickMenuItem(menu, targetCircle);
        Assert.assertTrue(driver.getCurrentUrl().contains("offers"));
        TMN.clickMenuItem(menu, weeklyAd);
        Assert.assertTrue(driver.getCurrentUrl().contains("weeklyad"));
        driver.get("https://www.target.com/");
    }
    @Test
    public void regressionWhatsNewNav() throws InterruptedException  {
        String menu= "trending";

        int targetStyle = 0;
        int womenArrivals = 1;
        int beautyArrivals = 2;
        int kidsArrivals = 3;
        int menArrivals = 4;
        int homeArrivals = 5;
        int womensEmpowerment = 6;
        int finds = 7;

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
        TMN.clickMenuItemWhatsNew(menu, womensEmpowerment);
        Assert.assertTrue(driver.getCurrentUrl().contains("WHM_GDD"));
        driver.get("https://www.target.com/");
        TMN.clickMenuItemWhatsNew(menu, finds);
        Assert.assertTrue(driver.getCurrentUrl().contains("TF_GDD"));
        driver.get("https://www.target.com/");
        TMN.clickMenuItemWhatsNew(menu, targetStyle);
        Assert.assertTrue(driver.getCurrentUrl().contains("targetstyle"));
    }

}
