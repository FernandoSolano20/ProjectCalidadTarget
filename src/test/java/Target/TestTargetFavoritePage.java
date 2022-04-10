package Target;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetFavoritePage extends BaseTest{
    public TargetDetailPage TDP;
    public TargetSearchPage TSP;
    public TargetLoginPage TLP;
    public TargetFavoritePage TFP;
    public String SavedItem;

    @BeforeMethod
    public void methodLevelSetUp()
    {
        TDP = new TargetDetailPage(driver);
        TSP = new TargetSearchPage(driver);
        TLP = new TargetLoginPage(driver);
        TFP = new TargetFavoritePage(driver);
    }

    @Test
    public void testFavoriteSave() throws InterruptedException {
        TLP.login("jsolanom@ucenfotec.ac.cr", "testU123");
        TDP.goToPage("https://www.target.com/s?searchTerm=shampoo");
        TDP.getDetailElement();
        this.SavedItem = TDP.FavoriteItem;
        Assert.assertTrue(TFP.saveFavorite());
    }

    @Test
    public void testFavoriteSaveDisplay() throws InterruptedException {
        TDP.goToPage("https://www.target.com/yr/crush");
        Assert.assertTrue(TFP.showFavorite(SavedItem));
    }

    @Test
    public void testFavoriteSaveRemove() throws InterruptedException {
        TDP.goToPage("https://www.target.com/s?searchTerm=shampoo");
        TDP.getDetailElement();
        this.SavedItem = TDP.FavoriteItem;
        Assert.assertTrue(TFP.saveFavorite());
    }

    @Test
    public void testFavoriteSaveRemoveDisplay() throws InterruptedException {
        TDP.goToPage("https://www.target.com/yr/crush");
        Assert.assertTrue(TFP.noFavoritesSaved());
    }
}
