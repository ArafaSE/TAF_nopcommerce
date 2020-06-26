package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @DataProvider(name = "loginData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Mohamed", "Arafa", "arafa2222@gmail.com", "AR27383"},
                {"Ahmed", "Rami", "rami7765@gmail.com", "RM01134"}
        };
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "loginData")
    public void userCanRegisterSuccessfully(String fName, String lName, String email, String password) {
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

    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"}, enabled = false)
    public void registeredUserCanLogout() {
        registerObject.userLogout();
    }

    @Test(dependsOnMethods = {"registeredUserCanLogout"}, enabled = false)
    public void registeredUserCanLogin() {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin("arafa17@gmail.com", "AR123456");
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }
}
