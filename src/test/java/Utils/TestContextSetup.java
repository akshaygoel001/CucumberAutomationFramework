package Utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectsManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectsManager objectPageManager;
	public GenericUtils genericUtils;
	public TestBase testBase;
	
	public TestContextSetup() {
		testBase=new TestBase();
		objectPageManager=new PageObjectsManager(testBase.webDriverManager());
		this.driver=testBase.webDriverManager();
	}
	
}
