package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test98 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    //Luanch site
	    driver.get("https://www.mercurytravels.co.in");
	    Thread.sleep(5000);
	    //Close banners
	    driver.switchTo().frame(1);
        driver.findElement(By.xpath("//*[name()='svg']//*[name()='circle']")).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();//back to page
        driver.findElement(By.className("white-text")).click();
        Thread.sleep(5000);
        //Locate drop down developed using <select> tag
        WebElement e=driver.findElement(By.name("nights"));
        Select s=new Select(e);
        //Get all items and Display
        List<WebElement> items=s.getOptions();
        System.out.println("total count of items are "+items.size());
        for(WebElement item:items)
        {
        	System.out.println(item.getText());
        }
        //close site
        driver.close();
	}

}
