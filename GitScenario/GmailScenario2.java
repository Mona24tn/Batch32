package Automation;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailScenario2 {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		// 1. Open the Browser
		
		WebDriver driver=new FirefoxDriver();
		//WebDriver driver=new ChromeDriver();
		
		//2. enter the url
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		
		//3.Login to your credentials
		driver.findElement(By.id("identifierId")).sendKeys("mona24tn@gmail.com");
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.name("password"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys("VihaasMona22");
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(1000);
		
		//4. verify that gmail logged in successfully
		
		String actTitle=driver.getTitle();
		String expTitle="mona24tn@gmail.com";
		if(actTitle.contains(expTitle))
		{
		System.out.println("user " +expTitle+ " logged in successfully ");

		}
		else
		{
			System.out.println("not logged in ");
		}
		
		//5a. click on compose
		
		String parentWin=driver.getWindowHandle();
		System.out.println(parentWin);
		Thread.sleep(1000);
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='z0']/div[@class='T-I J-J5-Ji T-I-KE L3']"));
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(ele)); 
		wait1.until(ExpectedConditions.elementToBeClickable(ele));
		
		ele.click();
		Thread.sleep(5000);
		Set<String>winHan=driver.getWindowHandles();
		for(String s:winHan) {
			if(!s.equals(parentWin)) {
				driver.switchTo().window(s);
				System.out.println("child window id is"+s);
				
			}
			else {
				System.out.println("did not open the compose");
			}
			
			//5b . verify new window is opened
			
			String actwinTitle=driver.getTitle();
			String expwinTitle="New Message";
			if(expwinTitle.equals(actwinTitle))
			{
				System.out.println("message window opend");
			}
			else {
				System.out.println("message window not opened");
			}
			
			//6 enter email id. 
			
			driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea[@id=':rg']")).sendKeys("mona24tn@gmail.com");
			
			//7. enter subject
			
			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test Mail");
			
			//8. Enter some text body
			
			driver.findElement(By.xpath("//div[@id=':s7']/div[@id=':s3']")).sendKeys("Hello mona auto mail generated");
			
			//9. click send button
			
			driver.findElement(By.xpath("//div[@id=':qo']")).click();
			
			Thread.sleep(5000);
			
			driver.switchTo().window(parentWin);
			
			driver.findElement(By.xpath("//a[@class='gb_x gb_Da gb_f']/span[@class='gb_ya gbii']")).click();
			
			Thread.sleep(5000);
			
			//10. close the browser
			
			driver.quit();
			
			try {
				Runtime.getRuntime().exec("taskkill /im firefox.exe /F");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
