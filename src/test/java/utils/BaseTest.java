package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;





public class BaseTest {
	protected WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
		 driver= new FirefoxDriver();
		driver.get("https://arjitnigam.github.io/myDreams/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		
		if(driver !=null) {
			driver.quit();
		}
	}

}
