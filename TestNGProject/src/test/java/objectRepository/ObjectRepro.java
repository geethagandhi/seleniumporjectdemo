package objectRepository;

public class ObjectRepro {

	//Redmine Registration
	
	public String regis = "//a[contains(text(),'Register')]";
	public String login = "//input[@id='user_login']";
	public String passw = "//input[@id='user_password']";
	public String conpassw = "//input[@id='user_password_confirmation']";
	public String firname = "//input[@id='user_firstname']";
	public String lasname = "//input[@id='user_lastname']";
	public String email = "//input[@id='user_mail']";
	public String lang = "//select[@id='user_language']";
	public String submit = "//input[@value ='Submit']";
	public String Message = "//div[@id='flash_notice']";
	public String singout = "//a[contains(text(),'Sign out')]";

	
	//Login Page
	public String signinp = "//a[@class='login']";
	public String loginp = "//input[@id='username']";
	public String passp = "//input[@id='password']";
	public String loginbutton = "//input[@name='login']";
	public String submitp = "//input[@type='submit']";
	public String fmsg = "//div[@id='flash_error']";
	public String lostpwd = "//a[contains(text(),'Lost password')]";
	public String mail = "//input[@id='mail']";
	public String sub = "//input[@type='submit']";
	public String successmsg = "//div[@id='flash_notice']";
	
	
	//account change
	public String myacc = "//a[@class='my-account']";
	public String accfir= "//input[@id='user_firstname']";
	public String acclas = "//input[@id='user_lastname']";
	public String accemail = "//input[@id='user_mail']";
	public String asave = "//input[@type='submit']";
	public String acsuccmsg = "//div[@id='flash_notice']";
	
	//add more email
	
	public String emaillink = "//a[@class='icon icon-email-add']";
	public String addmail = "//input[@id='email_address_address']";
	public String add = "//input[@value='Add']";
	public String windowclose = "//button[@title='Close']";
	
}
