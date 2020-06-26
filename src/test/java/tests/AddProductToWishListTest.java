package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
    /* page objects */
    WishListPage wishListObject;
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
     /*  test data */
    String productSearchTxt = "Apple MacBook Pro";
    String wishListEmptyMessage = "The wishlist is empty!";
    // 1. user can search for product
    @Test(priority = 1)
    public void userCanSearchWithAutoSuggest() {
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(productSearchTxt);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productName.getText().contains(productSearchTxt));
    }
    // 2. user can add product to wishList
    @Test(priority = 2)
    public void userCanProductToWishList(){
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addProductToWishList();
        driver.navigate().to("https://demo.nopcommerce.com/wishlist");
        wishListObject = new WishListPage(driver);
        Assert.assertTrue(wishListObject.productCell.getText().contains(productSearchTxt));
    }
    // 3. user can remove product from wishList
    @Test(dependsOnMethods = "userCanProductToWishList")
    public void userCanRemoveProductFromWishList(){
        wishListObject.removeProductFromWishList();
        Assert.assertTrue(wishListObject.emptyWishListLbl.getText().contains(wishListEmptyMessage));
    }
}
