package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithFakerDataTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    // fake data from gitHub Java Faker
    Faker fakeUser = new Faker();
    String fName = fakeUser.name().firstName();
    String lName = fakeUser.name().lastName();
    String email = fakeUser.internet().emailAddress();
    String password = fakeUser.number().digits(8).toString();

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully() {
        // pages instances
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        loginObject = new LoginPage(driver);
        // register
        homeObject.openRegistrationPage();
        registerObject.userRegistration(fName, lName, email, password);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
        // logout
        registerObject.userLogout();
        // login
        homeObject.openLoginPage();
        loginObject.userLogin(email, password);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
        // logout again
        registerObject.userLogout();

    }
}
