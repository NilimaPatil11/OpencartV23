package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyaccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(priority = 0)
	public void set()
	{
		HomePage hp=new HomePage(driver);
		hp.myaccountclk();
		
		hp.loginclk();
	}
	
	
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class,priority = 1)
	public void verifylogInDDT(String email,String pass,String expres) throws InterruptedException
	{

		
		
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPass(pass);
		
		lp.clkLogin();
		
		
		MyaccountPage acc=new MyaccountPage(driver);
		
		if(expres.equalsIgnoreCase("valid"))
		{
			if(acc.ismsgDisplay()==true)
			{
				acc.clklogOut();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(expres.equalsIgnoreCase("Invalid"))
		{
			if(acc.ismsgDisplay()==true)
			{
				acc.clklogOut();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		
	 
	}
	

}
