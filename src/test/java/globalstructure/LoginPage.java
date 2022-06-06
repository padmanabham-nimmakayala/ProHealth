package globalstructure;

import org.openqa.selenium.By;

public class LoginPage extends BrowserHandler {
	public static By member=By.xpath("//input[contains(@name,'practice')]");
	public static By name=By.xpath("//input[contains(@name,'email')]");
	public static By security=By.name("password");
	public static By login =By.xpath("//button[contains(@type,'submit')]");

}
