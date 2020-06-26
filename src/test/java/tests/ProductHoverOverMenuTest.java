package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductHoverOverMenuTest extends TestBase{
    HomePage homeObject;

    @Test
    public void userCanSelectWithHoerOverMenu(){
        homeObject = new HomePage(driver);
        homeObject.selectNotebooksMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
