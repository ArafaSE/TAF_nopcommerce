package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
    HomePage homePageObject;
    ContactUsPage contactUsPageObject;

    String email = "arafa17@gmail.com";
    String fullName = "Mohamed Ahmed";
    String message = "Hello Admin, This is for test";

    @Test
    public void userCanContactUs(){
        homePageObject = new HomePage(driver);
        homePageObject.openContactUsPage();
        contactUsPageObject = new ContactUsPage(driver);
        contactUsPageObject.contactUs(fullName, email, message);
        Assert.assertTrue(contactUsPageObject.successMsg.getText().contains("Your enquiry has been successfully"));
    }

}
