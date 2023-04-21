package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBRoleupdation {
WebDriver driver;
public PBRoleupdation(WebDriver driver)
{
	this.driver = driver;
}
@FindBy (xpath = "(//img)[10]")
WebElement clickedit;
@FindBy (xpath = "//input[@id='txtrNameU']")
WebElement enterrolename;
@FindBy (xpath = "//input[@id='txtrdescU']")
WebElement enterroledesc;
@FindBy (xpath = "//select[@id='lstRtype']")
WebElement selectroletype ;
@FindBy (xpath = "//input[@id='btnupdate']")
WebElement clickupdate;
public boolean verify_updaterole(String rolename,String roledesc,String roletype) throws Throwable
{
	this.clickedit.click();
	this.enterrolename.clear();
	this.enterrolename.sendKeys(rolename);
	this.enterroledesc.clear();
	this.enterroledesc.sendKeys(roledesc);
	new Select (this.selectroletype).selectByVisibleText(roletype);
	this.clickupdate.click();
	Thread.sleep(3000);
	String Expectedalert = driver.switchTo().alert().getText();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	String Actualalert = "Role updated";
	if (Expectedalert.toLowerCase().contains(Actualalert.toLowerCase()))
	{
		Reporter.log(Expectedalert,true);
		return true;
	}
	else
	{
		Reporter.log("unable to updaterole",true);
		return false;
	}

}

	
}

	




