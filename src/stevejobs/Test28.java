package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test28 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		Thread.sleep(5000);
		// due to fill a disabled element
		driver.switchTo().frame("iframeResult");
		String x=driver.findElement(By.name("lname")).getAttribute("disabled");
        System.out.println(x);//true because element was disabled
        //close site
        driver.close();

   }
}
