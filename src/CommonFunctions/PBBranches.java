package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBBranches {
	@FindBy (xpath = "(//img)[5]")
	WebElement clickbranches;
	public void branchesclick()
	{
		clickbranches.click();

	}
}
