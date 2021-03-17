package stevejobs;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test83 {

	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://expenseus.com"); //it is super domain
		Thread.sleep(5000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user[email]")).sendKeys("chanikyareddy231@gmail.com");
		driver.findElement(By.name("user[password]")).sendKeys("Chanikya231");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		//seqential collection
	    Set<Cookie> s=driver.manage().getCookies();
		System.out.println("Count of cookies before Launch site" +s.size());
		for(Cookie c:s)
		{
			if(c.isHttpOnly())
			{
				System.out.println(c.getName()+ "is Http only");
			}
			else if (c.isSecure())
			{
				//when protocal is https
				if(c.getName().equalsIgnoreCase("session-Id")||c.getName().contains("SESSID"))
				{
					System.out.println(c.getName()+ "is session cookie");
				}
				else if (c.getName().equalsIgnoreCase("session-id-time"))
				{
					System.out.println(c.getName()+ "is persistent cookie");
					System.out.println("it can expire on "+c.getExpiry());
				}
				else
				{
					System.out.println(c.getName()+ "is secure cookie only");
				}
			}
			else if(c.getName().equalsIgnoreCase("session-Id")||c.getName().contains("SESSID"))
			{
				System.out.println(c.getName()+ "is session cookie");
			}
			else if (c.getName().equalsIgnoreCase("session-id-time"))
			{
				System.out.println(c.getName()+ "is persistent cookie");
				System.out.println("it can expire on "+c.getExpiry());
			}
			else if (c.getDomain().contains("expenseus.com"))		
			{
				System.out.println(c.getName()+ "is a same site cookie");
			}
			else 
			{
				System.out.println(c.getName()+ "is a Third-party cookie");
			}
		}
		//close site
		driver.close();
	}

}
