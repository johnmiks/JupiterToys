package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.CommonStep;

import org.openqa.selenium.By;

public class ContactPageObjects {
	private CommonStep commonStep;
	
	//By locators
	private By header_headerMessage = By.xpath("//div[@id='header-message']");
		//tell it how it is.
		//err
		//"but we won't get it unless you complete the form correctly."
	private By txtbox_forename = By.xpath("//input[@id='forename']");
	private By err_forename = By.xpath("//span[@id='forename-err']");
		//err
		//"Forename is required"
	private By txtbox_surname = By.xpath("//input[@id='surname']");
	private By txtbox_email = By.xpath("//input[@id='email']");
	private By err_email = By.xpath("//span[@id='email-err']");
		//err
		//"Email is required"
		//"Please enter a valid email"
	private By txtbox_telephone = By.xpath("//input[@id='telephone']");
	private By txtbox_message = By.xpath("//textarea[@id='message']");
	private By err_message = By.xpath("//span[@id='message-err']");
		//err
		//"Message is required"
	private By btn_submit = By.xpath("//a[contains(text(),'Submit')]");
	private By header_sendingFeedack = By.xpath("//h1[contains(text(),'Sending Feedback')]");
	private By feedbackSuccess = By.xpath("//div[@class='alert alert-success' and contains(.,'we appreciate your feedback.')]");
	
	//Constructor
	public ContactPageObjects(WebDriver driver) {
		commonStep = new CommonStep(driver);
	}
	
	public void verify_Header(String text) {
		commonStep.validateText(header_headerMessage, text);
	}
	public void verify_errForename(String text) {
		commonStep.validateText(err_forename, text);
	}
	public void verify_errEmail(String text) {
		commonStep.validateText(err_email, text);
	}
	public void verify_errMessage(String text) {
		commonStep.validateText(err_message, text);
	}
	public void input_forename(String text) {
		commonStep.inputText(txtbox_forename, text);
	}
	public void input_surname(String text) {
		commonStep.inputText(txtbox_surname, text);
	}
	public void input_email(String text) {
		commonStep.inputText(txtbox_email, text);
	}
	public void input_telephone(String text) {
		commonStep.inputText(txtbox_telephone, text);
	}
	public void input_message(String text) {
		commonStep.inputText(txtbox_message, text);
	}
	public void click_Submit() {
		commonStep.click(btn_submit);
	}	
	
	public void verify_errForenameNotDisplayed() {
		commonStep.verify_notDisplayed(err_forename);
	}
	public void verify_errEmailNotDisplayed() {
		commonStep.verify_notDisplayed(err_email);
	}
	public void verify_errMessageNotDisplayed() {
		commonStep.verify_notDisplayed(err_message);
	}
	public void verify_sendingFeedback() {
		commonStep.verifyElement(header_sendingFeedack);	
	}
	public void verify_feedbackSuccess() {
		commonStep.verify_notDisplayed(header_sendingFeedack);
		commonStep.verifyElement(feedbackSuccess);	
	}
}
