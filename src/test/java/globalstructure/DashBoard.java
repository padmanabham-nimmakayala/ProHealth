package globalstructure;

import org.openqa.selenium.By;

public class DashBoard extends BrowserHandler {
	public static By settings=By.xpath("//*[@id=\"mySidenav\"]/ul/li[5]");
	public static By domainvalues=By.xpath("//a[@href='/DomainValues'][contains(.,'Domain Values')]");
	

}
