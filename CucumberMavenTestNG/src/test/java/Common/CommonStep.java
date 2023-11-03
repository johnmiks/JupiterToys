package Common;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonStep {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	//Constructor
	public CommonStep(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}
	
	public void click(By byElement) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byElement));
		element.click();
	}
	
	public void click_multiple(By byElement,int a) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byElement));

		for(int b=1; b<=a;b++) {
			element.click();
		}
	}
	
	public void inputText(By byElement,String input) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		element.clear();
		element.sendKeys(input);
	}
	
	public String getValue(By byElement) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		String value = element.getText();
		
		return value;
	}	
	
	public void validateText(By byElement, String message) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		String value = element.getAttribute("innerText");
		Assert.assertEquals(value, message, "FAILED: Element value \""+value+"\" does NOT match expected value\""+message+"\"");
	}	
	
	public void verifyElement(By byElement) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		Assert.assertTrue(element.isDisplayed(),"FAILED: \""+element+"\" is NOT displayed.");
	}
	
	public void verify_notDisplayed(By byElement) {
		boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
		Assert.assertEquals(element, true, "FAILED: Element is displayed!");
	}
}
