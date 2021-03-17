package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test55 {

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
		//locate and fill userid
		driver.findElement(By.name("identifier")).sendKeys("chanikyareddy231");
		//locate and click "Next" button
		driver.findElement(By.xpath("//button[@type='button']/child::div[2]")).click();
		Thread.sleep(5000);
		//locate and fill password
		driver.findElement(By.name("password")).sendKeys("Chanikya231");
		//locate and click "Next" button
	    driver.findElement(By.xpath("//div[@id='passwordNext']/descendant::div[3]")).click();
	    Thread.sleep(20000);
	    //mailbox testing via pagenation
	    int eamc=0;
	    int eurmc=0;
	    int ermc=0;
	    while(true) //infinate loop from pagination
	    {
	    	WebElement mailbox=driver.findElement(By.xpath("(//table)[7]/tbody"));
	    	List<WebElement> mails=mailbox.findElements(By.xpath("child::tr"));
	    	eamc=eamc+mails.size();
	    	for(WebElement mail:mails)
	    	{
	    		WebElement e=mail.findElement(By.xpath("child::td[4]/div[1]"));
	    		String op=(String) driver.executeScript("return(arguments[0].textContent)", e);
	    		 if(op.startsWith("unread"))
		    		{
		    			eurmc++;
		    		}
		    		else
		    		{
		    			ermc++;
		    		}
	    	}	
		    	//Go to next page 
	    	try
	    	{
	    		if(driver.findElement(By.xpath("//div[@aria-label='Older']")).getAttribute("aria-disabled").equals("true"))
	    		{
	    			break; //terminate from loop,bcz we are in last page
	    		}
	    	}
	    	catch(NullPointerException ex)
	    	{
	    		driver.findElement(By.xpath("//div[@aria-label='Older']")).click();
	    		Thread.sleep(5000);
	    	}
	    }
	    System.out.println("Total count of all mails is "+eamc);
	    System.out.println("Total count of unread mails is "+eurmc);
	    System.out.println("Total count of read mails is "+ermc);
	    //Get actual values given by gmail server add validates
	    String temp1=driver.findElement(By.xpath("//div[@aria-label='Show more messages']/descendant::span[5]")).getText();
	    int aamc=Integer.parseInt(temp1);
	    String temp2=driver.findElement(By.xpath("//div[@data-tooltip='Inbox']/descendant::div[4]")).getText();
	    int aurmc=Integer.parseInt(temp2);
	    if (eamc==aamc)
	    {
	    	System.out.println("all mails count test passed ");
	    	if(eurmc==aurmc)
	    	{
	    		System.out.println("unread mails count test passed ");
	    	}
	    	else 
	    	{
	    		System.out.println("unread mails count test failed ");
	    	}
	    }
	    else
	    {
	    	System.out.println("all mails count test failed ");
	    }
	    //do logout
	    driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/child::*")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Sign out")).click();
	    Thread.sleep(5000);
	    //close site
	    driver.close();
	}

}
