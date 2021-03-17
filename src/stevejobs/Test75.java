package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test75 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> s=driver.getWindowHandles();
		ArrayList<String> a=new ArrayList<String>(s);
		//move to second window or tab
		driver.switchTo().window(a.get(1)); //get(1) means 2nd window or tab
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//close all tabs
		driver.quit();

	}

}
