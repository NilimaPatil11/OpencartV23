package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath=("//span[normalize-space()='My Account']"))  WebElement btn_myaccount;
	//@FindBy(xpath=("//ul[@class='dropdown-menu dropdown-menu-right']//li")) List<WebElement> dropdown;
	
	@FindBy(xpath=("//a[normalize-space()='Register']"))  WebElement link_register;
	@FindBy(xpath=("//a[normalize-space()='Login']")) WebElement link_login;
	
	public void myaccountclk()
	{
		btn_myaccount.click();
	}
	public void registerclk()
	{
		link_register.click();
	}
	public void loginclk()
	{
		link_login.click();
	}
	
	
}
