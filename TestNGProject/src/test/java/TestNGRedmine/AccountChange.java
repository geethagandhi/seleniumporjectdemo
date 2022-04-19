package TestNGRedmine;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ObjectRepro;

public class AccountChange {
	static ChromeDriver driver = null;
	
	String accchanexpmsg ="Account was successfully updated.";

	@BeforeClass

	public void chromesite() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.redmine.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void logincorrectdata() throws InterruptedException {
		ObjectRepro obrep = new ObjectRepro();
		AccountChange.driver.findElement(By.xpath(obrep.signinp)).click();
		AccountChange.driver.findElement(By.xpath(obrep.loginp)).sendKeys("Geetha24");
		AccountChange.driver.findElement(By.xpath(obrep.passp)).sendKeys("11984");
		AccountChange.driver.findElement(By.xpath(obrep.submitp)).click();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void acfir() throws InterruptedException {

		ObjectRepro obrep = new ObjectRepro();
		AccountChange.driver.findElement(By.xpath(obrep.myacc)).click();
		Thread.sleep(3000);
		AccountChange.driver.findElement(By.xpath(obrep.accfir)).clear();
		AccountChange.driver.findElement(By.xpath(obrep.accfir)).sendKeys("Geetha2499");
		AccountChange.driver.findElement(By.xpath(obrep.asave)).click();
		String acactusuccmsg = AccountChange.driver.findElement(By.xpath(obrep.acsuccmsg)).getText();
		if(acactusuccmsg.equalsIgnoreCase(accchanexpmsg))
		{
			System.out.println("Account updated");
		}
		AccountChange.driver.findElement(By.xpath(obrep.singout)).click();

	}
	
	@Test(priority = 2)
	public void aclast() throws InterruptedException {

		ObjectRepro obrep = new ObjectRepro();
		AccountChange.driver.findElement(By.xpath(obrep.myacc)).click();
		Thread.sleep(3000);
		AccountChange.driver.findElement(By.xpath(obrep.acclas)).clear();
		AccountChange.driver.findElement(By.xpath(obrep.acclas)).sendKeys("Dhanda2499");
		AccountChange.driver.findElement(By.xpath(obrep.asave)).click();
		String acactusuccmsg = AccountChange.driver.findElement(By.xpath(obrep.acsuccmsg)).getText();
		if(acactusuccmsg.equalsIgnoreCase(accchanexpmsg))
		{
			System.out.println("Account updated");
		}
		AccountChange.driver.findElement(By.xpath(obrep.singout)).click();

	}
	@Test(priority = 3)
	public void acemil() throws InterruptedException {

		ObjectRepro obrep = new ObjectRepro();
		AccountChange.driver.findElement(By.xpath(obrep.myacc)).click();
		Thread.sleep(3000);
		AccountChange.driver.findElement(By.xpath(obrep.accemail)).clear();
		AccountChange.driver.findElement(By.xpath(obrep.accemail)).sendKeys("Gee1499@xyz.com");
		AccountChange.driver.findElement(By.xpath(obrep.asave)).click();
		String acactusuccmsg = AccountChange.driver.findElement(By.xpath(obrep.acsuccmsg)).getText();
		if(acactusuccmsg.equalsIgnoreCase(accchanexpmsg))
		{
			System.out.println("Account updated");
		}
		AccountChange.driver.findElement(By.xpath(obrep.singout)).click();

	}
	
}
