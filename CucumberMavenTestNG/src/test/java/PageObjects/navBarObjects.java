package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.CommonStep;

public class navBarObjects{
	
	WebDriver driver = null;
	WebElement element = null;
	CommonStep commonStep;
	
	public navBarObjects(WebDriver driver) {
		this.driver = driver;

		commonStep = new CommonStep(driver);
	}
	
	By jupiterToysLogo = By.xpath("//a[contains(text(),'Jupiter Toys')]");	
	By home = By.xpath("//a[contains(text(),'Home')]");	
	By shop = By.xpath("//a[contains(text(),'Shop')]");	
	By contact = By.xpath("//a[contains(text(),'Contact')]");	
	By login = By.xpath("//a[contains(text(),'Login')]");	
	By cart = By.xpath("//a[contains(text(),'Cart')]");	
	
	//login popup
	By header_login = By.xpath("//h1[contains(text(),'Login')]");	
	By txtbox_username = By.xpath("//label[contains(text(),'Username')]/following-sibling::input");	
	By txtbox_password = By.xpath("//label[contains(text(),'Password')]/following-sibling::input");	
	By btn_login = By.xpath("//button[contains(text(),'Login')]");	
	By btn_cancel = By.xpath("//button[contains(text(),'Cancel')]");	
	
	
	public void click_jupiterToysLogo() {
		commonStep.click(jupiterToysLogo);
	}
	public void click_home() {
		commonStep.click(home);
	}
	public void click_shop() {
		commonStep.click(shop);
	}
	public void click_contact() {
		commonStep.click(contact);
	}
	public void click_login() {
		commonStep.click(login);
	}
	public void click_cart() {
		commonStep.click(cart);
	}
	public void verify_header_login(String text) {
		commonStep.validateText(header_login, text);
	}
	public void click_btn_login() {
		commonStep.click(btn_login);
	}
	public void click_cancel() {
		commonStep.click(btn_cancel);
	}
	public void input_username(String text) {
		commonStep.inputText(txtbox_username, text);
	}
	public void input_password(String text) {
		commonStep.inputText(txtbox_password, text);
	}
	
	

}
