package Automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSuggestion {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		WebElement e=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		
		e.sendKeys("Selenium");
		
		Thread.sleep(1000);
		
		//get the auto suggestion
		List <WebElement> autoList=driver.findElements(By.className("sbct"));
		
		List <String> ls=new ArrayList<>();
		
		//print all the list
		for(int i=0;i<autoList.size();i++) {
			ls.add(autoList.get(i).getText());
		}
		
		//print the third element
		
		autoList.get(2).click();
		
		//print all in the list and in  reverse order
		
		for(String s:ls)
			System.out.println(s);
		
		for(int i=ls.size()-1;i>=0;i--) {
			System.out.println(ls.get(i));
		}
		
	}

}
