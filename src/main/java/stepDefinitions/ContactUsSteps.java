package stepDefinitions;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pageObjects.ContactUs_Page;
import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {
//	WebDriver driver;
//	
//	@Before()
//	public void setup() throws IOException {
//		System.setProperty("webdriver.gecko.driver", Paths.get(System.getProperty("user.dir")).toRealPath() + "/src/test/java/CucumberFramework/resources/others/geckodriver");
//		this.driver = new FirefoxDriver();
//		this.driver.manage().window().maximize();
//		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//	}
//	
//	@After()
//	public void tearDown() {
//		this.driver.manage().deleteAllCookies();
//		this.driver.quit();
//	}
//	
	
	@Given("^I access webdriveruniversity Contact Us form$")
	public void i_access_webdriveruniversity_Contact_Us_form() throws IOException  {
		contactusPage.getContactUsPage();
	}

	@When("^I enter a valid first name$")
	public void i_enter_a_valid_first_name() throws Exception {
		contactusPage.enterFirstName();

	}

	@And("^I enter a valid last name$")
	public void i_enter_a_valid_last_name(DataTable dataTable) throws Exception {
		contactusPage.enterLastName(dataTable, 0, 1);

	}

	@And("^I enter a valid last email address$")
	public void i_enter_a_valid_last_email_address() throws Exception {
		contactusPage.enterEmail("webdriveruniversity@outlook.com");

	}

	@And("^I enter a comments$")
	public void i_enter_a_comments(DataTable dataTable) throws Exception {
		contactusPage.enterComments(dataTable, 0, 1);
	}

	@And("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Exception {
		contactusPage.clickOnSubmitButton();

	}

	@Then("^the information should succesfully be submitted via the Contact Us form$")
	public void the_information_should_succesfully_be_submitted_via_the_Contact_Us_form() throws InterruptedException, IOException {
		contactusPage.confirmContactUsFormSubmissionWasSuccessfull();


	}


}
