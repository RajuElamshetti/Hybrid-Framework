package Config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
	public static WebDriver driver;
	public static Properties conpro;
	@BeforeSuite
	public static void setup()throws Throwable
	{
		conpro = new Properties();
		conpro.load(new FileInputStream("C:\\Automation\\Hybrid_Framework\\PropertyFile\\Environment.properties"));
		if (conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		else
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}
	@AfterSuite
	public static void teardown()
	{
		driver.quit();
	}
}
