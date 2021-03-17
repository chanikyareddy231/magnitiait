package stevejobs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test100 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    //Luanch site
	    driver.get("https://www.amazon.in");
	    Thread.sleep(5000);
        //Locate drop down developed using <select> tag
        WebElement e=driver.findElement(By.name("url"));
        Select s=new Select(e);
        //Get all items and Display
        List<WebElement> items=s.getOptions();
        System.out.println("total count of items are "+items.size());
        //Copy all items except first into 2 arrays
        ArrayList<String> l1=new ArrayList<String>();
        ArrayList<String> l2=new ArrayList<String>();
        for(int i=2;i<items.size();i++)
        {
        	l1.add(items.get(i).getText());
        	l2.add(items.get(i).getText());
        }
        //sort 2nd array
        Collections.sort(l2);
        //compare both arrays
        if(l1.equals(l2))
        {
        	System.out.println("Items are in sorted order");
        }
        else 
        {
        	System.out.println("Items are not in sorted order");
        }
        //close site
        driver.close(); 
	}

}
