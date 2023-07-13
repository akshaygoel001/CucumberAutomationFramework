package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public WebDriver webDriverManager() {
		
		PropertiesLoader prop=new PropertiesLoader();
		String browser=prop.getPropertyValue("browser");
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
				WebDriverManager.chromedriver().setup();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
				WebDriverManager.firefoxdriver().setup();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
				WebDriverManager.edgedriver().setup();
			}
		}
		return driver;
	}
}
