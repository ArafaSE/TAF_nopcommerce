package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDTAndPropertiesFileTest extends TestBase {
    // page objects
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    // load user Data Properties
    String fName = LoadProperties.userDate.getProperty("firstName");
    String lName = LoadProperties.userDate.getProperty("lastName");
    String email = LoadProperties.userDate.getProperty("email");
    String password = LoadProperties.userDate.getProperty("password");

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(fName, lName, email, password);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
        // logout
        registerObject.userLogout();
        // login again
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, password);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
        // logout again
        registerObject.userLogout();
    }
}
