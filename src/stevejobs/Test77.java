package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test77 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		//locate and fill userid
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("chanikyareddy231");
		//locate and click "Next" button
		driver.findElement(By.name("signin")).click();
		Thread.sleep(10000);	
		//fill password
		driver.findElement(By.name("password")).sendKeys("Mahesh231");
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(10000);
        driver.findElement(By.linkText("Compose")).click();
        Thread.sleep(5000);
        //go to compose
        driver.findElement(By.id("message-to-field")).sendKeys("chanikyareddy231@gmail.com");
        driver.findElement(By.xpath("//input[@aria-label='Subject']")).sendKeys("testing");
        driver.findElement(By.xpath("//*[@aria-label='Message body']")).sendKeys("hi mahesh,\n go to deep of subject,\n bye");
        try
        {
        	driver.findElement(By.id("Atom")).click();
        	Thread.sleep(5000);
        }
        catch(Exception ex)
        {
        }
        driver.findElement(By.xpath("//*[@title='Send this email']")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("message")).click();
        Thread.sleep(5000);
        //take new window/tab
	    driver.switchTo().newWindow(WindowType.TAB);
	    Thread.sleep(5000);
		Set<String> s=driver.getWindowHandles();
		ArrayList<String> a=new ArrayList<String>(s);
		//move to second window or tab
		driver.switchTo().window(a.get(1)); //get(1) means 2nd window or tab
		//open gmail site
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
	    Thread.sleep(15000);
	    //check from address of latest mail
	    String y=driver.findElement(By.xpath("(//table)[7]/tbody/tr[1]/td[4]/div[1]/span[1]/span")).getAttribute("email");
	    if(y.contains("chanikyareddy231"))
	    {
	    	System.out.println("Gmail mail sent completly working");
		}
		else
		{
			System.out.println("Gmail mail sent not completly working");
		}
	    // do gmail logout
	     driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/child::*")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Sign out")).click();
		 Thread.sleep(5000);
		 //close site
		 driver.close();
		//move to first window or tab
	     driver.switchTo().window(a.get(0)); //get(0) means 1st window or tab
	     Thread.sleep(5000);
	   //do logout in yahoo
		 driver.findElement(By.xpath("//img[@role='presentation']")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//a[@data-soa='Sign out all']")).click();
         Thread.sleep(5000);
         //close site
	     driver.close();
	    

	}

}
