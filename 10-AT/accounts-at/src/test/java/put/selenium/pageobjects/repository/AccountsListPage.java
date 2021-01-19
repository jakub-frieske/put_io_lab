package put.selenium.pageobjects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsListPage {

    WebDriver driver;

    @FindBy(xpath="//h3")
    WebElement header;

    public AccountsListPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    public boolean isOnPage(){
        return header.getText().equals("Your accounts");
    }

}
