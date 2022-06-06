package VerifyGUI;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import globalstructure.AdjustmentType;
import globalstructure.BrowserHandler;
import globalstructure.DashBoard;
import globalstructure.LoginPage;
import globalstructure.PassingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 extends BrowserHandler {
	@BeforeTest
	public void initialisebrowser() {
		TestCase2 frame = new TestCase2();
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
		String actualvalue3 = driver.getCurrentUrl();
		String expectedvalue3 = prop.getProperty("url3");
		Assert.assertEquals(actualvalue3, expectedvalue3);

		driver.findElement(AdjustmentType.expand).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement table = driver.findElement(AdjustmentType.webtable);

		boolean tab = driver.findElement(AdjustmentType.webtable).isDisplayed();
		Assert.assertTrue(tab);

		List<WebElement> rows = table.findElements(AdjustmentType.webtablerows);
		int rowcount = rows.size();
		List<WebElement> columns = table.findElements(AdjustmentType.webtablecolumns);
		int columncount = columns.size();
		System.out.println(rowcount);
		System.out.println(columncount);

		for (int i = 0; i < 1; i++) {
			for (int j = 1; j <= columncount; j++) {
				boolean value = table
						.findElement(By.xpath(" //*[@id=\"main\"]/div[2]/div[3]/div[2]/table/thead/tr/th[" + j + "]"))
						.isDisplayed();
				Assert.assertTrue(value);
			}
		}
		for (int i = 1; i <= rowcount; i++) {
			boolean value2 = table
					.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[3]/div[2]/table/tbody/tr[" + i + "]/td[1]"))
					.isDisplayed();
			Assert.assertTrue(value2);
		}
		for (int i = 1; i <= rowcount; i++) {
			boolean value3 = table
					.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[3]/div[2]/table/tbody/tr[" + i + "]/td[3]"))
					.isDisplayed();
			Assert.assertTrue(value3);
		}
		for (int i = 1; i <= rowcount; i++) {
			boolean value4 = table
					.findElement(By
							.xpath("//*[@id=\"main\"]/div[2]/div[3]/div[2]/table/tbody/tr[" + i + "]/td[2]/div/input"))
					.isDisplayed();
			Assert.assertTrue(value4);
		}
		for (int i = 1; i <= rowcount; i++) {
			boolean value5 = table
					.findElement(
							By.xpath("//*[@id=\"main\"]/div[2]/div[3]/div[2]/table/tbody/tr[" + i + "]/td[3]/span"))
					.isDisplayed();
			Assert.assertTrue(value5);
		}
		boolean value6 = driver.findElement(AdjustmentType.addbutton).isDisplayed();
		Assert.assertTrue(value6);

	}
}