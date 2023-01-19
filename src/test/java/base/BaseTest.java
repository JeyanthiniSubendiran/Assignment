package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
//base class, mainly driver initialization
public class BaseTest {
//define and initialize global variables.
	public static WebDriver driver;
	public static FileReader fr;
	public static Properties prop = new Properties();

	//before run testcases this method should be run.
	@BeforeTest
	public void setUp() throws IOException {
		//read and the load property files to configure properties
		if (driver == null) {
			fr = new FileReader(
					"E:\\ElipseAssignments\\AssignmentThilini\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);

		}
		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}

	}
	
	/*after run testcases close the driver, this method 
	can be run after tesecases
	*/

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Successfully launched!");
	}

}
