package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
    // test Data
    String firstName = "Ahmed";
    String lastName = "Arafa";
    String email = "arafa1992@gmail.com";
    String oldPassword = "AR123456";
    String newPassword = "AR12345678";
    // page objects
    HomePage homeObject;
    UserRegistrationPage registerObject;
    MyAccountPage myAccountObject;
    LoginPage loginObject;

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName, lastName , email, oldPassword);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void registeredUserCanChangePassword(){
        myAccountObject = new MyAccountPage(driver);
        homeObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.resultLb1.getText().contains("Password was changed"));
    }

    @Test(dependsOnMethods = {"registeredUserCanChangePassword"})
    public void registeredUserCanLogout(){
        registerObject.userLogout();
    }

    @Test(dependsOnMethods = {"registeredUserCanLogout"})
    public void registeredUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        homeObject.openLoginPage();
        loginObject.userLogin(email, newPassword);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }

}
