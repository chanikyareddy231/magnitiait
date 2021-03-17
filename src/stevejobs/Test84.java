package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test84 {

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
		//Take new window in same browser and switch it
		//new window can access existing cookies in that browser
		driver.switchTo().newWindow(WindowType.WINDOW);
	    Set<String> w=driver.getWindowHandles();
	    ArrayList<String> wa=new ArrayList<String>(w);
	    driver.switchTo().window(wa.get(1));
	    driver.get("http://expenseus.com"); //it is the super domain
		Thread.sleep(5000);
		try
		{
		if(driver.findElement(By.linkText("Logout")).isDisplayed())
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
		driver.close();

	}

}
