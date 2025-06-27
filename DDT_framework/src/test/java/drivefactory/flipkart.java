package drivefactory;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement searchbox= driver.findElement(By.name("q"));
		searchbox.sendKeys("samsung a54");
		searchbox.submit();
		String mainpage =driver.getWindowHandle();
		System.out.println("Main page"+ mainpage);
		driver.findElement(By.xpath("//div[normalize-space()=\"Samsung Galaxy A54 5G (Awesome Graphite, 256 GB)\"]")).click();
        Set<String>list=driver.getWindowHandles();
        for (String string : list) {
	    System.out.println(string);
	    String title=driver.switchTo().window(string).getTitle();
	   if( title.equals(list)) {
		driver.close();
	     }
       }
	   Thread.sleep(2000);
	
	    driver.findElement(By.xpath("//button[@class=\"QqFHMw vslbG+ In9uk2\"]")).click();
		
		
		

	}

}
