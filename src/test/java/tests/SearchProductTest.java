package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;

    @Test
    public void userCanSearchForProducts(){
        searchObject = new SearchPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        Assert.assertTrue(productDetailsObject.productName.getText().equalsIgnoreCase(productName));
    }
}
