package packComm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestComm {

		//Login scenario with invalid usernames and passwords using Selenium-TestNG framework
		//This test would open browser 3 times testing with 3 different data sets
		//All the tests pass if the assertion is true, and fails otherwise
		
		@Test(dataProvider="getData")
		public void login(String uname, String pword) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dwija\\eclipse-workspace\\Comm\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//go to URL
		driver.get("https://secure.comm100.com/signin");

		//enter username (get username[][] from datatprovider)
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(uname);

		//enter password (get password[][] from datatprovider)
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pword);

		//click on remember me
		driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
		
		//click on sign in button
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		//Validating if the username/password is invalid, it will display an error message
		String actualMsg = driver.findElement(By.className("MuiTypography-gutterBottom")).getText();
		String expectedMsg = "Error signing into the account";
		
		//implementing assertion to verify actual and expected error message
		Assert.assertEquals(actualMsg, expectedMsg);
		
		//close all browsers
		driver.quit();		
		}
		
		
		//Paramterizing using DataProvider - using 3 usernames and passwords
		
		@DataProvider
		public Object[][] getData() throws InterruptedException{
			
			return new Object[][]
				{	
						{"aayushi@gmail.com","vyas"},
						{"ronak@gmail.com","sheth"},
						{"meet@gmail.com","patel"}
										
				};
			
		}
		
		
		
		}
