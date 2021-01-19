package put.selenium.pageobjects.repository;

import org.openqa.selenium.WebDriver;

public class ResetDatabase {

    private final WebDriver driver;

    private String hostURL;

    public ResetDatabase(WebDriver driver, String hostURL){
        this.driver = driver;
        this.hostURL = hostURL;
    }

    public void resetDatabase(){
        driver.get(String.format("%s/accounts/controller?action=db_reset", hostURL));
    }

}
