package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test67 {

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
		 WebElement cslider=driver.findElement(By.xpath("(//*[contains(@style,'transform')])[1]"));
		//common code
		//test case-1:get count of visible slides
		String tn=cslider.getTagName();
		int count=0;
		List<WebElement> slides;
		if(tn.equals("div"))
		{
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
			
		}
		else
		{
			//each slide is child<li>tag
			slides=cslider.findElements(By.xpath("child::li"));
			count=slides.size();
		}
		System.out.println("count of all visible slides is "+count);
		//test case-2:2D or 3D slider
		String a=cslider.getCssValue("transform");
		if(a.equals("none"))
		{
			//take transform-style property value
			a=cslider.getCssValue("transform-style");
		}
		//verfication
		if(a.contains("3d"))
		{
			System.out.println("3d slider");
		}
		else
		{
			System.out.println("2d slider");
		}
		//test case-3:whether slides are moving not automatically?
		String b=cslider.getCssValue("transform");
		if(b.equals("none"))
		{
			System.out.println("not moving automatically");
		}
		else
		{
			System.out.println("carousel slider slides are moving automatically");
			//test case-4: get direction of moving slides
			System.out.println("Transoform property value is "+b);
			String c=b.substring(7,b.length()-1);
			String[] p=c.split(",");
			p[4]=p[4].trim(); //remove unwanted spaces at before and after
			p[5]=p[5].trim();
			float x=Float.parseFloat(p[4]);
			float y=Float.parseFloat(p[5]);
			if(x<0 && y==0)
			{
				System.out.println("slides are moving from Right to Left");	
			}
			else if(x>0 && y==0)
			{
				System.out.println("slides are moving from Left to Right");	
			}
			else if(x==0 && y<0)
			{
				System.out.println("slides are moving from Bottom to Top");	
			}
			else //here,y>0
			{
				System.out.println("slides are moving from Top to Bottom");	
			}
			//Test case-5:get ease options
			String d=cslider.getCssValue("transition");
			System.out.println(d);
			String[] q=d.split(" "); //saparate is space
			if(q[2].equals("ease-in"))
			{
				System.out.println("slow start for each slide");
			}
			else if(q[2].equals("ease-out"))
			{
				System.out.println("slow end for each slide");
			}
			else //ease-in-out
			{
				System.out.println("slow start and slow end for each slide");
			}
			System.out.println("Duration of each slide is "+q[1]);
			q[3]=q[3].replace(",","");
			System.out.println("Delay in between slides is "+q[3]);
		}
		//close site
		driver.close();

	}

}
