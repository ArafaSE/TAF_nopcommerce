package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-name")
    public WebElement productName;

    @FindBy(className = "email-a-friend-button")
    WebElement emailFriendBtn;

    @FindBy(css = "span.price-value-4.price-value-4")
    public WebElement productPriceLabel;

    @FindBy(linkText = "Add your review")
    public WebElement addReviewLink;

    @FindBy(id = "add-to-wishlist-button-4")
    public WebElement addToWishListBtn;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;

    public void openSendEmailPage(){
        clickButton(emailFriendBtn);
    }

    public void openAddReviewLink(){
        clickButton(addReviewLink);
    }

    public void addProductToWishList(){
        clickButton(addToWishListBtn);
    }

    public void addToCart(){
        clickButton(addToCartBtn);
    }

}
