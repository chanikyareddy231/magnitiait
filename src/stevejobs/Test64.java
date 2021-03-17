package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test64 {

	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https:semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//scroll page to a neighbour element to get target into visible area of desktop
		WebElement neighbor=driver.findElement(By.xpath("//h4[text()='Selection']"));
        driver.executeScript("arguments[0].scrollIntoView();",neighbor);
        Thread.sleep(5000);
        //locate a drop-down developed using<div>tag
        WebElement dd=driver.findElement(By.xpath("//h4[text()='Selection']/following-sibling::div[2]"));
        //test case-1:check for single-select or not
        if(dd.getAttribute("class").contains("multiple"))
        {
        	System.out.println("multiple-select drop down");
        	//stop testing
        }
        else
        {
        	System.out.println("single-select drop down");
        	//continue Testing
        	//Test case-2:collect all items in that single select drop down and display
        	List<WebElement> items=dd.findElements(By.xpath("child::div[2]/div"));
        	System.out.println("count of items in drop down is "+items.size());
        	System.out.println("items are");
        	for(WebElement item:items)
        	{
        		String x=(String) driver.executeScript("return(arguments[0].textContent);",item);
        		System.out.println(x);		
        	}
        	//test case-3:select each item and test that selection
        	for(WebElement item:items)
        	{
        		try
        		{
        			//1.open drop down to get visibility of items
        			dd.click();
        			Thread.sleep(3000);
        			//2.check items fot visibility
        			if(item.isDisplayed())
        			{
        				//3.remeber text of that item to be selected
        				String expected=item.getText();
        				//4.select that item
        				item.click();
        				Thread.sleep(3000);
        				//5.get selected item text
        				String actual=dd.findElement(By.xpath("child::div[1]")).getText();
        				//6.compare both remebered text and visible text of selected item
        				if(expected.equals(actual))
        				{
        					System.out.println(expected+" item selection test passed");
        				}
        				else
        				{
        					System.out.println(expected+" item selection test failed");
        				}
        			}
        			else
        			{
        				String y=(String)driver.executeScript("return(arguments[0].textcontent);",item);
        				System.out.println(y+" item is hidden");
        			}
        		}
        		catch(Exception ex)
        		{
        			System.out.println(ex.getMessage());
        		}
        	}
        }
        //close site
        driver.close(); 
	}
	
}
