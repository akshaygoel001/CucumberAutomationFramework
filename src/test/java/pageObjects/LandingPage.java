package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	private By search=By.xpath("//input[@type='search']");
	private By productName=By.cssSelector("h4.product-name");
	private By incrementIcon=By.cssSelector("a.increment");
	private By productPrice=By.cssSelector("p.product-price");
	private By addToCart=By.cssSelector(".product-action>button");
	private By cartIcon=By.cssSelector("a.cart-icon>img");
	private By proceedToCheckout=By.cssSelector("div.cart-preview.active>div:nth-child(2)>button");
	private By productPriceIncartInfo=By.cssSelector("div.cart-info>table>tbody>tr:nth-child(2)>td:nth-child(3)>strong");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public void searchProduct(String searchString) {
		driver.findElement(search).sendKeys(searchString);
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	public void clickOnLinkByText(String linkName) {
		driver.findElement(By.linkText(linkName)).click();
	}
	public void addProduct(int quantity) {
		for(int i=1;i<quantity;i++) {
			driver.findElement(incrementIcon).click();
		}
	}
	public String getPrice() {
		return driver.findElement(productPrice).getText();
	}
	public void addtoCart() {
		driver.findElement(addToCart).click();
	}
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	public void proceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	public String getCartInfoPrice() {
		return driver.findElement(productPriceIncartInfo).getText();
	}

}
