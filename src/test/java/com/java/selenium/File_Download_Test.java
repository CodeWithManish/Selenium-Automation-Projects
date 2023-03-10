package com.java.selenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class File_Download_Test {

	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver",
				"D:\\Bridgelabz Program\\TestingAPI\\Selenium-Automation-Projects\\Drivers\\geckodriver.exe");
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver",
				"D:\\Bridgelabz Program\\TestingAPI\\Selenium-Automation-Projects\\Drivers\\chromedriver.exe");

	}

	@Test
	public void fileDownloadWithFirefox() throws InterruptedException {
		//Create an object of FirefoxProfile class
		FirefoxProfile profile = new FirefoxProfile();
		//Set the Key so that it will not show the file download pop up on the screen
		String key = "browser.helperApps.neverAsk.saveToDisk";
		//Set the type of file which you want to download
		String value = "application/zip";
		//using setPreference() method, change the setting
		profile.setPreference(key, value);
		// 0 - save to desktop, 1 - save to download folder( default), 2 - save to any other //location
		profile.setPreference("browser.download.folderList", 2);
		//save the file to the given folder location
		profile.setPreference("browser.download.dir", "C:\\Users\\kmani\\Downloads");
		//Use DesiredCapabilities class to modify the firefox settings as shown below
		DesiredCapabilities cap = new DesiredCapabilities(); 
		//cap.setCapability(FirefoxDriver.PROFILE, profile); 
		//Launch the firefox browser with the above modified settings
		driver = new FirefoxDriver(cap); 
		//Enter selenium official website url
		driver.get("http://www.seleniumhq.org/download/");
		//Use following-sibling axes in Xpath to find the download link for selenium java
		driver.findElement(By.xpath("//div[3]//div[1]//div[2]//p[2]//a[1]")).click(); 
		Thread.sleep(3000);
	}
	
	@Test
	public void FileDownload_WithChrome() throws InterruptedException {
		//Create Hashmap object and assign the profile settings
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); 
		chromePrefs.put("profile.default_content_settings.popups", 0); 
		chromePrefs.put("download.default_directory", "C:\\Users\\kmani\\Downloads\\Default Folder"); 
		//Assign this chromePrefs object with ChromeOptions object 
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("prefs", chromePrefs);
		//Create Capability object and assign the option object 
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(ChromeOptions.CAPABILITY, options); 
		driver = new ChromeDriver(cap); 
		driver.get("http://www.seleniumhq.org/download/"); 
		Thread.sleep(3000); 
		String xp = "//div[3]//div[1]//div[2]//p[2]//a[1]"; 
		driver.findElement(By.xpath(xp)).click();
		
	}
}
