package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckoutProductFromCartTest extends TestBase {
	SearchPage searchObject;
	HomePage homeObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest(productName);
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productName.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		productDetailsObject.addToCart();
		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.subtotalLbl.getText().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct("test", "user", "Egypt"
				, "testuser1@test.com", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
	}

	@Test(priority=4)
	public void UserCanViewOrderDetails() throws InterruptedException {
		orderObject = new OrderDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();
	}

}
