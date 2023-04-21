package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBRoles {
	@FindBy (xpath = "(//img)[6]")
	WebElement clickroles;
	public void Rolesclick()
	{
		clickroles.click();
	}

}
