package globalstructure;

import org.openqa.selenium.By;

public class PassingPage extends BrowserHandler {
	public static By role=By.xpath("//select[contains(@name,'roles')]");
	public static By hospital=By.name("facility");
	public static By click=By.xpath("//button[contains(@class,'btn btn-primary')]");

}
