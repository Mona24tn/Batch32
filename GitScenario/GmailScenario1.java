package Automation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailScenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
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
		
		//4. verify that by default primary section is selected
		WebElement ele=driver.findElement(By.xpath("//div[.='Primary']"));
		String actVal = ele.getCssValue("color");
		System.out.println(actVal);
		String expVal ="rgb(51, 51, 51)";
		
		if(actVal.equals(expVal)) {
			System.out.println("Primary section is selected");
		}
		else {
			System.out.println("Primary section not selected");
		}
		
		//5. get the total no. of email in the Primary tab
		List<WebElement> mails = driver.findElements(By.xpath("//tr[@class='zA zE']"));
		
		System.out.println("No of unread mails present is : "+mails.size());
		
		//6.get the name of the sender and subject of nth element of inbox
		
		Thread.sleep(5000);
		
		WebElement name=driver.findElement(By.xpath("//div[@id=':5m']//span[@class='zF']"));
		System.out.println("name of the sender is : "+name.getAttribute("email"));
		
		WebElement sub=driver.findElement(By.xpath("//div[@class='y6']//span[@class='bqe']"));
		System.out.println("subject is : "+sub.getText());
	
		
		try {
			Runtime.getRuntime().exec("taskkill /im firefox.exe /F");
		}catch(IOException e) {
			e.printStackTrace();
		}

		
		
		

	}

}
