package Target;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetSearchPage  extends BaseTest{
    public TargetSearchPage TSP;

    @BeforeMethod
    public void methodLevelSetUp(){ TSP = new TargetSearchPage(driver); }

    @Test
    public void testCategoryNotFound() throws InterruptedException {
        Assert.assertTrue(TSP.notCategoryFound("not a category"));
    }

    @Test
    public void testDisplayCategory() throws InterruptedException {
        Assert.assertTrue(TSP.displayCategories("electronics"));
    }

    @Test
    public void testSearchCategory() throws InterruptedException {
        Assert.assertTrue(TSP.searchCategories("electronics"));
    }

    @Test
    public void testSearchItem() throws InterruptedException {
        Assert.assertTrue(TSP.searchItem("Beats Studio Buds True Wireless Noise Cancelling Bluetooth Earbuds"));
    }

    @Test
    public void testSupportTypoItem() throws InterruptedException {
        Assert.assertTrue(TSP.supportTypos("hedset"));
    }
}
