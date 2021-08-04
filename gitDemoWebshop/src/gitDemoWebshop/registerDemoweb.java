package gitDemoWebshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class registerDemoweb {
	WebDriver driver;
	Properties pro = new Properties();
	static Logger log = Logger.getLogger(registerDemoweb.class.getName());

	@BeforeSuite
	public void openbrowser() throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\CJC\\Testing\\gitDemoWebshop\\src\\gitDemoWebshop\\registerproperties");
		pro.load(fis);

		System.out.println("open browser");
		System.out.println("URL:" + pro.getProperty("url"));
		System.setProperty("webdriver.chrome.driver", "D:\\CJC\\TestingData\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("open browser successfully");
	}

	@BeforeTest
	public void enterurl() {
		System.out.println("enter url");
		driver.get(pro.getProperty("url"));
	}

	@BeforeClass
	public void maximizebrowser() {
		driver.manage().window().maximize();
	}

	@Test
	public void logintest() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='gender-female']")).click();

		WebElement Fname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		Fname.sendKeys(pro.getProperty("Fname"));

		WebElement Lname = driver.findElement(By.xpath("//div/child::input[@id='LastName']"));
		Lname.sendKeys(pro.getProperty("Lname"));

		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(pro.getProperty("email"));

		WebElement pass = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/input"));
		pass.sendKeys(pro.getProperty("pass"));

		WebElement Cpass = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
		Cpass.sendKeys(pro.getProperty("cpass"));
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		log.debug("DEBU");
		log.info("INFO");
		log.warn("WARN");
		log.error("error");
		log.fatal("FATAL");
		System.out.println("hello");

	}

@Test
public void exit() throws InterruptedException{
Thread.sleep(3000);
	driver.quit();
}
}
