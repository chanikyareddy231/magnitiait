package stevejobs;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test88 {

	public static void main(String[] args) throws Exception
	{
		Date today=new Date();
		Date tommorow= new Date(today.getTime()+(1000*60*60*24));
		//Create any type of cookie using Cookie Builder
		Cookie.Builder b=new Cookie.Builder("session-id-time","magnitia"); //Name and Value
		Cookie newcookie=b.domain("www.youtube.com").path("/").expiresOn(tommorow).isSecure(true).build();
		System.out.println("My New Cookie"+newcookie);
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//add cookie to browser
		driver.manage().addCookie(newcookie);
		//collect all loaded cookies
		Set<Cookie> s=driver.manage().getCookies();
	   	System.out.println("Count of cookies" +s.size());
	   	for(Cookie c:s)
	   	{
	   		System.out.println(c.getName()+"----"+c.getValue()+"----"+c.getDomain()+"----"+c.getExpiry());
	   	}	
	   	//close site
	   	driver.close();

	}

}
