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

public class Test50 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site 
		driver.get("https://www.spicejet.com");
		Thread.sleep(10000);
		//collect all elements in that home page
		List<WebElement> l1=driver.findElements(By.xpath("//*"));
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
				l1=driver.findElements(By.xpath("//*"));
			}
		}
		System.out.println("Total count of hyper links  is "+l2.size());
		Thread.sleep(2000);
		//test each hyper link address for broken links
		int clc=0;
		int blc=0;
		for(WebElement e:l2)

		{
			
			String x=e.getAttribute("href");
			Thread.sleep(2000);
			URL u=new URL(x); //consider "href" attribute value as url
			Thread.sleep(2000);
			//open connection to server,which addressed with that url
			HttpURLConnection con=(HttpURLConnection) u.openConnection();
			//connect(send a request)
			Thread.sleep(2000);
			con.connect();
			Thread.sleep(2000);
			//test responce
			try {
			String y=con.getResponseMessage();
			Thread.sleep(2000);
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
			Thread.sleep(5000);
			blc++;
			}
		}
		System.out.println("correctly workingly links are "+clc);
		System.out.println("Broken links are "+blc);
		//close site
		driver.close();


	}

}
