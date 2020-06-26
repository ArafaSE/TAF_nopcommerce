package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullNameTxt;

    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Enquiry")
    WebElement enquiryTxt;

    @FindBy(name = "send-email")
    WebElement submitBtn;

    @FindBy(css = "div.result")
    public WebElement successMsg; //Your enquiry has been successfully sent to the store owner.

    public void contactUs(String fullName, String email, String message){
        setTextElement(fullNameTxt, fullName);
        setTextElement(emailTxt, email);
        setTextElement(enquiryTxt, message);
        clickButton(submitBtn);
    }
}
