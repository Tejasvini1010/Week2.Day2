package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		
		driver.findElement(By.xpath("//a[@href = 'Button.html']")).click();
		System.out.println("This is the page I am supposed to go");
		driver.navigate().back();
		
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		if (title1.equals("HTTP Status 404 – Not Found")) {
			System.out.println("This URL is broken");
		} else {
			System.out.println("This URL is not broken");
		}
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Go to Home Page")).click(); 

	}

}
