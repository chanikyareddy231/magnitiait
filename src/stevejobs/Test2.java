package stevejobs;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","C:\\mahesh\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	    FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://google.co.in");
		driver.close();
		

	}

}
