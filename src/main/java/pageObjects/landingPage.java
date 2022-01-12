package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	
	
	public WebDriver driver;
	
	By signIn = By.cssSelector("a[href*='sign_in']");
	By tittle = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public landingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement getTittle() {
		return driver.findElement(tittle);
}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
}
}
