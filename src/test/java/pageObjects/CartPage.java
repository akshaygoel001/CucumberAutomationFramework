package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	public WebDriver driver;
	
	private By cartPageProductName=By.cssSelector("p.product-name");
	private By applyButton=By.cssSelector("button.promoBtn");
	private By placeOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
	private By cartPageTotalPrice=By.cssSelector("table.cartTable>tbody>tr>td:nth-child(5)>p");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getProductName() {
		return driver.findElement(cartPageProductName).getText();
	}
	public boolean isApplyButtonDisplayed() {
		return driver.findElement(applyButton).isDisplayed();
	}
	public boolean isPlaceOrderButtonDisplayed() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	public String getTotalPrice() {
		return driver.findElement(cartPageTotalPrice).getText();
	}
	
	
	

}
