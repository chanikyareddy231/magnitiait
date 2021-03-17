package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test65 {

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
		WebElement neighbor=driver.findElement(By.xpath("//h4[text()='Multiple Selection']"));
		driver.executeScript("arguments[0].scrollIntoView();",neighbor);
		Thread.sleep(5000);
		//locate drop down developer using<div> tags
		WebElement dd=neighbor.findElement(By.xpath("following-sibling::div"));
		//test case-1:check for multi select or not
		if(dd.getAttribute("class").contains("multiple"))
		{
			System.out.println("multiselecter drop down");
			//continue testing
			//test case-2:collect all items of it and display those items text
			List<WebElement> items=dd.findElements(By.xpath("child::div[2]/div"));
			System.out.println("count of items is "+items.size());
			System.out.println("Items are");
			for(WebElement item:items) 
			{
				//get invisible items text via javascript

        		String x=(String) driver.executeScript("return(arguments[0].textContent);",item);
        		System.out.println(x);		
        	}
        	//test case-3:select each item and test that selection and de-select that item
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
        				String actual=dd.findElement(By.xpath("child::a")).getText();
        				//6.compare both remebered text and visible text of selected item
        				if(expected.equals(actual))
        				{
        					System.out.println(expected+" item selection test passed");
        				}
        				else
        				{
        					System.out.println(expected+" item selection test failed");
        				}
        				//7.de-select that item
        				dd.findElement(By.xpath("child::a/i")).click();
        				Thread.sleep(2000);
        			}
        			else
        			{
        			  String y=(String) driver.executeScript("return(arguments[0].textContent);",item);
              		  System.out.println(y+" Item is hidden");		
            	    }
        			//8.close dropdown
        			dd.sendKeys(Keys.ESCAPE);
        			Thread.sleep(1000);
        			}
        		catch(Exception ex)
        		{
        			System.out.println(ex.getMessage());	
        		}
		}//loop ending
        	//test case-4:select multiple items and test them
        	//1.open drop down
        	dd.click();
        	Thread.sleep(2000);
        	//2.looping on items
        	int flag=0;
        	for(int i=0;i<items.size();i++)
        	{
        		try
        		{
        			//3.remeber text of item to be selected
        			String expected=items.get(i).getText();
        			//4.select that item
        			items.get(i).click();
        			Thread.sleep(1000);
        			//5.get selected item text
        			String actual=dd.findElement(By.xpath("child::a["+(i+1)+"]")).getText();
        			//6.compare remebered text and visible text of seleted item
        			if(!expected.equals(actual))
        			{
        				flag=1;
        			}
        		}
        	   catch(Exception ex)
        		{
        		   System.out.println(ex.getMessage());
        		}
        	}//loop ending
        	//7.check flag after selecting all items
        	if(flag==0)
        	{
        		 System.out.println("multiple items test passed");
        	}
        	else
        	{
        		 System.out.println("multiple items test failed");
        	}
        }//if ending related to multi-select drop down
		else
		{
			 System.out.println("single-select drop down");
		}
		//close site
		driver.close();
	}
}	


