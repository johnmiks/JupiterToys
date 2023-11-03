package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.CommonStep;

public class ShopPageObjects {
	
	WebDriver driver = null;
	CommonStep commonStep;
	
	public ShopPageObjects(WebDriver driver) {
		this.driver = driver;
		commonStep = new CommonStep(driver);
	}
	
	private By btn_teddyBear = By.xpath("//div/h4[contains(text(),'Teddy Bear')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_teddyBear = By.xpath("//div/h4[contains(text(),'Teddy Bear')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_stuffedFrog = By.xpath("//div/h4[contains(text(),'Stuffed Frog')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_stuffedFrog = By.xpath("//div/h4[contains(text(),'Stuffed Frog')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_handmadeDoll = By.xpath("//div/h4[contains(text(),'Handmade Doll')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_handmadeDoll = By.xpath("//div/h4[contains(text(),'Handmade Doll')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_fluffyBunny = By.xpath("//div/h4[contains(text(),'Fluffy Bunny')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_fluffyBunny = By.xpath("//div/h4[contains(text(),'Fluffy Bunny')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_smileyBear = By.xpath("//div/h4[contains(text(),'Smiley Bear')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_smileyBear = By.xpath("//div/h4[contains(text(),'Smiley Bear')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_funnyCow = By.xpath("//div/h4[contains(text(),'Funny Cow')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_funnyCow = By.xpath("//div/h4[contains(text(),'Funny Cow')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_valentineBear = By.xpath("//div/h4[contains(text(),'Valentine Bear')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_valentineBear = By.xpath("//div/h4[contains(text(),'Valentine Bear')]/following-sibling::p/span[@class='product-price ng-binding']");
	private By btn_smileyFace = By.xpath("//div/h4[contains(text(),'Smiley Face')]/following-sibling::p/a[contains(text(),'Buy')]");
	private By price_smileyFace = By.xpath("//div/h4[contains(text(),'Smiley Face')]/following-sibling::p/span[@class='product-price ng-binding']");
	
	public void verify_page() {
		commonStep.verifyElement(btn_teddyBear);	
	}
	public void Buy_teddyBear(int qty) {
		commonStep.click_multiple(btn_teddyBear, qty);	
	}	
	public void Buy_stuffedFrog(int qty) {
		commonStep.click_multiple(btn_stuffedFrog, qty);
	}	
	public void Buy_handmadeDoll(int qty) {
		commonStep.click_multiple(btn_handmadeDoll, qty);
	}	
	public void Buy_fluffyBunny(int qty) {
		commonStep.click_multiple(btn_fluffyBunny, qty);
	}	
	public void Buy_smileyBear(int qty) {
		commonStep.click_multiple(btn_smileyBear, qty);
	}	
	public void Buy_funnyCow(int qty) {
		commonStep.click_multiple(btn_funnyCow, qty);
	}	
	public void Buy_valentineBear(int qty) {
		commonStep.click_multiple(btn_valentineBear, qty);
	}	
	public void Buy_smileyFace(int qty) {	
		commonStep.click_multiple(btn_smileyFace, qty);
	}	
	
	public String get_teddyBear_price() {
		String value = commonStep.getValue(price_teddyBear);	
		return value;
	}	
	public String get_stuffedFrog_price() {
		String value = commonStep.getValue(price_stuffedFrog);
		return value;
	}	
	public String get_handmadeDoll_price() {
		String value = commonStep.getValue(price_handmadeDoll);
		return value;
	}	
	public String get_fluffyBunny_price() {
		String value = commonStep.getValue(price_fluffyBunny);
		return value;
	}	
	public String get_smileyBear_price() {
		String value = commonStep.getValue(price_smileyBear);
		return value;
	}	
	public String get_funnyCow_price() {
		String value = commonStep.getValue(price_funnyCow);
		return value;
	}	
	public String get_valentineBear_price() {
		String value = commonStep.getValue(price_valentineBear);
		return value;
	}	
	public String get_smileyFace_price() {	
		String value = commonStep.getValue(price_smileyFace);
		return value;
	}
	
	public String buy_Item(String item, int qty) {
		By btn_generic = By.xpath("//div/h4[contains(text(),'"+item+"')]/following-sibling::p/a[contains(text(),'Buy')]");
		By price_generic = By.xpath("//div/h4[contains(text(),'"+item+"')]/following-sibling::p/span[@class='product-price ng-binding']");
		
		commonStep.click_multiple(btn_generic, qty);
		
		String price = commonStep.getValue(price_generic);
		return price;
	}
	
}
