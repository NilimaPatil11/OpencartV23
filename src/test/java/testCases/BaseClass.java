package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	Properties p;
	
	@BeforeClass(groups = {"Master","sanity","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default:System.out.println("Invalid browser....");return;
		
		}
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));//reading url from properties file
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	@AfterClass()
	public void close()
	{
		//driver.quit();
	}
	public String randomname()
	{
		RandomStringGenerator rs=new RandomStringGenerator.Builder().withinRange('a', 'z').get();
		String fname=rs.generate(8);
		return fname;
		
		
		
	}
	public String randomemail()
	{
		RandomStringGenerator rs=new RandomStringGenerator.Builder().withinRange('a', 'z').get();
		String emailname=(rs.generate(8)+"@gmail.com");
		return emailname;
		
	}
	
	public String randompass()
	{
		RandomStringGenerator rs=new RandomStringGenerator.Builder().withinRange('a', 'z').withinRange('1','9').get();
		String passname=(rs.generate(8));
		return passname;
		
	}
	public String randomnumber()
	{
		RandomStringGenerator rs=new RandomStringGenerator.Builder().withinRange('0','9').get();
		String phonno=(rs.generate(10));
		return phonno;
		
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	

}
