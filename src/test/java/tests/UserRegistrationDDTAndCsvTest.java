package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import data.DataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationDDTAndCsvTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    CSVReader reader; // reader from opnCSV library

    @DataProvider(name = "usersData")
    public static Object[][] userRegistrationData() throws IOException, CsvException {
        // get data from CSV file reader class
        DataReader ER = new DataReader();

        return ER.getCSVData();
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "usersData")
    public void userCanRegisterSuccessfully(String fName, String lName, String email, String password) {

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
