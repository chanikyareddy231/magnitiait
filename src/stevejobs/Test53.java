package stevejobs;

import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test53 {

	public static void main(String[] args) throws Exception
	{
		//Take a word from keyboard
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a word");
		String word=sc.nextLine();
		sc.close();
	    //open browser 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//search word
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		Thread.sleep(5000);
		//pagination
		int clc=0;
		int blc=0;
		while(true) //infinate loop
		{
			try 
			{
				//collect all link type elements in current page
			    List<WebElement> l1=driver.findElements(By.xpath(
			    		"(//a)|(//href)|(//script)|(//img)|(//div)|(//link)|(//base)|(//area)"));
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
		  				//relocate elements to avoid "stale element exception"
		  				l1=driver.findElements(By.xpath(
		  						"(//a)|(//href)|(//script)|(//img)|(//div)|(//link)|(//base)|(//area)"));
		  			}
		  			  	
		  		}
		  		//test each hyper link address for broken links
		  		for(WebElement e:l2)
		  		{
		  			String x=e.getAttribute("href");
		  			Thread.sleep(5000);
		  			URL u=new URL(x); //consider "href" attribute value as url
		  			//open connection to server,which addressed with that url
		  			HttpURLConnection con=(HttpURLConnection) u.openConnection();
		  			try
		  			{
		  			//connect(send a request)
		  			con.connect();
		  			Thread.sleep(1000);
		  			//test responce
		  			String y=con.getResponseMessage();
		  			int z=con.getResponseCode();
		  			if(y.equalsIgnoreCase("ok"))
		  			{
		  				clc++;
		  			}
		  			else
		  			{
		  				blc++;
		  				System.out.println(x+" returns "+y+ "with "+z);
		  			}
		  			con.disconnect();//optional bcz server can disconnect after sending response by default
		  			}
		  			catch(ConnectException ex)
		  			{
		  			blc++;
		  			System.out.println("From  "+x+",no responce");
		  			}
		  		}
		  		//Go to next page
		  		
		  		driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(2000);
				}
	       catch(NoSuchElementException ex)
			{
	    	   break; //terminate from loop
			}
		}
		System.out.println("correctly workingly links are "+clc);
  		System.out.println("Broken links are "+blc);
  		//close site
  		driver.close();
		
	}

}
