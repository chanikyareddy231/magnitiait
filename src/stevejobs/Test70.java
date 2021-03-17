package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test70 {

	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.flipkart.com");  
		Thread.sleep(5000);
		try
		{
            driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			Thread.sleep(5000);   
		}
		catch(Exception ex)
		{
		}
		//common code
		//refresh page and collect all slides in that carousel slider
		driver.navigate().refresh();
		WebElement cslider=driver.findElement(By.xpath("(//*[contains(@style,'transform')])[1]"));
		int count=0;
		List<WebElement> slides;
		//every child<div> is a slide
		slides=cslider.findElements(By.xpath("child::div"));
		for(WebElement slide:slides)
		{
			try
			{
				if(slide.getAttribute("data-clone").equals("false"))
				{
					count=count+1;
				}
			}
			catch(Exception ex) 
			{
				//developer did not use data-clone concept
				count=count+1;
			}
		}
		System.out.println("count of all visible slides is "+count);
		//test case-6: slides rotation process test
        String[] values=new String[count+1]; //count+1 is array size
        try
        {
        	 for(int i=0;i<count+1;i++) //run loop for count+1 times
             {
            	 //take current slide transform value
            	 String b=cslider.getCssValue("transform");
            	 System.out.println(b);
            	 String c=b.substring(7,b.length()-1);
     			String[] p=c.split(",");
     			p[4]=p[4].trim(); //xoffset
     			values[i]=p[4]; //add xoffset to array because slides are moving horizontaly
     			System.out.println(values[i]);
     			Thread.sleep(3500); //mandatory wait for next slide
             }
        }
        catch(Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
      //compares 1st slide value and next to last slide value for same
        if(values[0].equals(values[count]))
        {
       	 System.out.println("sliders are rotating correctly");
        }
        else
        {
       	 System.out.println("sliders are not rotating correctly");
        }
        //close site
        driver.close();
	}

}
