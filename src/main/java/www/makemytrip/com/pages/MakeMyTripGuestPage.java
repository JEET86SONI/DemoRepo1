package www.makemytrip.com.pages;

import java.util.Calendar;

import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import www.makemytrip.com.base.BaseClass;

public class MakeMyTripGuestPage extends BaseClass {

@FindBy(xpath = ".//*//a[@class ='active makeFlex hrtlCenter column']" )
WebElement flightLink;

@FindBy(xpath="(.//*//span[@class ='tabsCircle appendRight5'])[2]")
WebElement radioButton;
	
@FindBy(xpath =".//*//input[@id ='fromCity']")
WebElement fromInputField;

@FindBy(xpath="(//*[@class='react-autosuggest__suggestions-list']//li)[1]")
WebElement selectFrom;

@FindBy(xpath = ".//*//input[@id ='toCity']")
WebElement toInputFiled;

@FindBy(xpath="(//ul[@class='react-autosuggest__suggestions-list']//li)[1]")
WebElement selectTo;

@FindBy(xpath = ".//*//label[@for='departure']")
WebElement departure;

@FindBy(xpath = "(.//*//div[@class='DayPicker-Month'])[1]/div[3]")
WebElement datePickerTable;

@FindBy(xpath = ".//*//div[@class='DayPicker-Month'][1]/div[3]/div/div")
List<WebElement> caldays;

@FindBy(xpath = ".//*//label[@for='return']")
WebElement returnFlight;

@FindBy(xpath="//*[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")
WebElement searchBtn;


public MakeMyTripGuestPage() {
	PageFactory.initElements(driver, this);
	}
//click on Flight Link
public void flightLink() {
	flightLink.click();
}
//click on Radio Bttn
public void radioBtn() {
	radioButton.click();
}
//from function
public void fromFunc() {
	fromInputField.sendKeys("Delhi");
	selectFrom.click();
	}
//to Arrival
public void toArrival() {
	toInputFiled.sendKeys("Bangalore");
	selectTo.click();
	}

//Select Departure date
public void departureDate() {
	String todayDate = getCurrentDay();
	departure.click();
	for(WebElement cell:caldays) {
		if(cell.getText().equals(todayDate)) {
			cell.click();
		break;
		}
	}
	
}
//select arrival date
public void arrivalDate() {
	String futureDate = getFutureDay();
	returnFlight.click();
for(WebElement cell: caldays) {
	if(cell.getText().equals(futureDate)) {
		cell.click();
	}
}
}

//search Button Function 
public FlightDetailPage Search() {
	searchBtn.click();
	return new FlightDetailPage(driver);
}


//get Current day
public String getCurrentDay() {
	//Create a Calender Object
	Calendar calender  = Calendar.getInstance(TimeZone.getDefault());
	//get a Current date as a Number
int todayInt = calender.get(Calendar.DAY_OF_MONTH);
//Integer to String Conversion

String todayStr = Integer.toString(todayInt);

return todayStr;
}

//get Future day
public String getFutureDay() {
	//Create a Calender Object
	Calendar calender  = Calendar.getInstance(TimeZone.getDefault());
	//get a Current date as a Number
int todayInt = calender.get(Calendar.DAY_OF_MONTH);
//future date
int futureDate = todayInt + 7;
//Integer to String Conversion
String FutureStr = Integer.toString(futureDate);

return FutureStr;
}

}
