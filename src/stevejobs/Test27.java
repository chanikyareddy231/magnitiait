package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test27 {

	public static void main(String[] args)throws Exception
 {
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site 
		driver.get("https://www.spicejet.com");
		Thread.sleep(10000);
		//locate and get details of an element(in-built in html)
		String x=driver.findElement(By.xpath("(//input[contains(@name,'originStation1')])[1]")).getAttribute("autofocus");
		System.out.println(x);//null because element is not autofocused
		//locate and get details of an element(in-built in HTML)
		String y=driver.findElement(By.xpath("(//input[@value='OneWay'])[1]")).getAttribute("checked");
		System.out.println(y);//true because element was checked by default
		//close site
		driver.close();
	}

}
