package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test35 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site 
		driver.get("https://www.spicejet.com");
		Thread.sleep(10000);//waiting time to load complete page
		WebElement e=driver.findElement(By.xpath("(//input[@value='OneWay'])[1]"));
		//Get size info
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		System.out.println(w+" "+h);
		//Get location info
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		System.out.println(x+" "+y);
		//Get rect info
		int w1=e.getRect().getWidth();
		int h1=e.getRect().getHeight();
	    int x1=e.getRect().getX();
	    int y1=e.getRect().getY();
	    System.out.println(w1+" "+h1+" "+x1+" "+y1);
	    //close site
	    driver.close();
	}

}
