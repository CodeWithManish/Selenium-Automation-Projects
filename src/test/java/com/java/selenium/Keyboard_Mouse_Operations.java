package com.java.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Keyboard_Mouse_Operations {
	
	@Test
	public void mouseAndKeyboard() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	Thread.sleep(3000);
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElement(By.name("email")).sendKeys("manish@gmail.com");
	Thread.sleep(3000);
	
	Robot robot =new Robot();
	robot.mouseMove(300, 500);
	Thread.sleep(3000);
//	robot.keyPress(KeyEvent.VK_ALT);
//	robot.keyPress(KeyEvent.VK_F);
//	robot.keyRelease(KeyEvent.VK_F);
//	robot.keyRelease(KeyEvent.VK_ALT); 
//	Thread.sleep(3000);
	
	robot.keyPress(KeyEvent.VK_W);
	Thread.sleep(3000);
	robot.keyRelease(KeyEvent.VK_W); 
	Thread.sleep(3000);
	}
}
