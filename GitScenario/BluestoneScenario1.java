package Automation;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BluestoneScenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		//1. open the browser
		WebDriver driver=new FirefoxDriver();
		
		//2.enter the url
		driver.get("https://www.bluestone.com/");
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		//3. move the cursor to rings menu
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//span[@class='CT_BannerClose']")).click();
		
		Actions act=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("//nav[@class='wh-navbar']/ul[@class='wh-main-menu']/li[@class='menuparent repb']/a[.='Rings ']"));
		
		act.moveToElement(e).build().perform();
		
		Thread.sleep(1000);
		WebElement e1=driver.findElement(By.xpath("//ul[@class='two-col']//a[.='Diamond']"));
		
		e1.click();
		
		//to get the price list of the default items
		
		List<WebElement> defaultList=driver.findElements(By.xpath("//span[@class='new-price']"));
		
		List<String>dList=new ArrayList<>();
		
		for(WebElement dl:defaultList) {
			System.out.println(dl.getText());
			dList.add(dl.getText());
		}
		
		
		WebElement pList=driver.findElement(By.xpath("//span[@class='view-by-wrap title style-outline i-right']"));
		
		Actions pact=new Actions(driver);
		
		pact.moveToElement(pList).build().perform();
		
		Thread.sleep(1000);
		
		WebElement e2=driver.findElement(By.xpath("//a[.='Price Low to High ']"));
				e2.click();
		
		//to get actual list of price from low to high
		
		List<WebElement>aList=driver.findElements(By.xpath("//span[@class='new-price']"));
		
		List<String>lpList=new ArrayList<>();
		
		for(WebElement lp:aList) {
		
			System.out.println(lp.getText());
			lpList.add(lp.getText());
		}
		
		//to compare two lists and validate their prices should not be equal
		
		if(!dList.equals(lpList)) {
			System.out.println("prices list of default value and the low to high varies by prices");
		}
		else
		{
			System.out.println("it does not vary by prices c");
		}
		
		//to sort the list of the low to high price
		
		TreeSet<String>sortList=new TreeSet<>();
		
		for(String s:lpList) {
			sortList.add(s);
			System.out.println("Sorted list is :"+sortList);
		}
	}

}
