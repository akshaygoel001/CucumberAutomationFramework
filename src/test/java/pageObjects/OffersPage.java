package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;
	
	private By search=By.xpath("//input[@type='search']");
	private By productName=By.cssSelector("table.table.table-bordered>tbody>tr>td:nth-child(1)");
	
	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}

	public void searchProduct(String searchString) {
		driver.findElement(search).sendKeys(searchString);
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	

}
