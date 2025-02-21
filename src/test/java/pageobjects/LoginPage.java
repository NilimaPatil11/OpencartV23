package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	@FindBy(xpath=("//input[@id='input-email']")) WebElement txt_email;
	@FindBy(xpath=("//input[@id='input-password']")) WebElement txt_pass;
	@FindBy(xpath=("//input[@value='Login']")) WebElement btn_loginsubmit;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterEmail(String email)
	{
		txt_email.sendKeys(email);
	}

	public void enterPass(String pass)
	{
		
		txt_pass.sendKeys(pass);
		
	}
	public void clkLogin()
	{
		
		btn_loginsubmit.click();
	}

}
