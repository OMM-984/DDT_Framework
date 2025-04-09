package commonfunction;

import org.openqa.selenium.By;

import utill.apputill;

public class FunctionLibary extends apputill {
	public void adminlogin(String user , String pass) {
		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("ObjPass"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
		
		
	}
	public boolean isadmindisplayed() {
		if(driver.findElement(By.xpath(conpro.getProperty("ObjAdmin"))).isDisplayed()){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean iserrormessagedisplayed() {
		String Error_mess = driver.findElement(By.xpath(conpro.getProperty("ObjError"))).getText().toLowerCase();
		if(Error_mess.contains("invalid")|| Error_mess.contains("empty")){
			return true;
		}
		else {
			return false;
		}

	}
	public void adminlogout() {
		driver.findElement(By.xpath(conpro.getProperty("ObjWelcome"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjLogout"))).click();
		
	}
	

}
