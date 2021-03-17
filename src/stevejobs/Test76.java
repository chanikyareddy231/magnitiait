package stevejobs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test76 {

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
	    Thread.sleep(15000);
	    //locate and click on compose button
	    driver.findElement(By.xpath("//div[@gh='cm']")).click();
	    Thread.sleep(5000);
	    //fill fields
	    driver.findElement(By.name("to")).sendKeys("chanikyareddy231@yahoo.com");
	    driver.findElement(By.name("subjectbox")).sendKeys("wishes");
	    driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("hi mahesh,\nkeep smile");
	    driver.findElement(By.xpath("//div[starts-with(@data-tooltip,'Send')]")).click();
	    Thread.sleep(5000);
	    //take new window/tab
	    driver.switchTo().newWindow(WindowType.WINDOW);
	    Thread.sleep(5000);
		Set<String> s=driver.getWindowHandles();
		ArrayList<String> a=new ArrayList<String>(s);
		//move to second window or tab
		driver.switchTo().window(a.get(1)); //get(1) means 2nd window or tab
		//launch yahoo mail site
		driver.get("http://www.yahoomail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//do login
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		//locate and fill userid
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("chanikyareddy231@yahoo.com");
		//locate and click "Next" button
		driver.findElement(By.name("signin")).click();
		Thread.sleep(10000);	
		//fill password
		driver.findElement(By.name("password")).sendKeys("Mahesh231");
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(10000);
		String x=driver.findElement(By.xpath("//*[@data-test-id='virtual-list']/ul/li[3]/descendant::span[4]")).getAttribute("title");
		if(x.contains("chanikyareddy231")) //gmail user id
		{
			System.out.println("Gmail mail sent completly working");
		}
		else
		{
			System.out.println("Gmail mail sent not completly working");
		}
		//do logout in yahoo
		 driver.findElement(By.xpath("//img[@role='presentation']")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//a[@data-soa='Sign out all']")).click();
         Thread.sleep(5000);
         //close site
	     driver.close();
	     //move to first window or tab
	     driver.switchTo().window(a.get(0)); //get(0) means 1st window or tab
	     Thread.sleep(5000);
         // do gmail logout
	     driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/child::*")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Sign out")).click();
		 Thread.sleep(5000);
		 //close site
		 driver.close();

	}

}
