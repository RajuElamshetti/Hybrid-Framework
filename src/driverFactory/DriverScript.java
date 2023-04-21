package driverFactory;


import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonFunctions.PBBranchCreation;
import CommonFunctions.PBBranchUpdation;
import CommonFunctions.PBBranches;
import CommonFunctions.PBLogin;
import CommonFunctions.PBLogout;
import CommonFunctions.PBRoles;
import CommonFunctions.PBRolesCreation;
import CommonFunctions.PBRoleupdation;
import Config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
	String inputpath = "C:\\Automation\\Hybrid_Framework\\FileInput\\DataEngine.xlsx";
	String outputpath = "C:\\Automation\\Hybrid_Framework\\FileOuput\\Hybridresults.xlsx";
	String TCsheet = "Testcases";
	String TSsheet = "Teststeps";
	@Test
	public void starttest () throws Throwable
	{
		boolean res = false;
		String tcres = "";
		//create obj for xcel util class
		ExcelFileUtil a = new ExcelFileUtil(inputpath);
		int TCcount = a.rowcount(TCsheet);
		int TScount = a.rowcount(TSsheet);
		Reporter.log("no of rows in TCsheet::"+TCcount+"  "+"no of rows in TSsheet::"+TScount,true);
		// iterate  all rows in TCsheet
		for (int i=1;i<=TCcount;i++)
		{
			//read cell
			String Executionstatus = a.getcelldata(TCsheet, i, 2);
			if (Executionstatus.equalsIgnoreCase("Y"))
			{
				//read testcase id
				String Tcid = a.getcelldata(TCsheet, i, 0);
				//iterate all rows in TCsheet
				for (int j=1;j<=TScount;j++)
				{
					//read testcase id celldata
					String TSid = a.getcelldata(TSsheet, j, 0);
					if (Tcid.equalsIgnoreCase(TSid))
					{
						//read keyword
						String keyword = a.getcelldata(TSsheet, j, 3);
						if (keyword.equalsIgnoreCase("adminlogin"))
						{
							//call login page
							PBLogin login = PageFactory.initElements(driver, PBLogin.class);
							String para1 = a.getcelldata(TSsheet, j, 5);
							String para2 = a.getcelldata(TSsheet, j, 6);
							res = login.verify_Login(para1, para2);
						}
						else if (keyword.equalsIgnoreCase("branchcreate"))
							{
								//call branchbtn &branch createpage
								PBBranches branch = PageFactory.initElements(driver, PBBranches.class);
		                         PBBranchCreation newbranch = PageFactory.initElements(driver, PBBranchCreation.class);
								String para1 = a.getcelldata(TSsheet, j, 5);
								String para2 = a.getcelldata(TSsheet, j, 6);
								String para3 = a.getcelldata(TSsheet, j, 7);
								String para4 = a.getcelldata(TSsheet, j, 8);
								String para5 = a.getcelldata(TSsheet, j, 9);
								String para6 = a.getcelldata(TSsheet, j, 10);
								String para7 = a.getcelldata(TSsheet, j, 11);
								String para8 = a.getcelldata(TSsheet, j, 12);
								String para9 = a.getcelldata(TSsheet, j, 13);
								branch.branchesclick();
								res = newbranch.verify_branchecreates(para1, para2, para3, para4, para5, para6, para7, para8, para9);
							}
							else if (keyword.equalsIgnoreCase("branchupdate"))
								{
									PBBranches branch = PageFactory.initElements(driver, PBBranches.class);
									PBBranchUpdation branchupdate = PageFactory.initElements(driver, PBBranchUpdation.class);
									String para1 = a.getcelldata(TSsheet, j, 5);
									String para2 = a.getcelldata(TSsheet, j, 6);
									String para3 = a.getcelldata(TSsheet, j, 9);
									String para4 = a.getcelldata(TSsheet, j, 10);
									branch.branchesclick();
									res = branchupdate.verify_updatebranch(para1, para2, para3, para4);
								}
							else if (keyword.equalsIgnoreCase("rolescreation"))
							{
							PBRoles roles = PageFactory.initElements(driver, PBRoles.class);
							PBRolesCreation rolesCreation = PageFactory.initElements(driver, PBRolesCreation.class);
							String para1 = a.getcelldata(TSsheet, j, 5);
							String para2 = a.getcelldata(TSsheet, j, 6);
							String para3 = a.getcelldata(TSsheet, j, 7);
							roles.Rolesclick();
							res = rolesCreation.verify_rolecreation(para1, para2, para3);
							}
							else if (keyword.equalsIgnoreCase("roleupdation"))
							{
							PBRoles roles = PageFactory.initElements(driver, PBRoles.class);
							PBRoleupdation roleupdation = PageFactory.initElements(driver, PBRoleupdation.class);
							String para1 = a.getcelldata(TSsheet, j, 5);
							String para2 = a.getcelldata(TSsheet, j, 6);
							String para3 = a.getcelldata(TSsheet, j, 7);
							roles.Rolesclick();
							res =  roleupdation.verify_updaterole(para1, para2, para3);
 						}
								
						
							else if (keyword.equalsIgnoreCase("admin  logout"))
									{
										PBLogout logout = PageFactory.initElements(driver, PBLogout.class);
										res = logout.verify_logout();
									}									
									
							String tsres = "";
							if (res)
							{
								//if res true write pass to status cell
								tsres = "pass";
								a.setcelldata(TSsheet, j, 4, tsres, outputpath);
							}
							else
							{
								// if res false write fail to status
								tsres = "fail";
								a.setcelldata(TSsheet, j, 4, tsres, outputpath);
							}
							tcres = tsres;
						}
				}

					// write tcres to tcsheet
					a.setcelldata(TCsheet, i, 3, tcres, outputpath);
				}
			else
				{
					//write blocked in tcsheet which flag to N
					a.setcelldata(TCsheet, i, 3, "blocked", outputpath);
				}
			}  
		}
	
		
	}







