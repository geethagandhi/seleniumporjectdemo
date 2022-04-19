package TestNGRedmine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ObjectRepro;

public class RegisterUsingDBData {
	static ChromeDriver driver = null;
	ObjectRepro obrep = new ObjectRepro();
	String expMsg = "Your account has been activated. You can now log in.";

	// @Parameters({"URL"})
	@BeforeTest

	public void chromesite() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.redmine.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		/*
		 * //Finding broken links in the site List<WebElement> links =
		 * driver.findElements(By.tagName("a")); for(WebElement link : links) { String
		 * url1 = link.getAttribute("href");
		 * 
		 * System.out.println("---------");
		 * 
		 * System.out.print(url1);
		 * 
		 * if(url1==null || url1.isEmpty()) { System.out.println("URL is Empty");
		 * continue;
		 * 
		 * }else { System.out.println("URL is not Empty"); }
		 * 
		 * try { HttpURLConnection http = (HttpURLConnection)(new
		 * URL(url1).openConnection());
		 * 
		 * http.connect();
		 * 
		 * if(http.getResponseCode()>=400){ System.out.println(url1 + "is Broken");
		 * }else { System.out.println(url1 +"is valid"); }
		 * 
		 * 
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } } driver.quit();
		 */
	}

	@Test
	public void Registration() throws SQLException, InterruptedException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/redmineregistration", "root",
				"root");

		Statement statement = connection.createStatement();

		ResultSet fields = statement.executeQuery("select * from registrationfields");

		while (fields.next()) {

			driver.findElement(By.xpath(obrep.regis)).click();

			Thread.sleep(3000);

			driver.findElement(By.xpath(obrep.login)).sendKeys(fields.getString("login"));

			driver.findElement(By.xpath(obrep.passw)).sendKeys(fields.getString("Password"));

			driver.findElement(By.xpath(obrep.conpassw)).sendKeys(fields.getString("ConfirmedPassword"));

			driver.findElement(By.xpath(obrep.firname)).sendKeys(fields.getString("FirstName"));

			driver.findElement(By.xpath(obrep.lasname)).sendKeys(fields.getString("LastName"));

			driver.findElement(By.xpath(obrep.email)).sendKeys(fields.getString("Email"));

			WebElement lang = driver.findElement(By.xpath(obrep.lang));
			Select lang1 = new Select(lang);
			lang1.selectByValue("en-GB");

			driver.findElement(By.xpath(obrep.submit)).click();
			Thread.sleep(3000);

			String actualMsg = driver.findElement(By.xpath(obrep.Message)).getText();
			if (expMsg.equalsIgnoreCase(actualMsg)) {
				System.out.println("Registration Sucess");
				driver.findElement(By.xpath(obrep.singout)).click();
				Thread.sleep(3000);
			}

		}

	}

}
