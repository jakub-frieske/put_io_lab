package put.selenium.pageobjects.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(xpath="//h3")
    WebElement header;

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="repeat_password")
    WebElement repeatPassword;

    @FindBy(name="name")
    WebElement name;

    @FindBy(name="addressData")
    WebElement addressData;

    @FindBy(name="submit")
    WebElement submit;

    public RegistrationPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    public boolean isOnPage(){
        return header.getText().equals("Register");
    }

    public void registerUser(String usernameValue, String passwordValue,
                             String repeatPasswordValue, String nameValue, String addressDataValue){
        fillField(this.username, usernameValue);
        fillField(this.password, passwordValue);
        fillField(this.repeatPassword, repeatPasswordValue);
        fillField(this.name, nameValue);
        fillField(this.addressData, addressDataValue);

        submit.click();

    }

    private WebElement fillField(WebElement field, String value){
        field.click();
        field.clear();
        field.sendKeys(value);
        return field;
    }



}
