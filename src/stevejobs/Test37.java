package stevejobs;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test37 {

	public static void main(String[] args)throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("https://www.google.co.in");
		Thread.sleep(50000);//waiting time to load complete page
		//locate element
		WebElement e=driver.findElement(By.className("HPVvwb"));
		File dest=new File("elementpic.png");//save in current project folder
		File src=e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,dest);
		//close site
		driver.close();

	}

}
