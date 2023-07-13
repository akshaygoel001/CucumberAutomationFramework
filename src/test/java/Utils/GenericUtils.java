package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void switchToChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		window.next();
		String childWindow = window.next();
		driver.switchTo().window(childWindow);
	}
}
