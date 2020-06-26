package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
    HomePage homeObject;
    String productSearchTxt = "Apple";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    // 1. change currency
    @Test
    public void userCanChangeCurrency(){
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();
    }
    // 2. search for product and open his details page then assert currency was changed
    @Test
    public void userCanSearchWithAutoSuggest() {
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(productSearchTxt);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productPriceLabel.getText().contains("Ђ"));
        System.out.println(productDetailsObject.productPriceLabel.getText());
    }

}
