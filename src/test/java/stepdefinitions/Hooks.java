package stepdefinitions;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class Hooks {
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void afterScenario() {
		testContextSetup.driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File srcPath=((TakesScreenshot)testContextSetup.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(srcPath);
			scenario.attach(fileContent, "image/png", "image");
		}
		
	}

}
