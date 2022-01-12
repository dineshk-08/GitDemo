package resourcces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		 prop = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\E2EProjectt\\src\\main\\java\\resourcces\\data.properties");
	
	prop.load(file);
	String browserName = prop.getProperty("browser");
System.out.println(browserName);
	
	if(browserName.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Desktop\\FireFoxDrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	else if (browserName=="Edge") {
		
	}
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
	
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source,new File(destinationFile));
	}

}
