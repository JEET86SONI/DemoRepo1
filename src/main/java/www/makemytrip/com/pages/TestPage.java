package www.makemytrip.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPage {

	public static void main(String[] args) throws Exception {
		
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.get("https://www.makemytrip.com/");
 driver.findElement(By.xpath(".//*//a[@class ='active makeFlex hrtlCenter column']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath("(.//*//span[@class ='tabsCircle appendRight5'])[2]")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath(".//*//input[@id ='fromCity']")).sendKeys("delhi");
 Thread.sleep(3000);
 driver.findElement(By.xpath("(//*[@class='react-autosuggest__suggestions-list']//li)[1]")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath(".//*//input[@id ='toCity']")).sendKeys("bangalore");
 Thread.sleep(3000);
 driver.findElement(By.xpath("(//ul[@class='react-autosuggest__suggestions-list']//li)[1]")).click();

	}

}
