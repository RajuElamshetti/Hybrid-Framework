package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBLogin {
	WebDriver driver;
	public PBLogin(WebDriver a)
	{
		this.driver = a;
	}
	@FindBy(name = "txtuId")
	WebElement  enteruser;
	@FindBy(name = "txtPword")
	WebElement  enterpass;
	@FindBy(name = "login")
	WebElement clicklogin;
	public boolean verify_Login(String username,String password)
	{
		this.enteruser.sendKeys(username);
		enterpass.sendKeys(password);
		clicklogin.click();
		String Expected = "adminflow";
		String Actual = driver.getCurrentUrl();
		if(Actual.toLowerCase().contains(Expected.toLowerCase()))
		{
			Reporter.log("login success::"+Expected+"    "+Actual );
			return true;
		}
		else
		{
			Reporter.log("login fail::"+Expected+"   "+Actual);
			return false;
		}


	}
}
