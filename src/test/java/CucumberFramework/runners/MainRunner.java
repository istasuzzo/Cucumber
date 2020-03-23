package CucumberFramework.runners;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;


@RunWith(Cucumber.class)

@CucumberOptions (
		//feature file location
		features = {"src/test/java/CucumberFramework/resources/features/"},
		//step file location
		glue = {"stepDefinitions"},
		//rende leggibile la console
		monochrome = true,
		dryRun = false,
		//taggare quale Feature da runnare (@Staging ad esempio sopra feature o sopra il singolo scenario)
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:TestReports/LastReport.html"}
		)



public class MainRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeEstentReport() throws IOException {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/main/java/utils/ReportsConfig.xml"));
		BasePage.copyLatestExtentReport();
	}

}
