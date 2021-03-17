package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test94 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.magnitia.com");
	    Thread.sleep(5000);
        driver.navigate().to("http://www.gmail.com");
        //URL u=new URL
        //driver.navigate().to(u); //URL as an object
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
    	driver.close(); 
	}


}
