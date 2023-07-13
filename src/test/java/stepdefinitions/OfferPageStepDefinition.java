package stepdefinitions;

import org.testng.Assert;

import Utils.GenericUtils;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectsManager;

public class OfferPageStepDefinition {

	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public PageObjectsManager objectPageManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortname) {
		switchToOfferPage();
		OffersPage offerPage=testContextSetup.objectPageManager.getOfferPage();
		offerPage.searchProduct(shortname);
		offerPageProductName=offerPage.getProductName();
	}
	@Then("Validate offer page product name matches name in landing page")
	public void validate_offer_page_product_name_matches_name_in_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
		
	}
	
	public void switchToOfferPage() {
		LandingPage landingPage=testContextSetup.objectPageManager.getLandingPage();
		landingPage.clickOnLinkByText("Top Deals");
		GenericUtils genericUtils=testContextSetup.objectPageManager.getGenericUtils();
		genericUtils.switchToChildWindow();
	}
}
