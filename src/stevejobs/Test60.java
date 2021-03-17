package stevejobs;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test60 {

	public static void main(String[] args) throws Exception
	{
		// Take a word from keyboard
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a word");
		String word=sc.nextLine();
		word=word.toLowerCase();
		sc.close();
	    //open browser 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//search word
		driver.findElement(By.name("q")).sendKeys(word); //parametarization
		//it can raise a cache element with auto suggestions as per given word
		Thread.sleep(5000);
		//locate cache/auto-complete element
		WebElement ce=driver.findElement(By.xpath("//ul[@role='listbox']"));
		//test case-1:get count of suggestions in that cache element
		List<WebElement> items=ce.findElements(By.xpath("child::li"));
		System.out.println("no:of suggesstions in cache is "+items.size());
		//test case-2 get all suggesstions text and display 
		for(WebElement item:items) // for each item
		{
			System.out.println(item.getText());
		}
		//test case-3:check each item text,which consist of given word or not
		int flag=0;
		for(WebElement item:items) //for each item
		{
			String y=item.getText();
			y=y.toLowerCase();
			if(!y.contains(word)) //!means "not" in java laungage
			{
				flag=1;
				System.out.println(y+" does not contain "+word);
			}
		}
		if (flag==0)
		{
			System.out.println("cache suggestions test passed for "+word);
		}
		else 
		{
			System.out.println("cache suggestions test failed for "+word);
		}
		//close site
		driver.close();
	}

}
