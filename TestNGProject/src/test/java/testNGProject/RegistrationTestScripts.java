package testNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import objectRepository.ObjectRepro;

public class RegistrationTestScripts {
	//static ChromeDriver driver = null;

	void RegisterPage(String login, String pw, String cpw, String firstN,String lastN, String email) throws InterruptedException {
	
	String expMsg = "Your account has been activated. You can now log in.";
	//clicking Register Button
	
	
	ObjectRepro obrep = new ObjectRepro();
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.regis)).click();
	Thread.sleep(2000);
	
	//Giving info to register
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.login)).sendKeys(login);
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.passw)).sendKeys(pw);
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.conpassw)).sendKeys(cpw);
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.firname)).sendKeys(firstN);
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.lasname)).sendKeys(lastN);
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.email)).sendKeys(email);
	
	//dropdown access
	WebElement lang = RedmineRegistration.driver.findElement(By.xpath(obrep.lang));
	Select lang1 = new Select(lang);
	lang1.selectByValue("en-GB");
	Thread.sleep(2000);
	
	RedmineRegistration.driver.findElement(By.xpath(obrep.submit)).click();
	Thread.sleep(3000);
	String actualMsg = RedmineRegistration.driver.findElement(By.xpath(obrep.Message)).getText();
	if(expMsg.equalsIgnoreCase(actualMsg))
	{
		System.out.println("Verify the Registration with correct Test Data Passed");
		
		//RedmineRegistration.driver.findElement(By.xpath(obrep.singout)).click();
		
		Thread.sleep(2000);
	}
	
}

}
