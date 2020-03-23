package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage {
	public @FindBy(css = "#container-special-offers") WebElement button_Special_Offers;
	public @FindBy(css = "#container-product2") WebElement button_Laptops;
	public @FindBy(xpath = ".//*[@id='myModal']//b[contains(text(), 'NEWCUSTOMER')]") WebElement voucherNumber;
	public @FindBy(xpath = "//button[text()='Proceed']") WebElement button_Proceed_Popup;
			
	public Products_Page() throws IOException {
		super();
	}

	public Products_Page clickOnProceedButton_Popup() throws IOException, InterruptedException {
		waitAndClickElement(button_Proceed_Popup);
		return new Products_Page();
	}
	
	public String printSpecialOfferVoucherCode() {
		WaitUntilWebElementIsVisible(voucherNumber);
		String vouchercode = voucherNumber.getText();
		System.out.println("Your voucher code is: " + vouchercode);
		return vouchercode;
		
	}
	
	
}
