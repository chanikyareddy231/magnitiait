package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test73 {

	public static void main(String[] args)throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		//switch to alert
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().accept(); //cancel
		Thread.sleep(5000); 
		//back to page and Switch to frame using name of that frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframeResult");
		//test output
		try
		{
		if(driver.findElement(By.xpath("//*[text()='You pressed OK!']")).isDisplayed())
		{
			System.out.println("alert is correctly working");
		}
		else
		{
			System.out.println("alert is not correctly working");
		}
	}
		catch(Exception Ex)
		{
			System.out.println("alert is not correctly working");
		}
	     //close site
		driver.close();
		
	}

}
