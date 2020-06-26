package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductReviewTest extends TestBase {
    /*
       1. User registration
       2. Search for product
       3. Add review
       4. logout
     */
    // page objects
    HomePage homeObject;
    UserRegistrationPage registerObject;
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ProductReviewPage productReviewObject;

    // test Date
    String productSearchTxt = "Apple";

    String fName = "Mohamed";
    String lName = "Arafa";
    String email = "arafa400@gmail.com";
    String pass = "AR123456";

    String reviewTitle = "The product is very good";
    String reviewBody = "Clear sound, high quality and low price";
    // 1- user registration
    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(fName, lName, email, pass);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
    }

    // 2. search for product
    @Test(priority = 2)
    public void userCanSearchWithAutoSuggest() {
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(productSearchTxt);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productName.getText().contains(productSearchTxt));
    }

    // 3.Add review
    @Test(priority = 3, dependsOnMethods = "userCanRegisterSuccessfully")
    public void registeredUserCanReviewProduct() {
        productDetailsObject.openAddReviewLink();
        productReviewObject = new ProductReviewPage(driver);
        productReviewObject.addProductReview(reviewTitle, reviewBody);
        Assert.assertTrue(productReviewObject.reviewNotification.getText()
                .contains("Product review is successfully added."));
    }

    // 4. user log out
    @Test(priority = 4, dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void registeredUserCanLogout() {
        registerObject.userLogout();
    }
}
