package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.landingPage;
import resourcces.base;

public class ValidateTittle extends base{
	public WebDriver driver;
	static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));	
		log.info("navigated to HomePage");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		landingPage l = new landingPage(driver);
		Assert.assertEquals(l.getTittle().getText(), "FEATURED COURS1ES");
		log.info("successfully Validated");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
