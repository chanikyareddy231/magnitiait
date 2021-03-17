package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test71 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");
		Thread.sleep(5000);
		//driver.switchTo().frame(1);
		//driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("iframeResult"));
		driver.switchTo().frame(e);
		driver.findElement(By.name("fname")).sendKeys("abdul");
		driver.findElement(By.name("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//close site
		driver.close();
	}

}
