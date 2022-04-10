package Target;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetDetailPage extends BaseTest{
    public TargetDetailPage TDP;
    public TargetSearchPage TSP;


    @BeforeMethod
    public void methodLevelSetUp()
    {
        TDP = new TargetDetailPage(driver);
        TSP = new TargetSearchPage(driver);
    }

    @Test
    public void testDisplayDetailItem() throws InterruptedException {
        TSP.searchItem("microphone");
        Assert.assertTrue(TDP.getDetailElement());
    }

    @Test
    public void testNotDetailFoundItem() throws InterruptedException {
        Assert.assertTrue(TDP.getNotFoundElement());
    }
}
