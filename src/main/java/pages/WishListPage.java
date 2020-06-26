package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td.product")
    public WebElement productCell;

    @FindBy(name = "updatecart")
    WebElement updateWishListBtn;

    @FindBy(name = "removefromcart")
    WebElement removeFromWishListCheck;

    @FindBy(css = "div.no-data")
    public WebElement emptyWishListLbl;

    public void removeProductFromWishList(){
        clickButton(removeFromWishListCheck);
        clickButton(updateWishListBtn);
    }
}
