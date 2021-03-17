package stevejobs;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test51 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("chanikyareddy231");
		driver.findElement(By.xpath("//button[@type='button']/child::div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Chanikya231");
	    driver.findElement(By.xpath("//div[@id='passwordNext']/descendant::div[3]")).click();
	    Thread.sleep(5000);
	    //collect all elements in that next page after sucusessful login
	    List<WebElement> l1=driver.findElements(By.xpath("(//a)|(//href)|(//script)|(//img)|(//div)|(//link)|(//base)|(//area)"));
  		System.out.println("Total count of elements is "+l1.size());
  		//collect all hyper links only,which consist of "href" attribute
  		List<WebElement> l2=new ArrayList<WebElement>();
  		for(WebElement e:l1)
  		{
  			
  			try
  			{
  			if(e.getAttribute("href")!=null)
  			{
  				String x=e.getAttribute("href");
  				if(x.startsWith("https")||x.startsWith("http"))	;
  				{
  					l2.add(e);
  				}
  			}
  			}
  			catch(StaleElementReferenceException ex)
  			{
  				 l1=driver.findElements(By.xpath("(//a)|(//href)|(//script)|(//img)|(//div)|(//link)|(//base)|(//area)"));
  			}
  			  	
  		}
  		System.out.println("Total count of hyper links  is "+l2.size());
  		//test each hyper link address for broken links
  		int clc=0;
  		int blc=0;
  		for(WebElement e:l2)
  		{
  			
  			
  			Thread.sleep(1000);
  			String x=e.getAttribute("href");
  			Thread.sleep(2000);
  			URL u=new URL(x); //consider "href" attribute value as url
  			Thread.sleep(2000);
  			//open connection to server,which addressed with that url
  			HttpURLConnection con=(HttpURLConnection) u.openConnection();
  			Thread.sleep(1000);
  			//connect(send a request)	
  			con.connect();
  			try 
  			{
  			Thread.sleep(1000);
  			//test responce
  			String y=con.getResponseMessage();
  			if(y.equalsIgnoreCase("ok"))
  			{
  				clc++;
  			}
  			else
  			{
  				blc++;
  				System.out.println(x+" return "+y);
  			}
  			con.disconnect();//optional bcz server can disconnect after sending response by default
  			}
  			catch(MalformedURLException ex)
  			{ 
  				Thread.sleep(15000);
  			}
  		}
  		System.out.println("correctly workingly links are "+clc);
  		System.out.println("Broken links are "+blc);
  		 //do logout
	    driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/child::*")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Sign out")).click();
	    Thread.sleep(5000);
	    //close site
	    driver.close();
	
	}

}
