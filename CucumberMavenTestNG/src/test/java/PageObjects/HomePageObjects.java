package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.CommonStep;

public class HomePageObjects{

	WebDriver driver = null;
	WebElement element = null;
	CommonStep commonStep;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		commonStep = new CommonStep(driver);
	}
	
	By header = By.xpath("//h1[contains(text(),'Jupiter Toys')]");
	By btn_header = By.xpath("//a[contains(text(),'Start Shopping')]");

	public void verify_Header() {
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(header));

		commonStep.verifyElement(header);	
	}
	
	public void click_StartShopping() {
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btn_header));

		commonStep.click(btn_header);
	}
}
