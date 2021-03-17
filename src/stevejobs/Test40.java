package stevejobs;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test40 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/"+"explicit-show-hide/defaultcs.aspx");
		Thread.sleep(10000);
		//Take screen shot of an element
		//click on an element which is covered by other element like banner wrong image sir said but me working
		WebElement e=driver.findElement(By.linkText("1"));
		File dest=new File("elementpic.png");//save in current project folder
		File src=e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,dest);
		//close site
        driver.close();

	}

}
