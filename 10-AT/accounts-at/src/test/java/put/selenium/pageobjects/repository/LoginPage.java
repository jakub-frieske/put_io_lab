package put.selenium.pageobjects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath="//h3")
    WebElement header;

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="submit")
    WebElement submit;

    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    public boolean isOnPage(){
        return header.getText().equals("Login");
    }

    public LoginPage loginUser(String usernameValue, String passwordValue){
        fillField(this.username, usernameValue);
        fillField(this.password, passwordValue);
        submit.click();

        return this;
    }

    private WebElement fillField(WebElement field, String value){
        field.click();
        field.clear();
        field.sendKeys(value);
        return field;
    }
}
