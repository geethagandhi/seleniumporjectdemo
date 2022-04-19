package testNGProject;

import java.io.IOException;
import java.time.Duration;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepository.TestData;
//import org.openqa.selenium.support.ui.Select;

//import objectRepository.ObjectRepro;

public class RedmineRegistration {
	
	static ChromeDriver driver = null;
		
		/*try {
			String expMsg = "You can now log in";
			//clicking Register Button
			
			driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			Thread.sleep(2000);
			
			//Giving info to register
			
			driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(login);
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("1234");
			driver.findElement(By.xpath("//input[@id='user_password_confirmation']")).sendKeys("1234");
			driver.findElement(By.xpath("//input[@id='user_firstname']")).sendKeys(firstN);
			driver.findElement(By.xpath("//input[@id='user_lastname']")).sendKeys(lastN);
			driver.findElement(By.xpath("//input[@id='user_mail']")).sendKeys(email);
			WebElement lang = driver.findElement(By.xpath("//select[@id='user_language']"));
			Select lang1 = new Select(lang);
			lang1.selectByValue("en-GB");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value ='Submit']")).click();
			Thread.sleep(3000);
			String actualMsg = driver.findElement(By.xpath("//div[@id='flash_notice']")).getText();
			if(expMsg.equalsIgnoreCase(actualMsg))
			{
				System.out.println("Verify the Registration with correct Test Data Passed");
				driver.findElement(By.xpath("//a[@class='logout']")).click();
			}
			else
			{
				System.out.println("Verify the Registration with correct Test Data Failed");
			}
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println("First account created");
		}*/
		
		

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Geetha\\eclipse-workspace\\TestNGProject\\Drivers\\ChromeDriver\\version 99\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.redmine.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//RedmineRegistration register = new RedmineRegistration();
		RegistrationTestScripts rts = new RegistrationTestScripts();
		rts.RegisterPage(TestData.readDataExcel(3, 0),TestData.readDataExcel(3, 1),TestData.readDataExcel(3, 2),TestData.readDataExcel(3, 3),TestData.readDataExcel(3, 4),
				TestData.readDataExcel(3, 5));
		
		/*
		//using TestData class
		TestData td = new TestData();
		td.readDataExcel(0, 0);*/
		
		//rts.RegisterPage("Lakshmi16","Lakshmi" ,"Dhanda"  , "lak16@gmail.com");
		/*
		for(int i=1; i<7; i++)
		{
			register.RegisterPage("Lakshmi13"+i,"Lakshmi" +i,"Dhanda" +i , "lak13"+i+"@gmail.com");
		}*/
		
	}
System.out.println("First account created");
}
