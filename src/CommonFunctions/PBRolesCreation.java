package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBRolesCreation {
WebDriver driver;
public PBRolesCreation(WebDriver b)
{
	this.driver = b;
}
@FindBy (xpath = "//input[@id='btnRoles']") 
WebElement clicknewrole;
@FindBy (xpath = "//input[@id='btnRoles']")
WebElement enterrolename;
@FindBy (xpath = "//input[@id='txtRDesc']")
WebElement enterroledesc;
@FindBy (xpath = "//select[@id='lstRtypeN']")
WebElement selectroletype;
@FindBy (xpath = "//input[@id='btninsert']")
WebElement clicksubmit;
public boolean verify_rolecreation(String rolename,String roledesc,String roletype) throws Throwable
{
	this.clicknewrole.click();
	this.enterrolename.sendKeys(rolename);
	this.enterroledesc.sendKeys(roledesc);
	new Select (this.selectroletype).selectByVisibleText(roletype);
	this.clicksubmit.click();
	String Expectedalert = driver.switchTo().alert().getText();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	String Actualalert = "New Role with";
	if (Expectedalert.toLowerCase().contains(Actualalert.toLowerCase()))
	{
		Reporter.log(Expectedalert,true);
		return true;
	}
	else
	{
		Reporter.log("unable to create new role",true);
		return false;
	}
}
}
