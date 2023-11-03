package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.CommonStep;

public class CartPageObjects {
	WebDriver driver = null;
	WebDriverWait wait = null;
	CommonStep commonStep;
	float teddyBear,stuffedFrog,handmadeDoll,fluffyBunny,smileyBear,funnyCow,valentineBear,smileyFace;
	
	public CartPageObjects(WebDriver driver) {
		this.driver = driver;
		commonStep = new CommonStep(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	By btn_checkOut = By.xpath("//a[contains(text(),'Check Out')]");
	By btn_emptyCart = By.xpath("//a[contains(text(),'Empty Cart')]");
	By txt_total = By.xpath("//strong[contains(text(),'Total: ')]");
	By item_table = By.xpath("//tbody/child::tr");
	
	public WebElement verify_itemTable() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(item_table));
	}
	public int verify_itemTableSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(item_table));
		return driver.findElements(item_table).size();
	}
	public String get_itemSubtotal(int ItemNumber) {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr["+ItemNumber+"]/td[count(//th[contains(text(),'Subtotal')]/preceding-sibling::th)+1]"))).getText();
	}
	public String get_itemQuantity(int ItemNumber){ 
		return driver.findElement(By.xpath("//tbody/tr["+ItemNumber+"]/td[count(//th[contains(text(),'Quantity')]/preceding-sibling::th)+1]/input")).getAttribute("value");
	}
	public String get_Price(int ItemNumber){
		return driver.findElement(By.xpath("//tbody/tr["+ItemNumber+"]/td[count(//th[contains(text(),'Price')]/preceding-sibling::th)+1]")).getText();
	}
	public String get_itemName(int ItemNumber) {
		return driver.findElement(By.xpath("//tbody/tr["+ItemNumber+"]/td[count(//th[contains(text(),'Item')]/preceding-sibling::th)+1]")).getText();
	}
	public String get_Total() {
		return driver.findElement(txt_total).getText().replace("Total: ", "");
	}	
}
