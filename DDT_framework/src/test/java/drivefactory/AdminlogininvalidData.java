package drivefactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonfunction.FunctionLibary;
import utill.ExcelFileUtil;
import utill.apputill;

public class AdminlogininvalidData extends apputill{
	String inputpath="./fileinput/input data.xlsx";
	String outputpath="./fileoupt/invalidlogindata.xlsx ";
	ExtentReports reports;
	ExtentTest logger;
	String TCsheet ="invalid";
	@Test
	public void starttest()throws Throwable {
		reports=new ExtentReports("./target/invaliddata.html");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl.rowCount(TCsheet);
		Reporter.log("no of rows are::"+rc,true);
		for(int i=1; i<=rc;i++) {
			logger = reports.startTest("invalid login data");
			logger.assignAuthor("omm");
			logger.assignCategory(" invalid login data");
			String user = xl.getCellData(TCsheet, i, 0);
			String pass = xl.getCellData(TCsheet, i,1);
			FunctionLibary lp = new FunctionLibary();
			lp.adminlogin(user, pass);
			boolean res= lp.iserrormessagedisplayed();
			if(res) {
				xl.setCellData(pass, rc, 2, "pass", outputpath);
				logger.log(LogStatus.PASS, "invalid credentials");
			}
			else {
				xl.setCellData(pass, i, 2, "fail", outputpath);
				logger.log(LogStatus.FAIL, "valid credintials");
			}
			reports.endTest(logger);
			reports.flush();
		}
	}
	

}
