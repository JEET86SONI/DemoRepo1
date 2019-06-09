package www.makemytrip.com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import www.makemytrip.com.base.BaseClass;
import www.makemytrip.com.pages.MakeMyTripGuestPage;

public class GuestPageTest  extends BaseClass {

	public BaseClass baseclass;
	public WebDriver driver;
	public Properties prop;
	public MakeMyTripGuestPage mmtp;
	
	
	@BeforeClass
	public void setup() {
		baseclass = new BaseClass();
		setUp();
	}
	@Test()
	public void flightTest() {
		mmtp = new MakeMyTripGuestPage();
		mmtp.flightLink();
		mmtp.radioBtn();
	
	}
	
	@AfterClass(enabled = false)
	public void exist() {
	tearDown();
	}
	
}
