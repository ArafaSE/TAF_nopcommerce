package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PageBase {
    protected WebDriver driver; // protected (package scope)
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;// to use with hover

    // create constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement btn)
    {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btn.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void setTextElement(WebElement TextElement, String textValue)
    {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TextElement.sendKeys(textValue);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollToBottom(){
        jse.executeScript("scrollBy(0,3000)");
    }

    public void clearText(WebElement element){
        element.clear();
    }

}
