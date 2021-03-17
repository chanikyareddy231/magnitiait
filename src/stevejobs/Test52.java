package stevejobs;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test52 {

	public static void main(String[] args) throws Exception
	{
		//Take a word from keyboard
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		sc.close();
	    //open browser 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//lunch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//search word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//pagination
		int nor=0;
		int pn=1;
		while(2>1) //infinite loop
		{
			try
			{
				List<WebElement> l=driver.findElements(By.className("g"));
				nor=nor+l.size();
				if (pn==1)
				{
					System.out.println(pn+"st page consists of "+l.size());
				}
				else if(pn==2)
				{
					System.out.println(pn+"nd page consists of "+l.size());
				}
				else if(pn==3)
				{
					System.out.println(pn+"rd page consists of "+l.size());
				}
				else
				{
					System.out.println(pn+"th page consists of "+l.size());
				}
				pn++;
				driver.findElement(By.linkText("Next")).click();
				Thread.sleep(2000);
			}
			catch(NoSuchElementException ex)
			{
				break; //terminate from the loop
			}
		}
		System.out.println("total count of result is "+nor);
		//close site
		driver.close();
		

	}

		
	}


