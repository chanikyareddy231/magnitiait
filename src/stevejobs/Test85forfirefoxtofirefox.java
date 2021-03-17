package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test85forfirefoxtofirefox {

	public static void main(String[] args) throws Exception
	{
		///open browser(browser opens without any history and cookies by default)
		System.setProperty("webdriver.gecko.driver","C:\\mahesh\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	    FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("chanikyareddy231");
		//fill user id and password
		driver.findElement(By.xpath("//button[@type='button']/child::div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Chanikya231");
	    driver.findElement(By.xpath("//div[@id='passwordNext']/descendant::div[3]")).click();
	    Thread.sleep(5000);
        //Take new window in same browser and switch it
		//new window can access existing cookies in that browser
		driver.switchTo().newWindow(WindowType.WINDOW);
	    Set<String> w=driver.getWindowHandles();
	    ArrayList<String> wa=new ArrayList<String>(w);
	    driver.switchTo().window(wa.get(1));
	    driver.get("http://gmail.com"); //it is the super domain
	    driver.manage().window().maximize();
		Thread.sleep(5000);
		try
		{
		if(driver.findElement(By.xpath("//div[@gh='cm']")).isDisplayed())
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
