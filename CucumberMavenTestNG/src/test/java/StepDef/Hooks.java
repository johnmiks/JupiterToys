package StepDef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;

public class Hooks{
	private WebDriver driver;
	
	@Before
	public void beforeScenario(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void afterScenario() {
		if(driver!=null) {
			driver.quit();
		}
	}
	public WebDriver getWebDriver() {
		return driver;
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");
	}
}
