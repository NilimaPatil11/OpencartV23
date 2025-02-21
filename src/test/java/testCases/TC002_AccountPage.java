package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyaccountPage;

public class TC002_AccountPage extends BaseClass{
	
	@Test(groups = {"sanity","Master"})
	public void logIn()
	{
		HomePage hp=new HomePage(driver);
		hp.myaccountclk();
		
		hp.loginclk();
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPass(p.getProperty("password"));
		lp.clkLogin();
		MyaccountPage acc=new MyaccountPage(driver);
		Assert.assertEquals(acc.ismsgDisplay(),true,"Login Failed");
	}
	

}
