package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features/checkOut.feature",
				glue = {"stepdefinitions"},
				monochrome = true,
				dryRun = false
				)
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

	
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
}
