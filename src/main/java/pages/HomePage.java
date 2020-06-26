package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver; // to use in contact us page
        action = new Actions(driver);// to use with hover
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsPageLink;

    @FindBy(id = "customerCurrency")
    WebElement currencyList;

    @FindBy(linkText = "Computers")
    WebElement computerMenuLink;

    @FindBy(linkText = "Notebooks")
    WebElement notebooksMenuLink;

    public void openRegistrationPage()
    {
        registerLink.click();
        clickButton(registerLink);
    }

    public void openLoginPage(){
        clickButton(loginLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }

    public void openContactUsPage(){
        scrollToBottom();
        clickButton(contactUsPageLink);
    }

    public void changeCurrency(){
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }

    public void selectNotebooksMenu(){
        /* in one line but it's not working, needs wait*/
        //action.moveToElement(computerMenuLink).moveToElement(notebooksMenuLink).click().build().perform();

        // move the mouse to the earlier identified menu option
        action.moveToElement(computerMenuLink).build().perform();
        // wait for 1 seconds before proceeding. until this submenu is found
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //identify menu option from the resulting menu display and click
        action.moveToElement(notebooksMenuLink).click().build().perform();
    }


}
