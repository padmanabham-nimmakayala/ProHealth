package globalstructure;

import org.openqa.selenium.By;

public class AdjustmentType extends BrowserHandler {
	
	public static By expand=By.xpath("//button[contains(.,'Adjustment Type')]");
	public static By webtable=By.xpath("//*[@id=\"main\"]/div[2]/div[3]/div[2]/table");
	public static By webtablerows=By.xpath(" //*[@id=\"main\"]/div[2]/div[3]/div[2]/table/tbody/tr");
	public static By webtablecolumns =By.xpath(" //*[@id=\"main\"]/div[2]/div[3]/div[2]/table/thead/tr/th");
    
    
}
