package stepdefinitions;

import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.LandingPage;

public class CartPageStepDefinition {

	public TestContextSetup testContextSetup;
	public int productPricePerUnit;
	public String cartPageProductName;
	public int landingPagetotalPrice;
	public int cartPageTotalPrice;
	
	public CartPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@When("User add {string} to cart with {int} units")
	public void user_add_to_cart_with_units(String product, Integer quantity) {
		LandingPage landingPage=testContextSetup.objectPageManager.getLandingPage();
		productPricePerUnit=Integer.parseInt(landingPage.getPrice());
		System.out.println("Product Price is: "+productPricePerUnit);
		landingPage.addProduct(quantity);
		landingPage.addtoCart();
		landingPagetotalPrice=Integer.parseInt(landingPage.getCartInfoPrice())  ;
	}
	

	@When("User proceed to checkout on cart page")
	public void user_proceed_to_checkout_on_cart_page() {
		LandingPage landingPage=testContextSetup.objectPageManager.getLandingPage();
		landingPage.clickCartIcon();
		landingPage.proceedToCheckout();
		CartPage cartPage=testContextSetup.objectPageManager.getCartPage();
		cartPageProductName=cartPage.getProductName().split("-")[0].trim();
		cartPageTotalPrice=Integer.parseInt(cartPage.getTotalPrice()) ;
	}
	
	@Then("Validate cart page product name matches name in landing page")
	public void validate_cart_page_product_name_matches_name_in_landing_page() {
		Assert.assertEquals(cartPageProductName, testContextSetup.landingPageProductName);
	}

	@Then("Validate quanity {int} and total price on cart page")
	public void validate_quanity_and_total_price_on_cart_page(Integer quantity) {
		Assert.assertEquals(cartPageTotalPrice, landingPagetotalPrice);
	}

	@Then("Validate Apply and Place Order button")
	public void validate_apply_and_place_order_button() {
	    Assert.assertTrue(testContextSetup.objectPageManager.getCartPage().isApplyButtonDisplayed());
	    Assert.assertTrue(testContextSetup.objectPageManager.getCartPage().isPlaceOrderButtonDisplayed());
	}
}
