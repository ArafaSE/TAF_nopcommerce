package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;

    @FindBy(className = "search-box-button")
    WebElement searchBtn;

    @FindBy(id = "ui-id-1")
    List<WebElement> productSuggestionList;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;

    public void productSearch(String productName){
        setTextElement(searchTxtBox, productName);
        clickButton(searchBtn);
    }

    public void openProductDetailsPage(){
        clickButton(productTitle);
    }

    public void productSearchUsingAutoSuggest(String searchTxt){
        setTextElement(searchTxtBox, searchTxt);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productSuggestionList.get(0).click();
    }

}
