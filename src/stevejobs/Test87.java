package stevejobs;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test87 {

	public static void main(String[] args)
	{
		//open browser(browser opens without any history and cookies by default)
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.gmail.com");
		//Create secure Cookie type only and add that cookie via cookies class
		Cookie nc=new Cookie("myCookie","magnitia");
		driver.manage().addCookie(nc);
		//collect all cookies along with addes cookie
		Set<Cookie> s=driver.manage().getCookies();
	   	System.out.println("Count of cookies" +s.size());
	   	for(Cookie c:s)
	   	{
	   		System.out.println(c.getName()+"----"+c.getValue()+"----"+c.getDomain());
	   	}	
	   	//close site
	   	driver.close();
	}

}
