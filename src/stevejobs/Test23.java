package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test23 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/"+"explicit-show-hide/defaultcs.aspx");
		Thread.sleep(5000);
		//click on an element which is covered by other element like banner successfully working
		driver.findElement(By.linkText("1")).sendKeys(Keys.ENTER);

	}

}
