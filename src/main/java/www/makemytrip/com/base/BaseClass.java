package www.makemytrip.com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
public static  WebDriver driver;
public static Properties prop;
 public static String filePath = System.getProperty("user.dir")+"/src/main/java/www/makemytrip/com/config/config.properties";
 static FileInputStream fis = null;
 String browserName;
 
 public static void fileSetup() {


	try {
	 fis = new FileInputStream(new File(filePath));
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	prop = new Properties();
	try {
		prop.load(fis);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
 }
	
@BeforeTest
	public void setUp () {
	
	fileSetup();
browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
		}
			
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));	
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
	
	public void tearDown() {
		driver.quit();
	}
	
}
