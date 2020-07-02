package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "removefromcart")
    WebElement removeFromCartCheck;

    @FindBy(name = "updatecart")
    WebElement updateCartBtn;

    @FindBy(css = "input.qty-input")
    public WebElement quantityTxt;

    @FindBy(css = "span.product-subtotal")
    public WebElement subtotalLbl;

    @FindBy(css = "div.no-data")
    public WebElement noDataMsg;

    @FindBy(id="checkout")
    WebElement checkoutBtn ;

    @FindBy(id="termsofservice")
    WebElement agreeCheckbox;

    @FindBy(css="input.button-1.checkout-as-guest-button")
    WebElement guestCheckoutBtn ;

    public void removeProductFromCart(){
        clickButton(removeFromCartCheck);
        clickButton(updateCartBtn);
    }

    public void updateProductQuantityInCart(String quantity){
        // clear quantity text value
        clearText(quantityTxt);
        setTextElement(quantityTxt, quantity);
        clickButton(updateCartBtn);
    }

    public void openCheckoutPage()
    {
        clickButton(agreeCheckbox);
        clickButton(checkoutBtn);
    }

    public void openCheckoutPageAsGuest()
    {
        clickButton(agreeCheckbox);
        clickButton(checkoutBtn);
        clickButton(guestCheckoutBtn);
    }

}
