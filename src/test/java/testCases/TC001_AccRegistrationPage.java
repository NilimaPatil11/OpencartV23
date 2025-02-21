package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;

public class TC001_AccRegistrationPage extends BaseClass {
	
	//public WebDriver driver;
	
	@Test(groups = "Regression")
	public void verifyaccregistration() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.myaccountclk();
		hp.registerclk();
		RegistrationPage rp=new RegistrationPage(driver);
		rp.setfirstname(randomname().toUpperCase());
		rp.setlastname(randomname().toUpperCase());
		rp.setemail(randomemail());
		rp.settelephon(randomnumber());
		String pass=randompass();
		rp.setpassword(pass);
		rp.setconfpassword(pass);
		rp.clksubscribe();
		rp.checkpolicy();
		Thread.sleep(5000);
		rp.clkcontinue();
		rp.veryfyreglabel();
		
	}
	

	
	
	

}
