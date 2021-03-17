package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test6
{

	public static void main(String[] args) 
	{
		//Take browser name name from keyboard
		Scanner sc=new Scanner(System.in);//object creation
		System.out.println("Enter a browser name");
		String bn=sc.nextLine();
		//cross browser selection
		RemoteWebDriver driver=null;//object declared
		if(bn.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\mahesh\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		    driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\mahesh\\edgedriver_win64\\msedgedriver.exe");
		    driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			// set IE browser zoom level to 100%
	        System.setProperty("webdriver.ie.driver","C:\\batch251\\IEDriverServer_x64_3.150.1\\iedriverserver.exe");
	        driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Wrong browser name");
			System.exit(0);//stop execution forcibly
		}
		//Common code
		//Launch site
		driver.get("http://www.facebook.com");
			
	}
	

}


