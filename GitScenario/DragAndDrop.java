package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		//1. open the browser
		WebDriver driver=new FirefoxDriver();
		
		//2. Enter the url
		driver.get("http://jqueryui.com/droppable/ webpage");
		
		//3. consider "Drag me to my target as source" and "Drop me here" as target
		driver.findElement(By.linkText("Demos")).click();
		
		driver.findElement(By.linkText("Droppable")).click();
		
		Thread.sleep(1000);
		
		Actions act=new Actions(driver);
				
		//4. drag and drop to the source to destination
		WebElement e=driver.findElement(By.xpath("//div[@id='draggable']/p"));
		
		WebElement t=driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(e, t).build().perform();
		
		//5. verify the action by performing the operation check the color and text
		WebElement actEle=driver.findElement(By.xpath("//div[@id='draggable']/p"));
		
		String actColor=actEle.getCssValue("color");
		
		String actText=actEle.getText();
		
		String expText="Drag me to my target";
		
		if(expText.equals(actText)) {
			System.out.println("verified the text value");
		}
		else {
			System.out.println("text value not matching");
		}
		
		
	}

}
