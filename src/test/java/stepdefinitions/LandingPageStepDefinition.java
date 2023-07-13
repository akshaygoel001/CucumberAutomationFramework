package stepdefinitions;


import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Utils.PropertiesLoader;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public TestContextSetup testContextSetup;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		PropertiesLoader properties=testContextSetup.objectPageManager.getProperties();
		testContextSetup.driver.get(properties.getPropertyValue("url"));
		testContextSetup.driver.manage().window().maximize();
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) {
		LandingPage landingPage=testContextSetup.objectPageManager.getLandingPage();
		landingPage.searchProduct(shortname);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	    System.out.println("Product Name is :"+testContextSetup.landingPageProductName);
	}

	
}
