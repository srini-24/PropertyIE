package com.rentproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PropertyIE {
	
	public static void main(String[] args) throws InterruptedException{
		
		 boolean status=false;
		 String url="https://www.property.ie/";
		 By tolet=By.xpath("//div[contains(@id,'property_to_let')]//a");
		 By accept=By.xpath("//button[contains(text(),'Acce')]");
		 
		 
		 System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_115.exe");
		 WebDriver driver=new ChromeDriver();
		 
		 driver.get(url);
		 Thread.sleep(3000);
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(accept).click();
		 Thread.sleep(3000);
		 driver.findElement(tolet).click();
		 Thread.sleep(2000);
		 SearchBox2(driver, "4411", "200", "2500");
		 
		 int size=driver.findElements(By.xpath("//div[contains(@class,'search_result')]")).size();
		 System.out.println(size);
		 driver.findElement(By.xpath("//div[contains(@class,'search_result')][1]//div[contains(@class,'sresult_address')]//a")).click();
		 driver.navigate().refresh();
		 driver.findElement(By.xpath("//div[contains(@class,'search_result')][1]//div[contains(@class,'sresult_address')]//a")).click();
		 EmailAgent(driver, "Vina", "ie.futurehomes@gmail.com","+3538444444");
		 driver.navigate().back();
		 for(int i=2;i<=size;i++){
			 ScrollUpDown(driver, By.xpath("//div[contains(@class,'search_result')]["+i+"]//div[contains(@class,'sresult_address')]//a"));
			 driver.findElement(By.xpath("//div[contains(@class,'search_result')]["+i+"]//div[contains(@class,'sresult_address')]//a")).click();
			 EmailAgent(driver, "Vina", "ie.futurehomes@gmail.com","+3538444444");
			 driver.navigate().back();
		 }
		
	}
	
	public static boolean ScrollUpDown(WebDriver driver,By ele){
		try{
			Thread.sleep(1000);
			WebElement element=driver.findElement(ele);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(ele).isDisplayed();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean SearchBox(WebDriver driver,String county,String area,String minprice,String maxprice){
		try{
			
			By search_btn=By.xpath("//input[contains(@name,'submit')]");
			
			Thread.sleep(1000);
			WebElement tstdropdown=driver.findElement(By.id("county"));
			Select dropdwn=new Select(tstdropdown);
			dropdwn.selectByVisibleText(county);
			
			WebElement tstdrpdwn1=driver.findElement(By.id("area"));
			Select drpdwn1=new Select(tstdrpdwn1);
			drpdwn1.selectByVisibleText(area);
			
			WebElement tstdrpdwn2=driver.findElement(By.id("min_price"));
			Select drpdwn2=new Select(tstdrpdwn2);
			drpdwn2.selectByValue(minprice);
			
			WebElement tstdrpdwn3=driver.findElement(By.id("max_price"));
			Select drpdwn3=new Select(tstdrpdwn3);
			drpdwn3.selectByValue(maxprice);
			
			Thread.sleep(2000);
			driver.findElement(search_btn).click();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean EmailAgent(WebDriver driver,String name,String email,String contact){
		By emailagent=By.xpath("//a//span[contains(text(),'Ema')]");
		By name_loc=By.xpath("//input[contains(@id,'name')]");
		By email_loc=By.xpath("//input[contains(@id,'email')]");
		By contact_number=By.xpath("//input[contains(@id,'contact_number')]");
		By contact_text=By.xpath("//textarea[contains(@id,'contact_textarea')]");
		By terms=By.xpath("//input[contains(@type,'checkbox')]");
		By emailagent_btn=By.xpath("//input[contains(@type,'submit')]");
		try{
			Thread.sleep(1000);
			//driver.findElement(emailagent).click();
			Thread.sleep(1000);
			ScrollUpDown(driver, name_loc);
			driver.findElement(name_loc).sendKeys(name);
			Thread.sleep(1000);
			ScrollUpDown(driver, email_loc);
			driver.findElement(email_loc).sendKeys(email);
			Thread.sleep(1000);
			ScrollUpDown(driver, contact_number);
			driver.findElement(contact_number).sendKeys(contact);
			Thread.sleep(1000);
			ScrollUpDown(driver, contact_text);
			driver.findElement(contact_text).sendKeys("Hello ," + '\n' + " Me ad my fiancé are looking for a permanent accommodation." + '\n' + " We came across your advertisement and we are very much interested in renting it." + '\n' + " We both are full time working professionals earning more than 70000+ euros yearly and can provide pay slips and references." + '\n' + " We are clean, peaceful, vegetarian, non party and non smokers. " + '\n' + " We don’t have pets with us. We maintain the cleanliness standard of the house. " + '\n' + " I would like to know if there is any possibility that we can have a viewing. " + '\n' + " We can move in immediately as well. " + '\n' + " Thank you," + '\n' + " Vina");
			Thread.sleep(1000);
			ScrollUpDown(driver, terms);
			driver.findElement(terms).click();
			Thread.sleep(1000);
			ScrollUpDown(driver, emailagent_btn);
			driver.findElement(emailagent_btn).click();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean SearchBox2(WebDriver driver,String area,String minprice,String maxprice){
		try{
			
			By search_btn=By.xpath("//input[contains(@name,'submit')]");
			
			Thread.sleep(1000);
//			WebElement tstdropdown=driver.findElement(By.id("county"));
//			Select dropdwn=new Select(tstdropdown);
//			dropdwn.selectByVisibleText(county);
			
			WebElement tstdrpdwn1=driver.findElement(By.id("area"));
			Select drpdwn1=new Select(tstdrpdwn1);
			drpdwn1.selectByValue(area);
			
			WebElement tstdrpdwn2=driver.findElement(By.id("min_price"));
			Select drpdwn2=new Select(tstdrpdwn2);
			drpdwn2.selectByValue(minprice);
			
			WebElement tstdrpdwn3=driver.findElement(By.id("max_price"));
			Select drpdwn3=new Select(tstdrpdwn3);
			drpdwn3.selectByValue(maxprice);
			
			Thread.sleep(2000);
			driver.findElement(search_btn).click();
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
