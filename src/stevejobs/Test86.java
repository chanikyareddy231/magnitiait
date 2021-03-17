package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test86 {

	public static void main(String[] args) throws Exception
	{
		//open browser(browser opens without any history and cookies by default)
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Launch site(no super domain) and do login via from filling
		driver.get("http://expenseus.com"); //it is the super domain
		Thread.sleep(5000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user[email]")).sendKeys("chanikyareddy231@gmail.com");
		driver.findElement(By.name("user[password]")).sendKeys("Chanikya231");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		Thread.sleep(5000);
		Cookie ck=driver.manage().getCookieNamed("PHPSESSID");
		//Take new window in other browser and switch it
		//new window can access existing cookies in that browser
		//so , we need to add sesssion cookie ti that new browser window
		System.setProperty("webdriver.gecko.driver","C:\\mahesh\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	    FirefoxDriver driver2=new FirefoxDriver();
		//launch same site and aviod te-login via session cookie
	    driver2.get("http://expenseus.com"); //it is the super domain
	    Thread.sleep(5000);
	    driver2.manage().addCookie(ck);
	    driver2.navigate().refresh();
	    //launch same site and avoid re-login via session cookie
		Thread.sleep(5000);
		try
		{
		if(driver2.findElement(By.linkText("Logout")).isDisplayed())
		{
			System.out.println("Session cookie test passed");
		}
		else
		{
			System.out.println("Session cookie test failed");
		}
		}
	    catch(Exception ex)
	    {
	    	System.out.println("Session cookie test failed");
	    }
		
		//close site 
		driver2.close();
		//close site
		driver.close();

	}

}
