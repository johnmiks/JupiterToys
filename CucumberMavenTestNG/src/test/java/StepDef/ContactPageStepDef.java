package StepDef;

import org.openqa.selenium.WebDriver;

import PageObjects.ContactPageObjects;
import io.cucumber.java.en.*;

public class ContactPageStepDef{
	private ContactPageObjects contactPage;
	private Hooks hooks;
	private WebDriver driver;
	
	public ContactPageStepDef(Hooks hooks) {
		this.hooks = hooks;
		driver = this.hooks.getWebDriver();
	}
	
	@Given("I am on the Jupiter Toys contact page")
	public void i_am_on_the_jupiter_toys_contact_page() {
		driver.get("https://jupiter.cloud.planittesting.com/#/contact");
		contactPage = new ContactPageObjects(driver);
	}
	
	@Given("I have entered valid information and message")
	public void i_have_entered_valid_information_and_message() {
		contactPage.input_forename("Test Forename");
		contactPage.input_email("valid@email.com");
		contactPage.input_message("Valid message");
	}
	
	@Given("I have entered invalid {string}, {string}, {string}")
	public void i_have_entered_invalid(String forename, String email, String message) {
		contactPage.input_forename(forename);
		contactPage.input_email(email);
		contactPage.input_message(message);
	}
	
	@When("I click Submit button")
	public void i_click_submit_button() {
	    contactPage.click_Submit();
	}
	

	@Then("I should be able to send the feedback successfully")
	public void i_should_be_able_to_send_the_feedback_successfully() {
	    contactPage.verify_sendingFeedback();
	    contactPage.verify_feedbackSuccess();
	}
	
	@Then("I should see the following error messages indicating {string}, {string}, {string}, {string}")
	public void i_should_see_the_following_error_messages_indicating(String header_err, String forename_err, String email_err, String message_err) {
	    contactPage.verify_Header(header_err);
		contactPage.verify_errForename(forename_err);
	    contactPage.verify_errEmail(email_err);
	    contactPage.verify_errMessage(message_err);
	}
	
	
}
