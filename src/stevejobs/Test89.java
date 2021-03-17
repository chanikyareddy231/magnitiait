package stevejobs;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test89 {

	public static void main(String[] args) throws Exception
	{
		//take browser name from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser name");
		String bn=sc.nextLine();
		System.out.println("Enter url");
		String u=sc.nextLine();
		sc.close();
		//Declare "driver" object to parent class and define using child class constructors
		RemoteWebDriver driver=null;
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
		else if(bn.equalsIgnoreCase("ie"))
		{
			// set IE browser zoom level to 100%
	        System.setProperty("webdriver.ie.driver","C:\\batch251\\IEDriverServer_x64_3.150.1\\iedriverserver.exe");
	        driver=new InternetExplorerDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\mahesh\\edgedriver_win64\\msedgedriver.exe");
		    driver=new EdgeDriver();
		}
		else 
		{
			System.out.println("please check your browser name");
			System.exit(0); //stop exection forcibly
		}
		//common code
		//lauch site
		driver.get(u);
		Thread.sleep(5000);
		//Collect all browser logs(for chrome,edge,opera)
		List<LogEntry> alllogs=driver.manage().logs().get("browser").getAll();
		for(LogEntry le:alllogs)
		{
			System.out.println(le.getMessage()+" "+le.getTimestamp());
		}
		//close site 
		driver.close();
		
	}

}
