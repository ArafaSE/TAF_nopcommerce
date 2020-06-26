package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToCartTest extends TestBase {
    // test data
    String productSearchTxt = "Apple MacBook";
    // page objects
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;

    @Test(priority = 1)
    public void userCanSearchWithAutoSuggest() {
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(productSearchTxt);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productName.getText().contains(productSearchTxt));
    }

    @Test(priority = 2)
    public void userCanAddProductToShoppingCart() throws InterruptedException {
        shoppingCartObject = new ShoppingCartPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);

        productDetailsObject.addToCart();
        Thread.sleep(500);
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        Thread.sleep(1000);

        Assert.assertTrue(shoppingCartObject.subtotalLbl.getText().contains("$"));
    }

    @Test(priority = 3)
    public void userCanRemoveProductFromSHoppingCart(){
        shoppingCartObject = new ShoppingCartPage(driver);
        shoppingCartObject.removeProductFromCart();
        Assert.assertTrue(shoppingCartObject.noDataMsg.getText().contains("Your Shopping Cart is empty!"));
    }

}
