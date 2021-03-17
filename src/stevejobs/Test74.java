package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test74 {

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
		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(5000);
		//click on "sign in" link to get new window or tab
		driver.findElement(By.partialLinkText("Sign in")).click();
		Thread.sleep(5000);
		Set<String> s=driver.getWindowHandles();
		ArrayList<String> a=new ArrayList<String>(s);
		//move to second window or tab
		driver.switchTo().window(a.get(1)); //get(1) means 2nd window or tab
		//do login
		driver.findElement(By.name("identifier")).sendKeys("chanikyareddy231");
		driver.findElement(By.xpath("//button[@type='button']/child::div[2]")).click();
		Thread.sleep(5000);
		//back to sign in window click on sign in
		driver.switchTo().window(a.get(0)); //0 means 1 st window/tab
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Sign in")).click();
		Thread.sleep(5000);
		//recollect handle values (strings) of all browser windows/tabs
		s=driver.getWindowHandles();
		a=new ArrayList<String>(s);
		driver.switchTo().window(a.get(2)); //get(2) means 3rd tab/window
		driver.findElement(By.name("identifier")).sendKeys("chanikyareddy231");
		driver.quit();
		
	}

}
