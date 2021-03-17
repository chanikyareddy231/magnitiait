package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8 {

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
		        driver.findElement(By.id("message-to-field")).sendKeys("chanikyareddy231@yahoo.com");
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
		        //do logout
		        driver.findElement(By.xpath("//img[@role='presentation']")).click();
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("//a[@data-soa='Sign out all']")).click();
		        Thread.sleep(5000);
		        //close site
		        driver.close();
	}

}
