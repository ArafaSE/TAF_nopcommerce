package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import tests.TestBase;

public class End2EndTests extends TestBase {
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage cartPageObject;
    CheckoutPage checkoutPageObject;
    OrderDetailsPage orderObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Given("user is on Home Page")
    public void userIsOnHomePage() {
        Assert.assertEquals(homeUrl, driver.getCurrentUrl());
    }

    @When("he search for {string}")
    public void heSearchFor(String productName) {
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(productName);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productName.getText().contains(productName));
    }

    @And("choose to buy two items")
    public void chooseToBuyTwoItems() {
        cartPageObject = new ShoppingCartPage(driver);
        productDetailsObject.addToCart();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().to(homeUrl + "cart");
    }

    @And("move to checkout cart and enter personal details on checkout page and place the order")
    public void moveToCheckoutCartAndEnterPersonalDetailsOnCheckoutPageAndPlaceTheOrder() throws InterruptedException {
        checkoutPageObject = new CheckoutPage(driver);
        cartPageObject.openCheckoutPageAsGuest();
        checkoutPageObject.CheckoutProduct("test", "user", "Egypt"
                , "testuser1@test.com", "test address", "123456", "32445566677", "Cairo", productName);
        Assert.assertTrue(checkoutPageObject.prodcutName.isDisplayed());
        Assert.assertTrue(checkoutPageObject.prodcutName.getText().contains(productName));
        checkoutPageObject.confirmOrder();
        Assert.assertTrue(checkoutPageObject.ThankYoulbl.isDisplayed());
    }

    @Then("he can view the order and download the invoice")
    public void heCanViewTheOrderAndDownloadTheInvoice() throws InterruptedException {
        orderObject = new OrderDetailsPage(driver);
        checkoutPageObject.viewOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        /*
        orderObject.DownloadPDFInvoice();
        Thread.sleep(3000);
        orderObject.PrintOrderDetails();*/
    }

}
