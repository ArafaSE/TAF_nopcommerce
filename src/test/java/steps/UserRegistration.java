package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;


public class UserRegistration extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registerObject;

    // fake data from gitHub Java Faker
    Faker fakeUser = new Faker();
    String fName = fakeUser.name().firstName();
    String lName = fakeUser.name().lastName();
    String email = fakeUser.internet().emailAddress();
    String password = fakeUser.number().digits(8).toString();

    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
    }

    @When("I click on register link")
    public void i_click_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @And("I entered user data")
    public void iEnteredUserData() {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(fName, lName, email, password);

        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
    }

    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        registerObject.userLogout();
    }


}
