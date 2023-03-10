package com.java.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsTest {

	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Bridgelabz Program\\TestingAPI\\Selenium-Automation-Projects\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void findElements_ExampleTest() {
		driver.get("https://demo.actitime.com/login.do");
		//findElements() method returns list of web element
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//get the total number of link elements int totalLinks
		int totalLinks = allLinks.size();
		System.out.println("total number of links present on the web page is : "+totalLinks); 
		int visibleLinkCount = 0; 
		int hiddenLinkCount = 0;
		//using foreach loop, iterate through all the links 
		for (WebElement link : allLinks) { 
			//if the link is displayed, then print the text of the link 
			if (link.isDisplayed()) {
				visibleLinkCount++; 
			System.out.println(visibleLinkCount+" --> "+link.getText());
		}else{
			hiddenLinkCount++;
			} 
		}
		System.out.println("Total number of visible links :" + visibleLinkCount); 
		System.out.println("Total number of hidden links :" + hiddenLinkCount);
		//driver.close();
	}
}
