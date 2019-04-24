package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonProductPrint {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		//1. Open the browser
		
		WebDriver driver=new FirefoxDriver();
		
		//2. go to amazon.com
		
		driver.get("http://www.amazon.com");
		
		//3. enter the product name
		
		WebElement prod=driver.findElement(By.id("twotabsearchtextbox"));
		Thread.sleep(1000);
		
		prod.sendKeys("mobile phones");
		
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		
		//4. list out the products and print them
		
		List <WebElement> pList=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for(WebElement e:pList)
		{
			System.out.println(e.getText());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("no of choice list is :"+ pList.size());
		
		//5. get the cost of the product
		
		List <WebElement> costList=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for(int i=0;i<costList.size();i++) {
			System.out.println(costList.get(i).getText());
		}
		
		
			
	}

}
