package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utility.DynamicData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	public String sTestCaseName;
	public int iTestCaseRow;
	
	public static String driverPath = "C://Users//dell//Desktop//2018//";
	WebDriver driver;
	
@BeforeMethod
	
	public void SetUp()
	{
	System.out.println("setup started");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		 driver= new ChromeDriver();
			//driver.manage().window().maximize();
		 driver.get("http://demosite.center/wordpress/wp-login.php");	 
		 
	}
	
		
	@AfterMethod
	 
	  public void afterMethod() {
	 
		   driver.close();
		   driver.quit();
	 
	  }

	
	
	
/*	By id= By.xpath("//*[@id='user_login']");
	By passworde=By.xpath("//*[@id='user_pass']");
	By submit=By.xpath("//*[@id='wp_submit']");*/
	
	@BeforeClass
	public void setupTestData()
	{
		/*try {
			ExcelUtils.setExcelFile(sheetName); 
			System.out.println("sheet Name" +sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		DynamicData.SheetName="login";
	}
	
	
	
 
	 @Test(dataProvider = "Auth", dataProviderClass=utility.DynamicData.class)
 
  public void signIn(String TestName,String sUserName, String sPassword) {
 

 
	    driver.findElement(By.id("user_login")).sendKeys(sUserName);
	    System.out.println("clicked he username");
 
		System.out.println(sUserName);
 
	    driver.findElement(By.id("user_pass")).sendKeys(sPassword);
 
		System.out.println(sPassword);
 
	    driver.findElement(By.id("wp-submit")).click();
 
	    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
 

 
  }
 
 @Test(dataProvider = "Auth", dataProviderClass=utility.DynamicData.class)
  
  public void vino(String TestName,String sUserName, String sPassword) {
	  

	  
	    driver.findElement(By.id("user_login")).sendKeys(sUserName);
	    System.out.println("clicked he username");

		System.out.println(sUserName);

	    driver.findElement(By.id("user_pass")).sendKeys(sPassword);

		System.out.println(sPassword);

	    driver.findElement(By.id("wp-submit")).click();

	    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");



} 
 
}