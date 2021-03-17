package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test49 
{

	public static void main(String[] args) throws Exception
	{
		// set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.spicejet.com");
		Thread.sleep(10000);
		//collect and display count of all elements
		List<WebElement> l1=driver.findElements(By.xpath("//*"));
		System.out.println("Total count of elements is "+l1.size());
		//collect and dispalay count of all input tag elements
		List<WebElement> l2=driver.findElements(By.tagName("input"));
		System.out.println("Total count of input tag elements is "+l2.size());
		//Segregate input tag elements
		int rbc=0;
		int tbc=0;
		int bc=0;
		int cbc=0;
		int pbc=0;
		int ebc=0;
		int ubc=0;
		int hc=0;
		int others=0;
		for(WebElement e:l2)
		{
			String x=e.getAttribute("type");
			switch(x)
			{
				case"radio":
			    rbc++;
			    break;//terminate from current switch block
				case"checkbox":
				    cbc++;
				    break;
				case"text":
				    tbc++;
				    break;    
				case"url":
				    ubc++;
				    break; 
				case"password":
				    pbc++;
				    break;
				case"email":
				    ebc++;
				    break;
				case"button":
				    bc++;
				    break;
				case"hidden":
				    hc++;
				    break;
				default:
				    others++;
				    break;
			}
			
		}
		System.out.println("Total count of radio buttons "+rbc);
		System.out.println("Total count of  check boxes "+cbc);
		System.out.println("Total count of text  boxes "+tbc);
		System.out.println("Total count of push  buttons "+bc);
		System.out.println("Total count of url boxes "+ubc);
		System.out.println("Total count of password boxes "+pbc);
		System.out.println("Total count of email boxes "+ebc);
		System.out.println("Total count of hidden elements "+hc);
		System.out.println("Total count of other elements "+others);
		//close site
		driver.close();
		
	}

}
