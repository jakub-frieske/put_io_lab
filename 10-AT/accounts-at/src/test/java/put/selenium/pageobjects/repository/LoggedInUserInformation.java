package put.selenium.pageobjects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInUserInformation {

    WebDriver driver;

    @FindBy(xpath="//div[2]/div[2]")
    WebElement loggedInUser;



    public LoggedInUserInformation(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public String getUserInformation(){
        return loggedInUser.getText();
    }
}
