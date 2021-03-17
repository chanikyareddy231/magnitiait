package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test95 {

	public static void main(String[] args)
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    long st=System.currentTimeMillis();
	    driver.get("http://www.magnitia.com");//25523
	    long et=System.currentTimeMillis();
	    System.out.println("duriation is "+(et-st)); 
	    driver.close();
	}
	

}
