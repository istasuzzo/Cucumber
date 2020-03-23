package stepDefinitions;

import java.io.IOException;

//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.concurrent.TimeUnit;
//
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory {
//	WebDriver driver = new SafariDriver();
	
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
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws InterruptedException {
		getDriver().get(url);

	}

	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String locator) throws InterruptedException {
		basePage.WaitUntilWebElementIsVisibleUsingByLocator(By.cssSelector(locator));
		getDriver().findElement(By.cssSelector(locator)).click();

	}

	@Then("^user should be presented with promo alert$")
	public void user_should_be_presented_with_promo_alert() throws InterruptedException, IOException {
		productsPage.printSpecialOfferVoucherCode();
		productsPage.clickOnProceedButton_Popup();
	}


}
