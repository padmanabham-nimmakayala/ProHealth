package VerifyGUI;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import globalstructure.BrowserHandler;
import globalstructure.DashBoard;
import globalstructure.DomainValues;
import globalstructure.LoginPage;
import globalstructure.PassingPage;

public class TestCase1 extends BrowserHandler {
	@BeforeTest
	public void initialisebrowser() {
		TestCase1 frame = new TestCase1();
		frame.browser("chrome");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@Test
	public void test() throws Exception {
		InputStream file = new FileInputStream(
				"C:\\Users\\prade\\eclipse-workspace\\ProHealth\\src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(file);

		driver.navigate().to(prop.getProperty("url"));
		String expectedvalue = prop.getProperty("url1");
		String actualvalue = driver.getCurrentUrl();
		Assert.assertEquals(actualvalue, expectedvalue);
		
		driver.findElement(LoginPage.member).sendKeys(prop.getProperty("user"));
		driver.findElement(LoginPage.name).sendKeys(prop.getProperty("username"));
		driver.findElement(LoginPage.security).sendKeys(prop.getProperty("password"));
		driver.findElement(LoginPage.login).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Select dropdown1 = new Select(driver.findElement(PassingPage.hospital));
		dropdown1.selectByIndex(1);
		Select dropdown2 = new Select(driver.findElement(PassingPage.role));
		dropdown2.selectByIndex(1);
		driver.findElement(PassingPage.click).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String expectedvalue2 = prop.getProperty("url2");
		String actualvalue2 = driver.getCurrentUrl();
		Assert.assertEquals(actualvalue2, expectedvalue2);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(DashBoard.settings)).perform();

		driver.findElement(DashBoard.domainvalues).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String actualvalue3=driver.getCurrentUrl();
        String expectedvalue3=prop.getProperty("url3");
        Assert.assertEquals(actualvalue3, expectedvalue3);
        
        boolean default1=driver.findElement(DomainValues.default_button1).isDisplayed();
        Assert.assertTrue(default1);
        boolean default2=driver.findElement(DomainValues.default_button2).isDisplayed();
        Assert.assertTrue(default2);
        
       List<WebElement> list= driver.findElements(DomainValues.fulllist);
		int size=list.size();
		for(int i=1;i<=size;i++) {
			boolean value=driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/ul/li["+i+"]")).isDisplayed();
			Assert.assertTrue(value);
		}
		for(int i=1;i<=size;i++) {
			driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/ul/li["+i+"]")).click();
			JavascriptExecutor js;

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,50)", "");
			try {
				driver.findElement(DomainValues.error_message).click();
			}catch(Exception e){
				
				
			}
}
		
		}   
}