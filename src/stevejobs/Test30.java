package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test30 {

	public static void main(String[] args) throws Exception
	{
		//set "chrome driver" as per "chrome version in our computer 
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
		//SWD code can use browser driver software to give required effect in browser
		ChromeDriver driver=new ChromeDriver();
		//lunch site under testing(SUT)
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//Get text of visible element
		String x=driver.findElement(By.xpath("(//input[@name='gender'])[1]/following-sibling::div[1]")).getText();
		System.out.println(x);
		//Get text of hidden element
		String y=driver.findElement(By.xpath("(//input[@name='gender'])[1]/following-sibling::div[2]/div[2]")).getText();
		System.out.println(y);//output is blank because element is hidden
		//Get text of hidden element using java script
		WebElement e=driver.findElement(By.xpath("(//input[@name='gender'])[1]/following-sibling::div[2]/div[2]"));
		String z=(String) driver.executeScript("return(arguments[0].textcontent);",e);
        System.out.println(z);
        //close site
        driver.close();
	}

}
