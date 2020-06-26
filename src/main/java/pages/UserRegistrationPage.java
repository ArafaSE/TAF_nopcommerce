package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderMaleRadioBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxt;

    @FindBy(id = "LastName")
    WebElement lastNameTxt;

    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Password")
    WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    WebElement confPasswordTxt;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement successMsg;

    @FindBy(css = "a.ico-logout")
    public WebElement logoutLink;


    public void userRegistration(String fName, String lName, String email, String pass){
        clickButton(genderMaleRadioBtn);
        setTextElement(firstNameTxt, fName);
        setTextElement(lastNameTxt, lName);
        setTextElement(emailTxt, email);
        setTextElement(passwordTxt, pass);
        setTextElement(confPasswordTxt, pass);
        clickButton(registerBtn);
    }

    public void userLogout(){
        clickButton(logoutLink);
    }


}
