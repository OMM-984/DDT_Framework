package stepDefenation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SepDefenations {
	WebDriver driver;
	String empid="";
	@Given("user navigates url{string}in browser")
	public void user_navigates_url_in_browser(String string) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	   
	}

	@Then("i verify login button displayed")
	public void i_verify_login_button_displayed() {
	    if(driver.findElement(By.name("Submit")).isDisplayed()) {
//	    	System.out.println("login button displayed");
	    	Reporter.log("login button displayed",true);
	    }
	}

	@When("i enter {string} in username")
	public void i_enter_in_username(String user) {
		driver.findElement(By.name("txtUsername")).sendKeys(user);
	   
	}

	@When("i enter {string}in password")
	public void i_enter_in_password(String pass) {
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		   
	    
	}

	@When("i click login button")
	public void i_click_login_button()throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
	    
	}

	@Then("i verify url contains dashboard text")
	public void i_verify_url_contains_dashboard_text() {
	    String Excepted ="dashboard";  
	    String actual =driver.getCurrentUrl();
	    if(actual.contains(Excepted)) {
//	    	System.out.println("valid credentails");
	    	Reporter.log("valid credentalis",true);
	    }
	    else {
	    	String Error_mess=driver.findElement(By.id("spanMessage")).getText();
//	    	System.out.println(Error_mess);
	    	Reporter.log(Error_mess,true);
	    }
	    
	}

	@When("i close browser")
	public void i_close_browser() {
		driver.quit();


	}
	@When("i navigate to add employee page")
	public void i_navigate_to_add_employee_page() {
	   driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	   driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
	}

	@When("i enter as {string} in first name")
	public void i_enter_as_in_first_name(String fname) {
		driver.findElement(By.name("firstName")).sendKeys(fname);
		
	}
	    

	@When("i enter as {string} in middle name")
	public void i_enter_as_in_middle_name(String mname) {
		driver.findElement(By.name("middleName")).sendKeys(mname);
		
	    
	}

	@When("i enter as {string}in last name")
	public void i_enter_as_in_last_name(String lname) {
		driver.findElement(By.name("lastName")).sendKeys(lname);
	    
	}

	@When("i capture empid")
	public void i_capture_empid() {
	     empid= driver.findElement(By.name("employeeId")).getAttribute("value");
	}

	@When("i click save button")
	public void i_click_save_button() {
	    driver.findElement(By.id("btnSave")).click();
	}

	@When("i search employee id")
	public void i_search_employee_id()throws Throwable {
	    driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
	    driver.findElement(By.name("empsearch[id]")).sendKeys(empid);
	    driver.findElement(By.name("")).click();
	    Thread.sleep(2000);
	}

	@Then("i validate empid in table")
	public void i_validate_empid_in_table() {
		WebElement webtable=driver.findElement(By.id("resultTable"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));
		for(int i=1;i<=rows.size();i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid)) {
				Reporter.log("employee id found in table::"+empid,true);
			}
			else {
				Reporter.log("employee id not found in table::"+empid,true);
			}
		}
	    
	}




}
