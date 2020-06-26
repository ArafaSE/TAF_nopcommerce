package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordTxt;

    @FindBy(className = "change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "div.result")
    public WebElement resultLb1;

    public void openChangePasswordPage() {
        clickButton(changePasswordLink);
    }

    public void changePassword(String oldPassword, String newPassword) {
        setTextElement(oldPasswordTxt, oldPassword);
        setTextElement(newPasswordTxt, newPassword);
        setTextElement(confirmNewPasswordTxt, newPassword);
        clickButton(changePasswordBtn);
    }
}
