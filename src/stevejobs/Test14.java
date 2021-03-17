package stevejobs;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome" driver" as per "chrome" version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml_link_target");
		Thread.sleep(5000);
		//click on a link
		driver.switchTo().frame("iframeResult");
	    driver.findElement(By.partialLinkText("Visit W3")).click();
		Thread.sleep(5000);
		Set<String> x=driver.getWindowHandles();
		System.out.println(x);
		//close all browser tabs
		driver.quit();

	}

}
