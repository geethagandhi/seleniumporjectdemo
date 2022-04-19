package TestNGRedmine;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ObjectRepro;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
//import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNGScripts {
	
	static ChromeDriver driver = null;
	//static FirefoxDriver driver1 = null;
	@Parameters({"URL"})
	@BeforeTest
	
	public void chromesite(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		

	@Test
	
	void RegisterPage()
			throws InterruptedException, IOException {

		String expMsg = "Your account has been activated. You can now log in.";
		// clicking Register Button
				
		ObjectRepro obrep = new ObjectRepro();
		/*
		//to access excel data from Test-data2.xlsx
		Properties prop = new Properties();
		File file = new File("C:\\Users\\Geetha\\eclipse-workspace\\TestNGProject\\DataFolder\\Test-data2.xlsx");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);*/
	

		TestNGScripts.driver.findElement(By.xpath(obrep.regis)).click();
		Thread.sleep(2000);

		// Giving info to register

		TestNGScripts.driver.findElement(By.xpath(obrep.login)).sendKeys("Geetha24");
		//TestNGScripts.driver.findElement(By.xpath(obrep.login)).sendKeys(prop.getProperty(expMsg));

		TestNGScripts.driver.findElement(By.xpath(obrep.passw)).sendKeys("11984");

		TestNGScripts.driver.findElement(By.xpath(obrep.conpassw)).sendKeys("11984");

		TestNGScripts.driver.findElement(By.xpath(obrep.firname)).sendKeys("Geetha24");

		TestNGScripts.driver.findElement(By.xpath(obrep.lasname)).sendKeys("Dhanda24");

		TestNGScripts.driver.findElement(By.xpath(obrep.email)).sendKeys("Gee134@xyz.com");

		// dropdown access
		WebElement lang = TestNGScripts.driver.findElement(By.xpath(obrep.lang));
		Select lang1 = new Select(lang);
		lang1.selectByValue("en-GB");
		Thread.sleep(2000);

		TestNGScripts.driver.findElement(By.xpath(obrep.submit)).click();
		Thread.sleep(3000);
		String actualMsg = TestNGScripts.driver.findElement(By.xpath(obrep.Message)).getText();
		if (expMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Verify the Registration with correct Test Data Passed");

			TestNGScripts.driver.findElement(By.xpath(obrep.singout)).click();

			Thread.sleep(2000);
		}

	}

	@AfterTest
	public void appclose() {
		
		TestNGScripts.driver.quit();
		
	}
	
	

}

