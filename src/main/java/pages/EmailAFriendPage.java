package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends PageBase {
    public EmailAFriendPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxt;

    @FindBy(id = "YourEmailAddress")
    WebElement userEmailTxt;

    @FindBy(id = "PersonalMessage")
    WebElement personalMsgTxt;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public WebElement successMsg;

    public void sendEmailToAFriend(String  friendEmail, String personalMsg){
        setTextElement(friendEmailTxt, friendEmail);
        setTextElement(personalMsgTxt, personalMsg);
        clickButton(sendEmailBtn);
    }
}
