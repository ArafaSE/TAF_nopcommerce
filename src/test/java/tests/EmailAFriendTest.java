package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailAFriendTest extends TestBase {
    // 1- user registration
    HomePage homeObject;
    UserRegistrationPage registerObject;
    String productSearchTxt = "Apple";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    EmailAFriendPage emailAFriendObject;

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("Ahmed", "Arafa", "arafa16@gmail.com", "AR123456");
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
    // 3. Email to a friend
    @Test(priority = 3)
    public void registeredUserCanSendProductToAFriend(){
        productDetailsObject.openSendEmailPage();
        emailAFriendObject = new EmailAFriendPage(driver);
        emailAFriendObject.sendEmailToAFriend("shady@gmail.com", "Hello Shady");
        Assert.assertTrue(emailAFriendObject.successMsg.getText().contains("Your message has been sent"));
    }
    // 4. user log out
    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"}, priority = 4)
    public void registeredUserCanLogout(){
        registerObject.userLogout();
    }
}
