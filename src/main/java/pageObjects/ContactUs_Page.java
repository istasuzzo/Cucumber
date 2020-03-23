package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;

public class ContactUs_Page extends BasePage {
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textefield_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textefield_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textefield_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textefield_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;

	public ContactUs_Page() throws IOException {
		super();
	}
	
	public ContactUs_Page getContactUsPage() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUs_Page();
		
	}
	
	public ContactUs_Page enterFirstName() throws Exception {
		sendKeysToWebElement(textefield_FirstName, "Tom");
		return new ContactUs_Page();
		
	}
	
	public ContactUs_Page enterLastName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textefield_LastName, data.get(row).get(column));
		return new ContactUs_Page();
		
	}
	
	public ContactUs_Page enterEmail(String email) throws Exception {
		sendKeysToWebElement(textefield_EmailAddress, email);
		return new ContactUs_Page();
		
	}
	
	public ContactUs_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textefield_Message, data.get(row).get(column));
		return new ContactUs_Page();
		
	}
	
	public ContactUs_Page clickOnSubmitButton() throws Exception {
		waitAndClickElement(button_Submit);
		return new ContactUs_Page();
		
	}
	
	public ContactUs_Page confirmContactUsFormSubmissionWasSuccessfull() throws IOException {
		WebElement thanksContactUsPage = getDriver().findElement(By.xpath("//*[@id=\"contact_reply\"]/h1"));
		WaitUntilWebElementIsVisible(thanksContactUsPage);
		assertEquals("thank you for your message!2", thanksContactUsPage.getText().toLowerCase());
		return new ContactUs_Page();
		
	}

}
