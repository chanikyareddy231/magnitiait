package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test97 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
	    Thread.sleep(5000);
	    //Locate and operate drop down developed using <select> tag
	    driver.switchTo().frame("iframeResult");
	    WebElement e=driver.findElement(By.name("cars"));
	    Select s=new Select(e);
	    s.selectByIndex(3); //4th item
	    Thread.sleep(5000);
	    s.selectByVisibleText("Volvo");//visible text of item in page
	    Thread.sleep(5000);
	    s.selectByValue("saab"); //take value of an item from page source
	    Thread.sleep(5000);
	    driver.switchTo().defaultContent(); //back to page
	    //close site 
	    driver.close();
	    

	}

}
