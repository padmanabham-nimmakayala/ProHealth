package globalstructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import VerifyGUI.TestCase1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandler {
	@BeforeTest
	public void initialisebrowser() {
		TestCase1 frame = new TestCase1();
		frame.browser("chrome");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	public static WebDriver driver;

	public void browser(String browser) {
		switch (browser) {
		case "chrome":
			System.out.println("opening in chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			System.out.println("opening in edge");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("browser not exist so opening in default browser chrome");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
	}

}
