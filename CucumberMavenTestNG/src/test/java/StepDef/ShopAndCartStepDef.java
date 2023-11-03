package StepDef;
import java.util.HashMap;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.CartPageObjects;
import PageObjects.ShopPageObjects;
import PageObjects.navBarObjects;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopAndCartStepDef{
	private Hooks hooks;
	private WebDriver driver;

	private ShopPageObjects shopPage;
	private CartPageObjects cartPage;
	private navBarObjects navBar;
	private HashMap<String, String> itemPrice = new HashMap<String, String>();
	
	public ShopAndCartStepDef(Hooks hooks){
		this.hooks = hooks;
		driver = this.hooks.getWebDriver();
	}
	
	public void storePrice(String item, String price) {
		itemPrice.put(item.toString(), price);
	}
	
	public Object getPrice(String item) {
		return itemPrice.get(item.toString());
	}
	
	public Boolean isContains(String item){
        return itemPrice.containsKey(item.toString());
    }	
	
	@Given("I am on the Shop page")
	public void i_am_on_the_shop_page() {
		driver.get("https://jupiter.cloud.planittesting.com/#/shop");

		shopPage = new ShopPageObjects(driver);
		cartPage = new CartPageObjects(driver);
		navBar = new navBarObjects(driver);
	}
	
	@When("I take note of the price and buy {int} {string}")
	public void i_take_note_of_the_price_and_buy(Integer qty, String item) {
		String price = shopPage.buy_Item(item, qty);

		storePrice(item,price);
		
		if(isContains(item)==null) {
			storePrice(item,price);
		}else if(isContains(item)){
			System.out.println("Already have the price for item "+item);
		}else{
			storePrice(item,price);
		}
	}
	
	@Then("I should be able to verify if the price and total is correct in the cart")
	public void i_should_be_able_to_verify_if_the_price_and_total_is_correct_in_the_cart() {
		navBar.click_cart();
		
		try {
			int a = cartPage.verify_itemTableSize();
			double addedTotal = 0;
			
			for (int b=1 ; b<=a ; b++) {
				String Price_text = cartPage.get_Price(b);
				String qty_text = cartPage.get_itemQuantity(b);
				String subtotal_text = cartPage.get_itemSubtotal(b);
				
				//validate item price is correct
				Assert.assertEquals(Price_text, getPrice(cartPage.get_itemName(b).trim()));
				 
				Price_text = Price_text.replace("$", "");
				subtotal_text = subtotal_text.replace("$", "");
				
				double item_price = Double.parseDouble(Price_text);
				double quantity = Double.parseDouble(qty_text);
				double act_item_subtotal = Double.parseDouble(subtotal_text);
				double item_subtotal = item_price * quantity; 
				
				//validate subtotal based on qty and item price
				Assert.assertEquals(item_subtotal, act_item_subtotal);
				
				addedTotal = addedTotal + item_subtotal;

				System.out.println("item subtotal: "+item_subtotal+" actual item subtotal: "+act_item_subtotal+" Added total:"+addedTotal);
			}	
			
			double Total = Double.parseDouble(cartPage.get_Total());
			
			//validate Total
			System.out.println(addedTotal+" "+Total);
			Assert.assertEquals(addedTotal, Total);
			
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		
		
	}
}
