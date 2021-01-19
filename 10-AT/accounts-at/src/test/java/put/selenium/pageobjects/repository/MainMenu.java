package put.selenium.pageobjects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu {

    WebDriver driver;

    @FindBy(linkText="Register")
    WebElement register;

    @FindBy(linkText="Login")
    WebElement login;


    public MainMenu(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterLink(){
        register.click();
    }

    public void clickLoginLink(){
        login.click();
    }
}
