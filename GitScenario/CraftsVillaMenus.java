package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CraftsVillaMenus {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		//1. open the browser
		
		WebDriver driver=new FirefoxDriver();
		
		//2. Enter the url
		
		driver.get("https://www.craftsvilla.com/");
				
		List<WebElement> menuItems=driver.findElements(By.xpath("//nav[@id='mega-menu']/div[@class='container']/ul/li/a/parent::li/a"));
		
		//3. Print all the Menu list
		for(WebElement item:menuItems) {
			System.out.println(item.getText());
		}
		
		//4. Get the sub menus
		
		WebElement e1=driver.findElement(By.xpath("//nav[@id='mega-menu']/div[@class='container']/ul/li/a/parent::li/a"));
		e1.click();
		
		/*Actions act=new Actions(driver);
		
		act.moveToElement(e1).build().perform();
		*/
		Thread.sleep(1000);
		List <WebElement> subMenu=driver.findElements(By.xpath("//ul[@class='ds-flex']/li/a"));
		
		for(WebElement item1:subMenu) {
			System.out.println(item1.getText());
		}
		
		//5. assert the main menu and sub menu

	}

}
