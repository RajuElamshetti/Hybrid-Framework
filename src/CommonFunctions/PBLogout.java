package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBLogout {
	WebDriver driver;
	public PBLogout(WebDriver a)
	{
		this.driver = a;
	}
	@FindBy (xpath = "(//img)[4]")
	WebElement clicklogout;
	@FindBy (xpath = "//input[@id='login']")
	WebElement loginbutton;
	public boolean verify_logout() throws Throwable
	{
		this.clicklogout.click();
		Thread.sleep(2000);
		if (this.loginbutton.isDisplayed())
		{
			Reporter.log("logout success",true);
			return true;
		}
		else
		{
			Reporter.log("logout fail",true);
			return false;
		}
	}
}
