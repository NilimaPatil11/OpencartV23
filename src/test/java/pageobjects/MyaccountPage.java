package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {
	public MyaccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath=("//h2[text()='My Account']")) WebElement headermsg_display;
	@FindBy(xpath=("//a[@class='list-group-item'][normalize-space()='Logout']")) WebElement logout;
	
	public boolean ismsgDisplay()
	{
		try {
		return (headermsg_display.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clklogOut()
	{
		logout.click();
	}

}
