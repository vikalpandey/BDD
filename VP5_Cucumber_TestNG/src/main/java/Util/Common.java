package Util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.AbstractParallelWorker.Arguments;

import com.cucumber.listener.Reporter;

import Stepimplementions.LoginPage_steps;



//import Base.DriverInstance;

public class Common extends TestBase{
	
	
	MyWait mywaito=new MyWait();
	
	//13 june 2020
	// Action ------------------------------------------
	public static void action(WebDriver driver, WebElement locator) {
		Actions act = new Actions(driver);
		act.moveToElement(locator).build().perform();
		// where we call this method then we move to submenu using
		// driver.fin.submenu.click etc..
		//Note= .perform() or build().perform() = doing the same thing 
	}

	public static void actionclick(WebDriver driver, WebElement Locator, WebElement submenu) throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(Locator).build().perform();
		Thread.sleep(4000);
		act.moveToElement(submenu);
		act.click().build().perform();
		waitForPageLoaded(driver);
		
	}
	// other action methods from gaurav below
	/*
	 * This method is used to move to element through action class
	 */
//	public void moveToElementThroughAction(WebDriver driver, WebElement element) throws Exception {
//		moveToElement(driver, element);
//		try {
//			Actions actobj = new Actions(driver);
//			actobj.moveToElement(element).perform();
//		} catch (Exception e) {
//			Reporter.log(e.getMessage());
//			//throwsException("Unable to move to Element::" + element);
//		}
//	}
	
//---------------     Wait Start 	
//	for explicit wait we have to just create a object of WebDriverWaitclass then use the expectedcondition class methods
//	WebDriverWait wait=new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='adminWrap active']"))).click();
	
	

	// Wait------------------------------------------
	public static void waitForElementvisible(WebDriver driver, By locator) {
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			// System.out.println(" Common class - element is visible-: ="+
			// locator);
		} catch (Exception e) {
			String timeOutMessage = "common class= timeout msg element not found" + locator;
			throw new IllegalStateException(timeOutMessage);
		}
	}

	public static void waitForElementtobeclickable(WebDriver driver, By locator) throws Exception {
		Thread.sleep(2000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void Fluentwait(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	public static String waitForPageTitle(WebDriver driver, String Expectedtitle) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Expectedtitle));
		return driver.getTitle();
	}



	// ---------------Loader----- JS-- Wait For Page To Load – Method #1

	public static void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("common method waitForPageLoaded msg =Timeout waiting for Page Load Request to complete.");
		}
	}

	// -----------Loader ------ JS-- Wait For Page To Load – Method #2

	public static void waitForLoad(WebDriver driver) {
		//System.out.println("waitForLoad started");
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(pageLoadCondition);
	}

	public static void checkPageIsLoaded(WebDriver driver) throws Exception {
		try {
			driver.getCurrentUrl();
		} catch (Exception E) {
			throw new Exception(E.getMessage());
		}
	}
//Tools QA  -: Wait for Ajax call to finish
//https://www.toolsqa.com/selenium-cucumber-framework/handle-ajax-call-using-javascriptexecutor-in-selenium/
	
	public static void waituntilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){ // ex -:time =60L 
		until(driver, (d) ->
			{
			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
			}, timeoutInSeconds);
	}
	
	
	
	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
		try{
			webDriverWait.until(waitCondition);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}          
	}
	
//Tools QA -:   Wait for Page Load using JavaScriptExecutor in Selenium
	public static void waituntilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->
			{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}
	
///////////Tools qa wait end here 
	
	public static void shortwait3(WebDriver driver) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void mediumwait6(WebDriver driver) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void longwait10(WebDriver driver) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
///Wait end /////////////	
	// -----------Handling dropdown -----------------------------------------
	public static void Selectbyvisibletext(WebElement locator, String VisibleText) {
		Select selObj = new Select(locator);
		selObj.selectByVisibleText(VisibleText);
	}
	public static void Selectbyvisibletext(By by, String VisibleText) {
		WebElement element=driver.findElement(by);
//		Select selObj = new Select(element);
//		selObj.selectByVisibleText(VisibleText);
		Selectbyvisibletext(element, VisibleText);
	}
	public static void Selectbyindex(WebElement locator, int IndexValue) {
		Select selObj = new Select(locator);
		selObj.selectByIndex(IndexValue);
	}
	public static void Selectbyvalue(WebElement locator, String Value) {
		Select selObj = new Select(locator);
		selObj.selectByValue(Value);
	}
	
	private boolean SelectDropDownValue(WebDriver driver, Select dropDown, String selectType, String value)
			throws Exception {
		Thread.sleep(2000);
		if (selectType.equalsIgnoreCase("visibletext")) {
			try {
				dropDown.selectByVisibleText(value);
				return true;
			} catch (Exception e) {
			}
		} else if (selectType.equalsIgnoreCase("value")) {
			try {
				dropDown.selectByValue(value);
				return true;
			} catch (Exception e) {
			}
		} else if (selectType.equalsIgnoreCase("index")) {
			try {
				dropDown.selectByIndex(Integer.parseInt(value));
				return true;
			} catch (Exception e) {
			}
		}
		return false;
	}
	

	/*
	 * This method is used to select drop down value
	 */
	public String getSelectedDropDownValue(WebDriver driver, WebElement element) throws Exception {
		System.out.println("Get Selected Value From Drop Down" + element);

		moveToElement(driver, element);
		Select select = new Select(element);
		List<WebElement> values = select.getAllSelectedOptions();
		String value = values.get(0).getText();
		return value;
	}
	
	//...... select text from the list, like from autocomplete text box   ..
	//https://www.seleniumeasy.com/selenium-tutorials/working-with-ajax-or-jquery-auto-complete-text-box-using-webdriver
		public static void selectOptionWithText(String textToSelect , By AutoCompletelistbox) {
			try {
				       //WebElement autoOptions = driver.findElement(By.id("AutoComplete_listbox"));
				//By AutoCompletelistbox=By.id("AutoComplete_listbox");
				Common.waitForElementvisible(driver, AutoCompletelistbox);
				                //wait.until(ExpectedConditions.visibilityOf(autoOptions));
				List<WebElement> optionsToSelect=driver.findElements(By.tagName("li"));

				                 //List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
				for(WebElement option : optionsToSelect){
			        if(option.getText().equals(textToSelect)) {
			        	System.out.println("Trying to select: "+textToSelect);
			            option.click();
			            break;
			        }
			    }
			} catch (NoSuchElementException e) {
				System.out.println(e.getStackTrace());
			}
			catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		
		
		public static void selectOptionWithIndex(int indexToSelect, By locator_AutoCompletelistbox,By locator_li_list) {
			
			try {
				//WebElement autoOptions = driver.findElement(By AutoCompletelistbox);
				//wait.until(ExpectedConditions.visibilityOf(autoOptions));
				Common.waitForElementvisible(driver, locator_AutoCompletelistbox);
				System.out.println(" (inside selectOptionWithIndex method) and waiting for "+locator_AutoCompletelistbox );

				//List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
				List<WebElement> optionsToSelect_list=driver.findElements(locator_li_list);
				System.out.println("print optionsToSelect_list.size= "+optionsToSelect_list.size());
			        if(indexToSelect<=optionsToSelect_list.size()) {
			        	System.out.println("Trying to select based on index: "+indexToSelect);
			        	Thread.sleep(2000);
			           optionsToSelect_list.get(indexToSelect).click();
			           Thread.sleep(2000);
			       
			        }
			} 		
			catch ( Exception e) {
				System.out.println(e);
			}
		}
		//>>>>>>>>>>>>>>>>>>>>>>>>>>
public static void selectOptionWithIndex2(int indexToSelect, By locator_AutoCompletelistbox,By locator_li_list) {
			
			try {
				WebElement autoOptions = driver.findElement( locator_AutoCompletelistbox);
				waitForElementvisible(driver, locator_AutoCompletelistbox);
				//  Common.waitForElementvisible(driver, AutoCompletelistbox);
				
				List<WebElement> optionsToSelect_list =autoOptions.findElements(locator_li_list);
				//List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
				//List<WebElement> optionsToSelect_list=driver.findElements(By.tagName("li"));
			        if(indexToSelect<=optionsToSelect_list.size()) {
			        	System.out.println("Trying to select based on index: "+indexToSelect);
			        	Thread.sleep(2000);
			           optionsToSelect_list.get(indexToSelect).click();
			           Thread.sleep(2000);
			       
			        }
			} 		
			catch ( Exception e) {
				System.out.println(e);
			}
		}
		
//-----                Calander       ---------
// Function to select the day of the month in the date time picker.
//https://www.techbeamers.com/handle-date-time-picker-control-using-webdriver/
	public static void HandleKendoDateTimePicker_Calander(String day,By locator_day)
			throws InterruptedException {

		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-content")));
		Common.waitForElementvisible(driver, locator_day);
		
		//WebElement table = browser.findElement(By.className("k-link"));
		WebElement table=driver.findElement(locator_day);
		System.out.println("inside Kendo Calendar");
		
		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(day)) {
					driver.findElement(By.linkText(day)).click();
				}
			}
		}
		Thread.sleep(2000);
	}



	

	// -----------Take Snapshot for analysing the failures
	public String TakeSnapshot(WebDriver driver, String DestFilePath) throws IOException {
		String TS = GetTimeStamp();
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfileObj = tss.getScreenshotAs(OutputType.FILE);
		DestFilePath = DestFilePath + TS + ".png";
		File DestFileObj = new File(DestFilePath);
		FileUtils.copyFile(srcfileObj, DestFileObj);
		// FileHandler.copy(srcfileObj, DestFileObj);// if fileutils give the
		// erro
		return DestFilePath;
	}


	// **********************************************************************
		//**********************************************************************
	//Java script executor  Execute script -to execute java script code (By naveen automation labs.com)
	//https://www.youtube.com/watch?v=PGPlL0zP7Ik
	
	public static void flash(WebDriver driver , WebElement element) // highlight element
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String bgcolor= element.getCssValue("backgroundcolor");
		for (int i = 0; i < 2; i++) {
			changecolor(driver, element, "rgb(0,200,0)");
			changecolor(driver, element, bgcolor);			
		}
	}
	
	public static void changecolor(WebDriver driver , WebElement element,String color)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public static void genratealert(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('message')");
	}
	
	public static void clickElementByJS( WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);  	
	}
	
	public static void refreshBrowserByJS()
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go[0]");  	
	}
	public static String getTitleByJS()
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title=js.executeScript("return document.title;").toString(); 
		return title;
	}
	public static String getPageInnerTextByJS()
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString(); 
		return pageText;
	}
	//Below method is working fine
	public static void scrollPageDownByJS()
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	// scroll into view till the perticular element visible , ex - facebook post 
	//search hotels & scroll down untill the hotel name found  
	public static void scrollUpToElementByJS(WebDriver driver, WebElement element) // keep scrolling untill the element is visible 
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(True);",element);
	}
	
	/*
	 * This method is used to move to element using java scrpit executor  on the page.
	 */
	public WebElement moveToElement(WebDriver driver, WebElement element) throws Exception {
		try {
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", element);
			((JavascriptExecutor) driver).executeScript(
					"window.scrollBy(0,-100);window.scrollBy(-75,0);", element);
		} catch (Exception e) {
		}
		return element;
	}

	/*
	 * This method is used to move to element on the page.
	 */
//	public WebElement moveToElement(WebDriver driver, String elt) throws Exception {
//		WebElement element = getElementfromText(driver, elt);
//		try {
//			Thread.sleep(500);
//			((JavascriptExecutor) driver).executeScript(
//					"arguments[0].scrollIntoView(true);window.scrollBy(0,-100);window.scrollBy(-75,0);", element);
//		} catch (Exception e) {
//		}
//		return element;
//	}

	
	
	
	// **********************************************************************
	//**********************************************************************
	
	public static void sendkeys(By by, String value)
	{
		try {
		isDisplayed_fn(by);
		//Expectedcondiation.elementtobeclickable(by)
		driver.findElement(by).click();
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		Assert.assertTrue(true, "value" + value + "is not entered in the " + by + "field");	
		} catch (Exception e) {
			System.out.println("some exception coming in send keys method = "+e);
		}
	}
	public static void click(By by)
	{
		try {
		isDisplayed_fn(by);
		//Expectedcondiation.elementtobeclickable(by)
		driver.findElement(by).click();
		Assert.assertTrue(true, "Element" + by + "is not clicked on the application");
		} catch (Exception e) {
			System.out.println("VP= some exception is comming in clicking the element and exceptin is =" +e);
		}
	}
	
//	 public boolean isElementDisplayed(By element) {
//	 try {
//	 return getElement(element).isDisplayed();
//	 } catch (Exception e) {
//	 System.out.println("Some exception occurred while checking webelement displayed " + element);
//	 return false;
//	 }
//	 }
	
	// public boolean isElementDisplayed(By locator) {
	// try {
	// return getElement(locator).isDisplayed();
	// } catch (Exception e) {
	// System.out.println("Some exception occurred while checking webelement
	// displayed " + locator);
	// return false;
	// }
	// }
	
	
	public static boolean isDisplayed_fn(By by)
	{
		try {
		driver.findElement(by).isDisplayed();
		return true;
		} catch (Exception e) {
			return false;
		}
	}
	//https://medium.com/automation-reference/iselementpresent-8becc97c2265
	public static boolean isElementPresent(By by) {
		  try {
		    driver.findElements(by);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }
		}

	
	/**
	* If a element is present, returns true, else return false
	* @param WebElement whose presence is being checked
	* @return true if webElement is present, else false
	*/
	public static boolean isElementPresent(WebElement webelement) {
	  boolean exists = false;
	  try {
	    webelement.getTagName();
	    exists = true;
	  } catch (NoSuchElementException e) {
	    // nothing to do.
	  }
	  return exists;
	}
	
	
	
	
	
	public static boolean isElementPresentUsingSize(By by)
	{
		
			int size=driver.findElements(by).size();
			if (size==0) {
				return false;
			}
			else {
				return true;
			}
		}

	private static void clear(WebElement element) throws Exception
	{
		try { element.clear();
		} catch (Exception e) {
		}
	}
	public static void clearelement(By by) throws Exception
	{
		WebElement element=driver.findElement(by);
		clear(element);
	}
		
	
	public static WebElement getElement(WebElement element) throws Exception {
		try {
			if (element.isDisplayed() == true || element.isEnabled() == true) {
				return element;
			}
		} catch (Exception e) {

		}
		return element;
	}
		

	
	/*
	 * To check if the text is present on the page or not
	 */
	public void isTextDisplayed(WebDriver driver, String content, String throwMessage) throws Exception {
		try {
			List<WebElement> element = driver.findElements(By.xpath(".//*[contains(text(),'" + content + "')]"));
			if (element.size() < 1) {	
			}
		} catch (Exception e) {	
		}
	}

	// Check this method
	/*
	 * This method is used to check if the element is present or not
	 */
	public boolean verifyElementOnVisible(WebDriver driver, WebElement element) {
		boolean status = false;
		try {
			moveToElement(driver, element);
			status = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.addStepLog(e.getMessage());
			status = false;
		}
		return status;
	}
	/*
	 * To check if the elements is present or not
	 */
	public boolean isElementPresent(List<WebElement> elements) {
		if (elements.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * To check if the element is present or not
	 */
	public boolean isElementPresent(WebDriver driver, WebElement element) {
		try {
			moveToElement(driver, element);
			element.isEnabled();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresent(WebDriver driver, String xpath) {
		try {
			WebElement element = moveToElement(driver, driver.findElement(By.xpath(xpath)));
			element.isEnabled();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isSelected(WebDriver driver, WebElement element) {
		try {
			moveToElement(driver, element);
			if (element.isSelected()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}



	public WebElement getElement(WebDriver driver, WebElement element) throws Exception {
		try {
			if (element.isDisplayed() == true || element.isEnabled() == true) {
				return element;
			}
		} catch (Exception e) {

		}
		return element;
	}

	
	
	
	
	
	
	
	
	
	
	

	/*
	 * This method is used to get text from field
	 */
	public String getText(WebDriver driver, WebElement element) throws Exception {
		String text = null;
		moveToElement(driver, element);
		try {
			text = element.getText().trim();
		} catch (Exception e) {
			Reporter.addStepLog(e.getMessage());
			System.out.println("Unable to get Text");
		}
		return text;
	}

	/*
	 * This method is used to get text field value
	 */
	public String getTextTxtFldvalue(WebDriver driver, WebElement element) throws Exception {
		String txt = null;
		moveToElement(driver, element);
		try {
			txt = element.getAttribute("value").trim();
		} catch (Exception e) {
			Reporter.addStepLog(e.getMessage());
			System.out.println("Unable to get Text from field");
		}
		return txt;
	}

	
	// Get current Time-stamp-----------------------
	public String GetTimeStamp() {
		DateFormat DF = DateFormat.getDateTimeInstance();
		Date dte = new Date();
		String DateValue = DF.format(dte);
		// DateValue=DateValue.replaceAll(":", "_");
		DateValue = DateValue.replaceAll(",", "");
		return DateValue;
	}

	/*
	 * This method is used to get current date us format
	 */
	public String getCurrentDateUSFormat() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	// Actual USA Time ZOne Date
	public String getCurrentDateUSTimeZone() {
		TimeZone obj = TimeZone.getTimeZone("GMT-5");
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
		sdfDate.setTimeZone(obj);
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	/*
	 * This method is used to get future date in us format
	 */
	public String getFutureDateUSFormat(int afterNoOfDays) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
		Date now = DateUtils.addDays(new Date(), afterNoOfDays);
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
	/**
	 * 
	 * This method will return date and time in format MM/dd/yyyy hh:mm aa
	 */
	public String getCurrentDateAndTime() {
		DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
		String dateString2 = dateFormat2.format(new Date()).toString();
		return dateString2;
	}

	/**
	 * 
	 * This method will return date in format MM/dd/yyyy
	 */
	public String getCurrentDate() {
		DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
		String dateString2 = dateFormat2.format(new Date()).toString();
		String arraydate[] = dateString2.split(" ");
		String date = arraydate[0];
		return date;
	}
	
	
	
	
	

}
