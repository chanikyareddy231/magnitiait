package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test79 {

	public static void main(String[] args) throws Exception
	{
		
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.way2sms.com");
		Thread.sleep(5000);
		//minimize browser
		driver.manage().window().minimize();
		Thread.sleep(5000);
		//maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//get size of browser window
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		//set/change size for browser window
		Dimension d=new Dimension(300,200);//width and height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//get position of browser window on desktop
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//set/change postion of browser window on desktop
		Point p=new Point(300,400);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		//close site
		driver.close();
		
		
		
	}

}
