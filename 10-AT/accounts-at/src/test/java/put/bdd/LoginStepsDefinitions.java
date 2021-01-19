package put.bdd;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import put.selenium.pageobjects.repository.*;


/**
 * Steps definition for the Cucumber-JVM example.
 * 
 * @author mochodek
 *
 */
public class LoginStepsDefinitions {

	private WebDriver driver;

	private ResetDatabase resetDatabse;
	private MainMenu mainMenu;
	private RegistrationPage registrationPage;
	private LoginPage loginPage;
	private MainPage mainPage;
	private LoggedInUserInformation loggedInUserInfo;
	private AccountsListPage accountsListPage;

	private String hostURL;
	

	public LoginStepsDefinitions() throws IOException {
		Properties properties = new Properties();
		InputStream in = getClass().getResourceAsStream("bdd.properties");
		properties.load(in);
		in.close();

		this.hostURL=properties.getProperty("host.url");
		//this.hostURL = "http://localhost:8080";

		System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		resetDatabse = new ResetDatabase(driver, this.hostURL);
		mainMenu = new MainMenu(driver);
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver, this.hostURL);
		accountsListPage = new AccountsListPage(driver);
		loggedInUserInfo = new LoggedInUserInformation(driver);

		resetDatabse.resetDatabase();
	}


	@Given("^I have registered as user \"([^\"]*)\" with password \"([^\"]*)\", name \"([^\"]*)\" and with address \"([^\"]*)\"$")
	public void I_have_registered_as_user_with_password_name_and_with_address(
			String username, String password, String name, String address)
			throws Throwable {
		mainPage.openPage();
		mainMenu.clickRegisterLink();
		registrationPage.registerUser(username, password, password, name, address);

	}
	
	@Given("^I've moved to the login page$")
	public void I_am_on() throws Throwable {
		mainPage.openPage();
		mainMenu.clickLoginLink();
		assertTrue(loginPage.isOnPage());
	}


	@When("^I fill the login form with username \"([^\"]*)\" and password \"([^\"]*)\", and I submit it$")
	public void I_fill_in_with(String username, String password) throws Throwable {
		loginPage.loginUser(username, password);
		
	}


	@Then("^I should see the accounts-list page$")
	public void I_should_see_accunts_list_page() throws Throwable {
		assertTrue(accountsListPage.isOnPage());
	}
	
	
	@Given("^I have cleared the database$")
	public void I_have_cleared_the_database() throws Throwable {
	    resetDatabse.resetDatabase();
	}


	@After
	public void closeBrowser(){
		driver.close();
	}

}
