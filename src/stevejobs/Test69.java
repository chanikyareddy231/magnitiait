package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test69 {

	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.ebay.com");
		Thread.sleep(5000);
		 WebElement cslider=driver.findElement(By.className("carousel__list"));
		 List<WebElement> slides=cslider.findElements(By.xpath("child::li"));
         int count=slides.size();
         System.out.println("Count of all visible slides is "+count);
         //test case-6: slides rotation process test
         String[] values=new String[count+1]; //count+1 is array size
         for(int i=0;i<count+1;i++) //run loop for count+1 times
         {
        	 //take current slide transform value
        	 String b=cslider.getCssValue("transform");
        	 String c=b.substring(7,b.length()-1);
 			String[] p=c.split(",");
 			p[4]=p[4].trim(); //xoffset
 			values[i]=p[4]; //add xoffset to array because slides are moving horizontaly
 			System.out.println(values[i]);
 			Thread.sleep(4000); //mandatory wait for next slide
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
