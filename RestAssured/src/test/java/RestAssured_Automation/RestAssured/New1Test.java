package RestAssured_Automation.RestAssured;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class New1Test {
  @Test
  public void Hooq() throws Exception
  {
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\soume\\git\\RestAssured\\RestAssured\\Driver\\chromedriver.exe");
  WebDriver driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

  driver.get("https://www.hotstar.com");
  Thread.sleep(5000);
  driver.findElement(By.xpath("//div[@class='signIn']")).click();
  driver.findElement(By.xpath("//div[@class='email-fb-button']")).click();
  driver.findElement(By.xpath("//input[@class='form-control']")).click();
  driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("saumyajit21@gmail.com");
  Thread.sleep(3000);
  driver.findElement(By.xpath("//button[@class='submit-button']")).click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("9051480812");
  driver.findElement(By.xpath("//button[@class='submit-button']")).click();
  Thread.sleep(5000);
  driver.findElement(By.xpath("//input[@id='searchField']")).click();
  Thread.sleep(5000);
  driver.findElement(By.xpath("//input[@id='searchField']")).sendKeys("Supergirl");
  Thread.sleep(5000);
  driver.findElement(By.xpath("//div[@class='search-wrap']")).click();
  Thread.sleep(3000);
 
  
  //Initially list is declared before the loop it get its first element and when navigate back 2nd element got disappeared
  //Now we are using two lists one declared before the for loop ,to get the size and iterate through
  //2nd list is always a fresh list which always have all the list of elements  
 // problem occurs because when u navigate back again, that element is no longer valid. To avoid this kind of situation, use the below code:


  
  
	 List<WebElement> ele =driver.findElements(By.xpath("//div[@class='title ellipsize']/span[contains(text(),'Season')]"));
	 int size=ele.size();
	  for(int i=0;i<size;i++){
		  
			 List<WebElement> elementsinloop =driver.findElements(By.xpath("//div[@class='title ellipsize']/span[contains(text(),'Season')]"));
			 Thread.sleep(5000);
			 elementsinloop.get(i).click();
			 Thread.sleep(2000);
			 driver.navigate().back();
			 Thread.sleep(2000);
	}

		
	}
	
		
  
		  
	  
	  
  }
  
  





