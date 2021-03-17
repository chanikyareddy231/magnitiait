package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test7 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
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
	    Thread.sleep(5000);
	    //locate and click on compose button
	    driver.findElement(By.xpath("//div[@gh='cm']")).click();
	    Thread.sleep(5000);
	    //fill fields
	    driver.findElement(By.name("to")).sendKeys("chinnapureddymahesh55555@gmail.com");
	    driver.findElement(By.name("subjectbox")).sendKeys("wishes");
	    driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("hi mahesh,\nkeep smile");
	    driver.findElement(By.xpath("//div[starts-with(@data-tooltip,'Send')]")).click();
	    Thread.sleep(5000);
	    //Get output and display
	    String x=driver.findElement(By.className("vh")).getText();
	    System.out.println(x);
	    //do logout
	    driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/child::*")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Sign out")).click();
	    Thread.sleep(5000);
	    //close site
	    driver.close();
	    
	    
	    
	    
	    }

}
