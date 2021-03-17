package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test96 {

	public static void main(String[] args)
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    long st=System.currentTimeMillis();
	    driver.navigate().to("http://www.magnitia.com");//22356
	    long et=System.currentTimeMillis();
	    System.out.println("duriation is "+(et-st));
	    driver.close();
	}
	

}
