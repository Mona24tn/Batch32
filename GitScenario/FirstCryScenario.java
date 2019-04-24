package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class FirstCryScenario {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		/*FirefoxProfile fp= new FirefoxProfile();
		fp.setPreference("", false);*/
		
		WebDriver driver =new FirefoxDriver();
		
		driver.get("http://www.firstcry.com");
		
		WebElement e=driver.findElement(By.xpath("//li[@class='double white-background']/a[contains(.,'Baby')]"));

		Actions act=new Actions(driver);
		
		act.moveToElement(e).build().perform();
		
		List <WebElement> allItems=driver.findElements(By.xpath("//ul[@class='col-one']/li[@class='nbtmborder']/following-sibling::li/a"));
		
		for(int i=0;i<allItems.size();i++) {
			System.out.println(allItems.get(i).getText());
		}
	}

}
