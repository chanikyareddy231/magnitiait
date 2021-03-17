package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test36 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_submit");
		Thread.sleep(10000);// waiting time to load complete page
		// due to fill a disabled element
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("fname")).sendKeys("abdul");
		driver.findElement(By.name("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//input[@value='Submit']")).submit();
	    //close site
        //driver.close();

   }
}
