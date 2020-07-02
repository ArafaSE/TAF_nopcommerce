package steps;

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


    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
    }

    @When("I click on register link")
    public void i_click_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @And("I entered {string}, {string}, {string}, {string}")
    public void iEntered(String firstName, String lastName, String email, String password) {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName, lastName, email, password);

        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
    }

    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        registerObject.userLogout();
    }


}
