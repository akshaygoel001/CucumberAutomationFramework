package pageObjects;

import org.openqa.selenium.WebDriver;

import Utils.GenericUtils;
import Utils.PropertiesLoader;

public class PageObjectsManager {
	
	public WebDriver driver;
	
	public PageObjectsManager(WebDriver driver) {
		this.driver=driver;
	}
	public LandingPage getLandingPage() {
		return new LandingPage(driver);
	}
	public OffersPage getOfferPage() {
		 return new OffersPage(driver);
	}
	public GenericUtils getGenericUtils() {
		 return new GenericUtils(driver);
	}
	public PropertiesLoader getProperties(){
		return new PropertiesLoader();
	}
	public CartPage getCartPage() {
		return new CartPage(driver);
	}
	

}
