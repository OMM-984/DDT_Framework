package utill;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class apputill {
	public static WebDriver driver;
	public static Properties conpro;
	@BeforeMethod
	public void setup()throws Throwable {
		conpro = new Properties();
		conpro.load(new FileInputStream("./propertyfile/enviorment.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
		}
		else if (conpro.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		else {
			throw new IllegalArgumentException("browser value not matching");
		}
	}
	@AfterMethod
	public static void teardown() {
		driver.quit();
	}

}
