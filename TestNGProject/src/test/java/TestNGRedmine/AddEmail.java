package TestNGRedmine;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ObjectRepro;

public class AddEmail {
	ObjectRepro obrep = new ObjectRepro();

	static ChromeDriver driver = null;

	String accchanexpmsg = "Account was successfully updated.";
	@Parameters({"URL"})
	@BeforeClass

	public void chromesite(String url) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void logincorrectdata() throws InterruptedException {
		AddEmail.driver.findElement(By.xpath(obrep.signinp)).click();
		AddEmail.driver.findElement(By.xpath(obrep.loginp)).sendKeys("Geetha24");
		AddEmail.driver.findElement(By.xpath(obrep.passp)).sendKeys("11984");
		AddEmail.driver.findElement(By.xpath(obrep.submitp)).click();
		Thread.sleep(3000);
	}

	@Test
	public void addemail() throws InterruptedException {
		AddEmail.driver.findElement(By.xpath(obrep.myacc)).click();
		Thread.sleep(2000);
		AddEmail.driver.findElement(By.xpath(obrep.emaillink)).click();
		AddEmail.driver.findElement(By.xpath(obrep.addmail)).sendKeys("Gee1499@xyz.com");
		AddEmail.driver.findElement(By.xpath(obrep.add)).click();
		AddEmail.driver.findElement(By.xpath(obrep.windowclose)).click();

	}
}
