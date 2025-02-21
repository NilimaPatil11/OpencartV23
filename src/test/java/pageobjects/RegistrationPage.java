package pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath=("//input[@id='input-firstname']"))  WebElement txt_firstname;
	@FindBy(xpath=("//input[@id='input-lastname']"))  WebElement txt_lastname;
	@FindBy(xpath=("//input[@id='input-email']"))  WebElement txt_email;
	@FindBy(xpath=("//input[@id='input-telephone']"))  WebElement txt_telephon;
	@FindBy(xpath=("//input[@id='input-password']"))  WebElement txt_password;
	@FindBy(xpath=("//input[@id='input-confirm']"))  WebElement txt_confpassword;
	@FindBy(xpath=("//input[@value='0']"))  WebElement rdio_subscribe;
	@FindBy(xpath=("//input[@name='agree']"))  WebElement chk_checkpolicy;
	@FindBy(xpath=("//input[@value='Continue']"))  WebElement btn_continue;
	@FindBy(xpath=("//h1[text()='Your Account Has Been Created!']")) WebElement confmsg;
	
	
	public void setfirstname(String fname)
	{
		 txt_firstname.sendKeys(fname);
	}
	public void setlastname(String lname)
	{
		 txt_lastname.sendKeys(lname);
	}
	public void setemail(String email)
	{
		 txt_email.sendKeys(email);
	}
	public void settelephon(String telephon)
	{
		 txt_telephon.sendKeys(telephon);
	}
	public void setpassword(String pass)
	{
		 txt_password.sendKeys(pass);
	}
	public void setconfpassword(String confpass)
	{
		txt_confpassword.sendKeys(confpass);
	}
	public void clksubscribe()
	{
		 rdio_subscribe.click();
	}
	public void checkpolicy()
	{
		chk_checkpolicy.click();
	}
	public void clkcontinue()
	{
		 btn_continue.click();
	}
	
	public void veryfyreglabel()
	{
		assertEquals(confmsg.getText(),"Your Account Has Been Created!");
	}

}
