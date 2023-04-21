package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBBranchUpdation {
	WebDriver driver;
	public PBBranchUpdation(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy (xpath = "(//img)[10]")
	WebElement clickedit;
	@FindBy (xpath = "//input[@id='txtbnameU']")
	WebElement enterbranch;
	@FindBy (id = "txtadd1u")
	WebElement enteraddress;
	@FindBy (xpath = "//input[@id='txtareaU']")
	WebElement enterarea;
	@FindBy (xpath = "//input[@id='txtzipu']")
	WebElement enterzipcode;
	@FindBy (xpath = "//input[@id='btnupdate']")
	WebElement clickupdate;
	public boolean verify_updatebranch(String branch,String address,String area,String zipcode) throws Throwable
	{
		this.clickedit.click();
		this.enterbranch.clear();
		this.enterbranch.sendKeys(branch);
		this.enteraddress.clear();
		this.enteraddress.sendKeys(address);
		this.enterarea.clear();
		this.enterarea.sendKeys(area);
		this.enterzipcode.clear();
		this.enterzipcode.sendKeys(zipcode);
		this.clickupdate.click();
		String Expectedalert = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String Actualalert = "Branch updated";
		if (Expectedalert.toLowerCase().contains(Actualalert.toLowerCase()))
		{
			Reporter.log(Expectedalert,true);
			return true;
		}
		else
		{
			Reporter.log("unable to update branch",true);
			return false;
		}

	}
	
		
	}
	
		
	



