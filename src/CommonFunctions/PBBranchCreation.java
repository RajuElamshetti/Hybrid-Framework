package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBBranchCreation {
	WebDriver driver;
	public PBBranchCreation(WebDriver a)
	{
		this.driver = a;
	}
	@FindBy (xpath = "//input[@id='BtnNewBR']")
	WebElement clicknewbranch;
	@FindBy (xpath = "//input[@id='txtbName']")
	WebElement enterbranch;
	@FindBy (xpath = "(//input[@type='text'])[2]")
	WebElement enterAddress1;
	@FindBy (xpath = "(//input[@type='text'])[3]")
	WebElement enteraddress2;
	@FindBy (xpath = "(//input[@type='text'])[4]")
	WebElement enteraddress3;
	@FindBy (xpath = "//input[@id='txtArea']")
	WebElement enterarea;
	@FindBy (xpath = "//input[@id='txtZip']")
	WebElement enterzipcode;
	@FindBy (xpath = "//select[@id='lst_counrtyU']")
	WebElement selectcountry;
	@FindBy (xpath = "//select[@id='lst_stateI']")
	WebElement selectstate;
	@FindBy (xpath = "//select[@id='lst_cityI']")
	WebElement selectcity;
	@FindBy (xpath = "//input[@id='btn_insert']")
	WebElement clicksubmit;
	public boolean verify_branchecreates(String branchname,String address1,String address2,String address3,String area,String zipcode,String country,String state,String city) throws Throwable
	{
		this.clicknewbranch.click();
		this.enterbranch.sendKeys(branchname);
		this.enterAddress1.sendKeys(address1);
		this.enteraddress2.sendKeys(address2);
		this.enteraddress3.sendKeys(address3);
		this.enterarea.sendKeys(area);
		this.enterzipcode.sendKeys(zipcode);
		new Select (this.selectcountry).selectByVisibleText(country);
		new Select (this.selectstate).selectByVisibleText(state);
		new Select (this.selectcity).selectByVisibleText(city);
		this.clicksubmit.click();
		Thread.sleep(3000);
		String Expectedalert = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String Actualalert = "New Branch with id";
		if (Expectedalert.toLowerCase().contains(Actualalert.toLowerCase()))
		{
			Reporter.log(Expectedalert,true);
			return true;
		}
		else
		{
			Reporter.log("unable to create new branch",true);
			return false;
		}
	}





}
