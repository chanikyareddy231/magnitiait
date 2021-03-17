package stevejobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test58 {

	public static void main(String[] args) throws Exception
	{
		// set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("https://www.spicejet.com");
		Thread.sleep(15000);
		driver.findElement(By.xpath("(//input[contains(@name,'originStation1')])[1]")).sendKeys("Benguluru(BLR)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[contains(@name,'destinationStation1')])[1]")).sendKeys("Delhi(DEL)");
		Thread.sleep(5000);
		driver.findElement(By.linkText("12")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(15000);
		//collect all flight information rows
		List<WebElement> flights=driver.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/child::tr[not(contains(@class,'heading'))]"));
	    List<Integer> fares=new ArrayList<Integer>();
	    for(WebElement flight:flights)
	    {
	    	String temp=flight.findElement(By.xpath("child::td[3]/descendant::span[1]")).getText();
	    	temp=temp.replace(",","");
	    	temp=temp.replace(" INR","");
	    	int fare=Integer.parseInt(temp);
	    	fares.add(fare);
	        }
	    //find max fare
	    int index=0;
	    int maxfare=fares.get(0);
	    for(int i=1;i<fares.size();i++)
	    {
	    	if(maxfare<fares.get(i))
	    	{
	    		maxfare=fares.get(i);
	    		index=i;		
	    	}
	    }
	    System.out.println(maxfare+" Rs/- at "+(index+1)+"th Flight");
	    flights.get(index).findElement(By.xpath("child::td[3]/descendant::input")).click();
	    Thread.sleep(5000);
	    //close site
	    driver.close();
	    }

}
