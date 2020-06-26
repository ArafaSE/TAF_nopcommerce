package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxt;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewBodyTxt;

    @FindBy(id = "addproductrating_4")
    WebElement rating_4_radioBtn;

    @FindBy(name = "add-review")
    WebElement submitReviewBtn;

    @FindBy(css = "div.result")
    public WebElement reviewNotification;

    public void addProductReview(String title, String reviewBody){
        setTextElement(reviewTitleTxt, title);
        setTextElement(reviewBodyTxt, reviewBody);
        clickButton(rating_4_radioBtn);
        clickButton(submitReviewBtn);
    }
}
