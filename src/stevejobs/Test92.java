package stevejobs;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test92 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    //Define time limit on javascript code execution if required
	    driver.manage().timeouts().setScriptTimeout(1,TimeUnit.SECONDS);
	  //Automation code
	    driver.get("https://www.spicejet.com");
		driver.executeScript("document.body.style.zoom='200%';");
	    

	}

}
