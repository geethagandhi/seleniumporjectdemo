package TestNGRedmine;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ObjectRepro;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninPage {
	
	//Logger log = LogManager.getLogger(SigninPage.class.getName());
	
	static ChromeDriver driver = null;
	String fexmsg = "Invalid user or passwordA";
	String expsuccemailmsg = "An email with instructions to choose a new password has been sent to youABC.";
	
	@Parameters({"URL"})
	@BeforeClass

	public void chromesite(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		//log.debug("Website Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void wrongusername() throws InterruptedException {
		ObjectRepro obrep = new ObjectRepro();
		Thread.sleep(2000);
		SigninPage.driver.findElement(By.xpath(obrep.signinp)).click();
		SigninPage.driver.findElement(By.xpath(obrep.loginp)).sendKeys("Geetha96");
		SigninPage.driver.findElement(By.xpath(obrep.passp)).sendKeys("907789");
		SigninPage.driver.findElement(By.xpath(obrep.loginbutton)).click();
		String flashmsg = SigninPage.driver.findElement(By.xpath(obrep.fmsg)).getText();
		if (flashmsg.equalsIgnoreCase(fexmsg)) {
			//log.info("Login failed with invalid user or password");
			//System.out.println("Login failed with invalid user or password");
		}
		//Thread.sleep(3000);
	}
/*
	@Test(priority = 2)
	public void wrongpassword() throws InterruptedException {
		ObjectRepro obrep = new ObjectRepro();

		SigninPage.driver.findElement(By.xpath(obrep.signinp)).click();
		SigninPage.driver.findElement(By.xpath(obrep.loginp)).sendKeys("Geetha22");
		SigninPage.driver.findElement(By.xpath(obrep.passp)).sendKeys("907782");
		SigninPage.driver.findElement(By.xpath(obrep.loginbutton)).click();
		String flashmsg = SigninPage.driver.findElement(By.xpath(obrep.fmsg)).getText();
		if (flashmsg.equalsIgnoreCase(fexmsg)) {
			System.out.println("Login failed with invalid user or password");
		}
		//Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void lostpassword() throws InterruptedException {
		ObjectRepro obrep = new ObjectRepro();

		SigninPage.driver.findElement(By.xpath(obrep.signinp)).click();
		SigninPage.driver.findElement(By.xpath(obrep.loginp)).sendKeys("Geetha1004");
		// SigninPage.driver.findElement(By.xpath(obrep.passp)).sendKeys("907782");
		SigninPage.driver.findElement(By.xpath(obrep.lostpwd)).click();
		SigninPage.driver.findElement(By.xpath(obrep.mail)).sendKeys("geetha_dhanda@hotmail.com");
		SigninPage.driver.findElement(By.xpath(obrep.sub)).click();
		
		Thread.sleep(3000);
		String actsuccmailmsg = SigninPage.driver.findElement(By.xpath(obrep.successmsg)).getText();
		if (actsuccmailmsg.equalsIgnoreCase(expsuccemailmsg)) {
			System.out.println("Email sent to new password");
		}
		
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void logincorrectdata() throws InterruptedException {
		ObjectRepro obrep = new ObjectRepro();

		SigninPage.driver.findElement(By.xpath(obrep.signinp)).click();
		//Thread.sleep(2000);
		SigninPage.driver.findElement(By.xpath(obrep.loginp)).sendKeys("Geetha23");
		SigninPage.driver.findElement(By.xpath(obrep.passp)).sendKeys("17058");
		SigninPage.driver.findElement(By.xpath(obrep.loginbutton)).click();
		SigninPage.driver.findElement(By.xpath(obrep.singout)).click();
		Thread.sleep(3000);
	}*/

	@AfterClass
	public void appclose() {
		
		SigninPage.driver.close();
		//log.debug("Website Closed");

	}

}
