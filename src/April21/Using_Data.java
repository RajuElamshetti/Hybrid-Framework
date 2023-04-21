package April21;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Using_Data {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
  @Test(dataProvider = "dp")
  public void verify_login(String user, String pass) {
	  driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.name("txtuId")).sendKeys(user);
	  driver.findElement(By.name("txtPword")).sendKeys(pass);
	  driver.findElement(By.name("login")).click();
	  String expected = "Admin home";
	  String actual = driver.getCurrentUrl();
	  if (actual.contains(expected))
	  {
		  Reporter.log("login success::"+expected+"   "+actual,true);
	  }
	  else
	  {
		  Reporter.log("login fail::"+expected+"    "+actual,true);
	
	  }
  }

  @DataProvider
  public Object[][] dp() {
	  Object login [][]= new Object[4][2];
	  login[0][0] = "Admin";
	  login[0][1] = "Admin";
	  login[1][0] = "Admin1";
	  login[1][1] = "Admin";
	  login[2][0] = "Admin";
	  login[2][1] = "Admin";
	  login[3][0] = "Admin";
	  login[3][1] = "Admin2";
	return login;
	  
   
   
  }
  

  @AfterTest
  public void teardown() {
	  driver.quit();
  }

}
