package drivefactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonfunction.FunctionLibary;
import utill.ExcelFileUtil;
import utill.apputill;

public class AdminLoginValidData extends apputill{
	String inputpath="./fileinput/input data.xlsx";
	String outputpath="./fileoutput/loginresult.xlsx";
	String TCSheet = "valid";
	ExtentReports reports;
	ExtentTest logger;
	@Test
	public void starttest()throws Throwable {
		reports=new ExtentReports("./target/validdata.html");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc=xl.rowCount(TCSheet);
		Reporter.log("no of rows are::"+rc,true);
		for(int i=1;i<=rc;i++) {
			logger=reports.startTest("valid");
			String user=xl.getCellData(TCSheet, i,0);
			String pass =xl.getCellData(TCSheet, i,1);
			logger.log(LogStatus.INFO,user+"==="+ pass);
			FunctionLibary lp = new FunctionLibary();
			lp.adminlogin(user, pass);
			boolean res = lp.isadmindisplayed();
			if(res) {
				xl.setCellData(TCSheet, i, 2, "pass", outputpath);
				logger.log(LogStatus.PASS, "valid credintials");
			}
			else {
				xl.setCellData(TCSheet, i, 2, "fail", outputpath);
				logger.log(LogStatus.FAIL, "valid credintials");
			}
			reports.endTest(logger);
			reports.flush();
			lp.adminlogout();
		}
		
		
	}

}
