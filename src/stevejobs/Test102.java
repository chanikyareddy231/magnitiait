package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test102 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","C:\\mahesh251\\chromedriver_win32\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
	    Thread.sleep(5000);
	    //Locate and operate multiple select drop-down developes using <select> tag
	    driver.switchTo().frame(1);
	    WebElement e=driver.findElement(By.name("cars"));
	    Select s=new Select(e);
	    Actions a=new Actions(driver);
	    a.keyDown(Keys.CONTROL).perform(); //keys.META in mac book
	    a.click(s.getOptions().get(0)).click(s.getOptions().get(2)).click(s.getOptions().get(1)).click(s.getOptions().get(3)).perform();
	    Thread.sleep(5000);
	    a.keyUp(Keys.CONTROL).perform();
	    //Get first(top) item in selected items
	    String x=s.getFirstSelectedOption().getText();
	    System.out.println(x);
	    //get all selected items
	    List<WebElement> items=s.getAllSelectedOptions();
	    for(WebElement item:items)
	    {
	    	System.out.println(item.getText());
	    }
	    //deselect items
	    s.deselectByIndex(2);
	    Thread.sleep(5000);
	    s.deselectByVisibleText("Volvo");
	    Thread.sleep(5000);
	    s.deselectByValue("saab");
	    Thread.sleep(5000);
	    s.deselectAll();
	    driver.switchTo().defaultContent();
	    //close site
	    //driver.close();
		
		
	}

}
