package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.landingPage;
import resourcces.base;

public class HomePage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}

	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));	
		landingPage l = new landingPage(driver);
		l.getLogin().click();
		LoginPage lp= new LoginPage(driver);
		System.out.println("email");
		lp.getEmail().sendKeys("d@gmail.com");
		System.out.println("password");
		lp.getPassword().sendKeys("1234");
		lp.getLogin().click();
		log.info(text);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricted user";
		data[0][1] = "124";
		data[0][2] = "Restricted User";
		
		data[1][0] = "restricted user";
		data[1][1] = "1924";
		data[1][2] = "Non - Restricted User";
		return data;
		
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
