package p1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.builds.test.admin.AdminDivisionAddDivisionPageTest;
import com.builds.test.admin.AdminUsersManageDivisionalUsersAddDivisionalUsersPageTest;
import com.builds.test.admin.AdminUsersManageRegionalUsersAddRegionalUserPageTest;
import com.builds.test.common.LoginPageTest;
import com.builds.test.infomgr.AdminInfoMgrCommonMethods;
import com.builds.test.infomgr.InfoMgr_Common;
import com.builds.test.infomgr.TasksCommonMethods;
import com.mysql.jdbc.Connection;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseUtil {


	private CodeUtility cu = new CodeUtility();
	FranconnectUtil fc = new FranconnectUtil();
	InfoMgr_Common imc = new InfoMgr_Common();
	
	@BeforeSuite(groups = { "infomgr","crm","opener","admin","fieldops","sales_OwnerAssignment","finance","thehub","Crm_Campaign_Visibility","sales","finance_FreshDB","training","DuplicateCriteria","support"})
	@TestCase(createdOn = "2018-12-24", updatedOn = "2018-12-31", testCaseId = "TC_ChangePasswordToNo_BeforeSuite", testCaseDescription = "Test to change the Password Setting to NO in Before Suite Method", reference = {
			"" })
	public void InfoMgr_ChangeForcePwdChangetoNo() throws Exception {
		String testCaseId = fc.utobj().readTestCaseInfo(this.getClass().getName() + "." + new Object() {
		}.getClass().getEnclosingMethod().getName());

		boolean isPassed = false;
		WebDriver driver = null;

		for (int i = 0; i < 3; i++) {
			if (!isPassed) {
				try {
					driver = fc.commonMethods().browsers().openBrowser();
					fc.loginpage().login(driver);
					imc.setForceChangePwdonFirstLoginToNo(driver);
					fc.utobj().logoutAndQuitBrowser(driver, testCaseId);
					isPassed = true;
					break;
				} catch (Exception e) {
					isPassed = false;
					fc.utobj().quitBrowserOnCatch(driver, e, testCaseId);
					
				}
			}
		}
	}
	
	
	public static ExtentReports reports;// =new
	// ExtentReports("E:\\Tutorials\\SeleniumPractice\\Reports\\results.html",true);

	public ExtentTest starttestcase(Map<String, String> config, String testCaseId) {
		return reports.startTest(testCaseId);
	}

	/*
	 * Select More Action Menu in the build
	 */
	public void selectMoreActionMenu(WebDriver driver, WebElement moreActionsLink, List<WebElement> menu,
			String menuName) throws Exception {

		moveToElement(driver, moreActionsLink);
		int menuPos = 0;
		try {
			Actions actobj = new Actions(driver);
			actobj.moveToElement(moreActionsLink).perform();
			menuPos = -2;
			for (int x = 0; x < menu.size(); x++) {
				// if (menu.get(x).getText().trim().equals(menuName))
				if (menu.get(x).getText().trim().equalsIgnoreCase(menuName)) {
					menuPos = x;
				}
			}
		} catch (Exception e) {
			throwsException("Unable to move to Element::" + menuName);
		}
		if (menuPos != -2) {
			clickElementWithoutMove(driver, menu.get(menuPos));
		} else {
			throwsException("Value :" + menuName + ", is not present in the Action Menu");
		}
	}

	/*
	 * This method clicks on element Actions Class instruction.
	 */
	public void clickElementWithActions(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Click", element);

		try {
			Actions builder = new Actions(driver);
			MyWaitClass wait = new MyWaitClass();
			element = wait.getElementOnClickable(driver, element);
			builder.moveToElement(element).click(element).build().perform();
		} catch (Exception e) {
			throwsException("Unable to click Element : " + element);
		}
	}

	// To handle stale element exception
	public void waitForElement(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Click", element);

		try {

			MyWaitClass wait = new MyWaitClass();
			wait.waitForElementPresent(driver, element);

		} catch (Exception e) {
			throwsException("Unable to click Element : " + element);
		}
	}

	/*
	 * This method is used to accept Alert Box
	 */
	public String acceptAlertBox(WebDriver driver) throws Exception {

		printBugStatus("Accept Alert");

		MyWaitClass waitMethod = new MyWaitClass();
		String msg = "";
		try {
			Alert alert = waitMethod.getAlert(driver);
			msg = alert.getText().trim();
			alert.accept();
		} catch (Exception e) {
			throwsException("The Test Case Expected Alert message to appear, which is not present");
		}
		return msg;
	}

	/*
	 * This method is used to Dismiss Alert Box
	 */
	public String dismissAlertBox(WebDriver driver) throws Exception {

		printBugStatus("Dismiss Alert");

		MyWaitClass waitMethod = new MyWaitClass();
		String msg = "";
		try {
			Alert alert = waitMethod.getAlert(driver);
			msg = alert.getText().trim();
			alert.dismiss();
		} catch (Exception e) {
			throwsException("The Test Case Expected Alert message to appear, which is not present");
		}

		return msg;
	}

	public void acceptDismissAlertBoxOnTextCondition(WebDriver driver, String expectedText) throws Exception {

		printBugStatus("Get Text Alert");

		MyWaitClass waitMethod = new MyWaitClass();
		String msg = "";
		try {
			Alert alert = waitMethod.getAlert(driver);
			msg = alert.getText().trim();
			if (msg.contains(expectedText)) {
				alert.accept();

			} else
				alert.dismiss();

		} catch (Exception e) {
			throwsException("The Test Case Expected Alert message to appear, which is not present");
		}

	}

	/*
	 * This method is used to Click on the link
	 */
	public void clickLink(WebDriver driver, String linkText) throws Exception {

		printDetailedTestStep("Click Link", linkText);

		try {
			MyWaitClass wait = new MyWaitClass();
			WebElement element = wait.getElementOnClickable(driver, "linkText", linkText);
			moveToElement(driver, element);
			click(driver, element);
		} catch (Exception e) {
			throwsException("Unable to click on the link : " + linkText);
		}
	}

	/*
	 * This method is used to Click on Link (Ignore Case)
	 */
	public void clickLinkIgnoreCase(WebDriver driver, String linkText) throws Exception {

		printDetailedTestStep("Click Link (Partial)", linkText);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		boolean isLinkFound = false;
		for (WebElement link : links) {
			if (link.getText().equals(linkText)) {
				isLinkFound = true;
				clickLink(driver, link.getText());
				break;
			}
		}

		if (isLinkFound == false) {
			for (WebElement link : links) {
				if (link.getText().equalsIgnoreCase(linkText)) {
					isLinkFound = true;
					clickLink(driver, link.getText());
					break;
				}
			}
		}

		if (isLinkFound == false) {
			throwsException("Unable to Find link : " + linkText);
		}
	}

	/*
	 * This method is used on click on partial link text
	 */
	public void clickPartialLinkText(WebDriver driver, String partiallinkText) throws Exception {

		printDetailedTestStep("Click Link (Partial)" + partiallinkText);

		WebElement element = null;
		;
		try {
			element = getElementByPartialLinkText(driver, partiallinkText);
		} catch (Exception e) {
			throwsException("Unable to click on the link : " + partiallinkText);
		}
		moveToElement(driver, element);
		click(driver, element);
	}

	/*
	 * This method is used to select value in Action Menu
	 */
	public void selectActionMenuItems(WebDriver driver, String menuName) throws Exception {

		WebElement moreActionsLink = null;
		List<WebElement> menu = null;
		try {
			moreActionsLink = getElementByXpath(driver, ".//input[@value='Actions' and @type='button']");
		} catch (Exception e) {
			throwsException("Unable to find Element::" + moreActionsLink);
		}
		moveToElement(driver, moreActionsLink);
		clickElement(driver, moreActionsLink);
		try {
			menu = driver
					.findElements(By.xpath(".//*[@id='actionListButtons']/table/tbody/tr[2]/td[2]/table/tbody//td"));
		} catch (Exception e) {
			throwsException("Unable to find Element::" + menu);
		}
		selectMoreActionMenu(driver, moreActionsLink, menu, menuName);
	}

	/*
	 * This method is used to select value in Action Menu(Of tag A)
	 */
	public void selectActionMenuItemsWithTagA(WebDriver driver, String menuName) throws Exception {
		WebElement moreActionsLink = null;
		List<WebElement> menu = null;
		try {
			moreActionsLink = getElementByXpath(driver,
					(".//a[@class='showActionSum link-btn' or @class='showAction link-btn' and .='Actions']"));
		} catch (Exception e) {
			throwsException("Unable to find Element:: " + moreActionsLink);
		}
		moveToElement(driver, moreActionsLink);
		clickElement(driver, moreActionsLink);
		sleep();
		try {
			menu = driver
					.findElements(By.xpath(".//*[@id='actionListButtons']/table/tbody/tr[2]/td[2]/table/tbody//td"));
		} catch (Exception e) {
			throwsException("unable to find Element :" + menu);
		}
		selectMoreActionMenu(driver, moreActionsLink, menu, menuName);
	}

	/*
	 * This method is used to select value in Action Menu(Of tag A)
	 */
	public void selectActionMenuItemsWithTagAMoreActions(WebDriver driver, String menuName) throws Exception {
		WebElement moreActionsLink = null;
		List<WebElement> menu = null;
		try {
			moreActionsLink = getElementByXpath(driver,
					".//a[@class='showAction_leadDetails link-btn' or @class='showActionMore link-btn text_b' and .='More Actions']");
		} catch (Exception e) {
			throwsException("unable to find element::" + moreActionsLink);
		}
		moveToElement(driver, moreActionsLink);
		sleep();

		try {
			menu = driver.findElements(By.xpath(
					".//*[@id='actionListButtons' or @id='actionListButtonsForCMLead']/table/tbody/tr[2]/td[2]/table/tbody//td"));
		} catch (Exception e) {
			throwsException("unable to find element::" + menu);
		}
		selectMoreActionMenu(driver, moreActionsLink, menu, menuName);
	}

	/*
	 * This method is used to select value in Action Menu(Of tag Input)
	 */
	public void selectActionMenuItemsWithTagInput(WebDriver driver, String menuName) throws Exception {
		WebElement moreActionsLink = null;
		List<WebElement> menu = null;
		try {
			moreActionsLink = getElementByXpath(driver, ".//input[@class='cm_new_button_action showAction']");
		} catch (Exception e) {
			throwsException("Unable to find Element:: " + moreActionsLink);
		}
		moveToElement(driver, moreActionsLink);
		clickElement(driver, moreActionsLink);
		sleep();
		try {
			menu = driver
					.findElements(By.xpath(".//*[@id='actionListButtons']/table/tbody/tr[2]/td[2]/table/tbody//td"));
		} catch (Exception e) {
			throwsException("unable to find Element::" + menu);
		}
		selectMoreActionMenu(driver, moreActionsLink, menu, menuName);
	}

	/*
	 * This method is used to Switch the frame
	 */
	public void switchFrame(WebDriver driver, WebElement frame) throws Exception {

		printDetailedTestStep("Switch Frame", frame);

		MyWaitClass waitMethod = new MyWaitClass();
		waitMethod.switchFrame(driver, frame);
	}

	public void switchFrame(WebDriver driver, String frame) throws Exception {

		printDetailedTestStep("Switch Frame", frame);

		MyWaitClass waitMethod = new MyWaitClass();
		waitMethod.switchFrame(driver, frame);
	}

	/*
	 * This method is used to Switch the frame
	 */
	public void switchFrameByClass(WebDriver driver, String className) throws Exception {

		printDetailedTestStep("Switch Frame", className);

		MyWaitClass waitMethod = new MyWaitClass();
		waitMethod.switchFrameByClass(driver, className);
	}

	/*
	 * This method is used to Switch the frame by frame id
	 */
	public WebDriver switchFrameById(WebDriver driver, String frameId) throws Exception {

		printDetailedTestStep("Switch Frame", frameId);

		MyWaitClass waitMethod = new MyWaitClass();
		return waitMethod.switchFrameById(driver, frameId);
	}

	/*
	 * This method is used to switch frame to defaults
	 */
	public WebDriver switchFrameToDefault(WebDriver driver) throws Exception {
		sleep(2500);
		driver.switchTo().defaultContent();
		sleep(2500);
		return driver;
	}

	// Akshat
	// SWITCH TO PARENT FRAME // switches back to just one higher frame
	public WebDriver switchToParentFrame(WebDriver driver) throws Exception {
		sleep(2500);
		driver.switchTo().parentFrame();
		sleep(2500);
		return driver;
	}

	// Check this method //edit by akshat
	public void singleActionIcon(WebDriver driver, String takeAction) throws Exception {
		int menuPos = -1;
		String strRegEx = "amp; ";
		getElementByXpath(driver, ".//div[@id='menuBar']/layer/a/img").click();
		List<WebElement> menu = driver
				.findElements(By.xpath(".//table[@id='siteMainTable']/tbody/tr/td//div/div/span"));

		for (int x = 0; x < menu.size(); x++) {
			String foundAction = menu.get(x).getAttribute("innerHTML");
			foundAction = foundAction.replace("&nbsp;", "").trim();
			if (foundAction.contains("&amp;"))
				foundAction = foundAction.replaceAll(strRegEx, " ");
			if (foundAction.equalsIgnoreCase(takeAction)) {
				menuPos = x;
			}
		}
		WebElement element = menu.get(menuPos);
		moveToElement(driver, element);
		menu.get(menuPos).click();
	}

	/*
	 * This method is used to move to element on the page.
	 */
	public WebElement moveToElement(WebDriver driver, WebElement element) throws Exception {
		try {
			sleep(500);
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
	public WebElement moveToElement(WebDriver driver, String elt) throws Exception {
		WebElement element = getElementfromText(driver, elt);
		try {
			sleep(500);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);window.scrollBy(0,-100);window.scrollBy(-75,0);", element);
		} catch (Exception e) {
		}
		return element;
	}

	public void clickElement(WebDriver driver, WebElement element) throws Exception {
		FranconnectUtil fc=new FranconnectUtil();
		printDetailedTestStep("Click", element);
		MyWaitClass waitMethod = new MyWaitClass();
		element = moveToElement(driver, element);
		try {
			waitMethod.getElementOnClickable(driver, element);
			click(driver, element);
		}
		catch(Exception e) {
			fc.utobj().clickElementByJS(driver, element);
		}
		
	}

	public void clickElement(WebDriver driver, String Xpath) throws Exception {
		printDetailedTestStep("Click", Xpath);
		WebElement element = getElementfromTextOnClickable(driver, Xpath);
		MyWaitClass waitMethod = new MyWaitClass();
		element = moveToElement(driver, element);
		waitMethod.getElementOnClickable(driver, element);
		Thread.sleep(2000);
		click(driver, element);
	}

	/*
	 * public void clickElement(WebDriver driver, WebElement element) throws
	 * Exception {
	 * 
	 * try { printDetailedTestStep("Click", element); click(driver, element); }
	 * catch (Exception e) { printDetailedTestStep("Click", element); MyWaitClass
	 * waitMethod = new MyWaitClass(); element = moveToElement(driver, element);
	 * waitMethod.getElementOnClickable(driver, element); click(driver, element); }
	 * 
	 * }
	 * 
	 * public void clickElement(WebDriver driver, String Xpath) throws Exception {
	 * WebElement element = getElementfromTextOnClickable(driver, Xpath); try {
	 * printDetailedTestStep("Click", Xpath); click(driver, element); } catch
	 * (Exception e) { MyWaitClass waitMethod = new MyWaitClass(); element =
	 * moveToElement(driver, element); waitMethod.getElementOnClickable(driver,
	 * element); Thread.sleep(2000); click(driver, element); }
	 * 
	 * }
	 */

	private WebElement getElementfromText(WebDriver driver, String elt) throws Exception {
		if (elt.contains("xpath=#")) {
			elt = elt.replace("xpath=#", "");
			return getElementOnVisible(driver, "xpath", elt);
		} else if (elt.contains("linkText=#")) {
			elt = elt.replace("linkText=#", "");
			return getElementOnClickable(driver, "linkText", elt);
		} else {
			return getElementOnVisible(driver, "xpath", elt);
		}
	}

	private WebElement getElementfromTextOnClickable(WebDriver driver, String elt) throws Exception {
		if (elt.contains("xpath=#")) {
			elt = elt.replace("xpath=#", "");
			return getElementOnClickable(driver, "xpath", elt);
		} else if (elt.contains("linkText=#")) {
			elt = elt.replace("linkText=#", "");
			return getElementOnClickable(driver, "linkText", elt);
		} else {
			return getElementOnClickable(driver, "xpath", elt);
		}
	}

	/*
	 * This method Double Clicks on Element
	 */
	public void doubleClickElement(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Double Click", element);

		moveToElement(driver, element);
		sleep(200);
		Actions action = new Actions(driver);
		try {
			action.doubleClick(element).perform();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			printBugStatus("Error in finding element : " + element);
			try {
				throwsException("element not visible : " + element);
			} catch (Exception e1) {
				Reporter.log(e1.toString());
				e1.printStackTrace();
			}
			action.doubleClick(element).perform();
		}
	}

	public void dragAndDropElement(WebDriver driver, WebElement element1, WebElement element2) throws Exception {
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(element1).moveToElement(element2)
				.release(element2).build();
		dragAndDrop.perform();
	}

	/*
	 * Click Enter on Any Element through Keys.Return
	 */
	public void clickEnterOnElement(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Click Enter", element);

		moveToElement(driver, element);

		try {
			click(driver, element);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}

		sleep(500);
		logReport("Pressing Enter on Element : ", element);
		element.sendKeys(Keys.RETURN);
	}

	/*
	 * This method clicks on element without move instruction.
	 */
	public void clickElementWithoutMove(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Click Element (Without Move)", element);

		try {
			click(driver, element);
		} catch (Exception e) {
			throwsException("Unable to click Element : " + element);
		}
	}

	/*
	 * This method checks the checkbox Element
	 */
	public void check(WebElement checkBox) throws Exception {

		printDetailedTestStep("Click (Check Box)", checkBox);

		if (checkBox.getAttribute("checked") != null) {
			checkBox.click();
			altElementNameForTestng(checkBox);
		}
	}

	/*
	 * This method checks the checkbox Element
	 */
	public void check(WebElement checkBox, String checkBoxValue) throws Exception {

		if (checkBoxValue.equalsIgnoreCase("yes") || checkBoxValue.equalsIgnoreCase("checked")
				|| checkBoxValue.equalsIgnoreCase("check")) {
			sleep(1000);
			if (checkBox.getAttribute("checked") == null) {
				checkBox.click();
				logReport("Checkbox Checked", checkBox);
			}
		} else if (checkBoxValue.equalsIgnoreCase("no") || checkBoxValue.equalsIgnoreCase("unchecked")
				|| checkBoxValue.equalsIgnoreCase("uncheck")) {
			sleep(1000);
			if (checkBox.getAttribute("checked") != null) {
				checkBox.click();
				logReport("Checkbox Unchecked", checkBox);
			}
		}
	}

	/*
	 * This method is used to sleep for 5 seconds
	 */
	public void sleep() throws Exception {
		sleep(5000);
	}

	/*
	 * This method is used to sleep for provided mili seconds
	 */
	public void sleep(int val) throws Exception {
		Thread.sleep(val);
	}

	/*
	 * This method is used to read the configuration file
	 */
	public Map<String, String> readConfigurationFile(String path) throws Exception {
		return FranconnectUtil.config;
	}

	/*
	 * This method is used to get driver object
	 */
	public WebDriver openDriverSecondary(Map<String, String> config, String browserName, String newUrl)
			throws Exception {
		Reporter.log("Method : openDriver");
		boolean isDriverValid = false;

		/*
		 * First Check if the Build is working or not
		 */

		// WebDriver driver = null;

		WebDriver driver = null;

		// System.out.println("openDriver-----------------------------------"+this.config);
		logReportMsg("Opening Secondary Browser");

		if (browserName.equalsIgnoreCase("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.ftp", config.get("PROXYIP"));
			profile.setPreference("network.proxy.http", config.get("PROXYIP"));
			profile.setPreference("network.proxy.socks", config.get("PROXYIP"));
			profile.setPreference("network.proxy.ssl", config.get("PROXYIP"));
			profile.setPreference("network.proxy.ftp_port", config.get("PROXYPORT"));
			profile.setPreference("network.proxy.http_port", config.get("PROXYPORT"));
			profile.setPreference("network.proxy.socks_port", config.get("PROXYPORT"));
			profile.setPreference("network.proxy.ssl_port", config.get("PROXYPORT"));

			FirefoxBinary ffBinary = new FirefoxBinary();
			ffBinary.setTimeout(TimeUnit.SECONDS.toMillis(60));

		} else if (browserName.equalsIgnoreCase("gecko")) {

			/*
			 * Change By Inzamam :08/10/2017: Required Firefox 55 with Gecko v0.18.0
			 */

			File file = new File(config.get("inputDirectory") + "\\exe\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			FirefoxProfile profile = new FirefoxProfile();

			String downloadFilePath = config.get("downloadFolder");

			// Set Location to store files after downloading.
			profile.setPreference("browser.download.dir", downloadFilePath);
			profile.setPreference("browser.download.folderList", 2);

			// Set Preference to not show file download confirmation dialogue
			// using MIME types Of different file extension types.
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/plain;application/pdf;text/csv;application/pdf;"
							+ "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; application/vnd.openxmlformats-officedocument.wordprocessingml.document;");

			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			Reporter.log("Opening Chrome Browser : " + browserName);
			System.setProperty("webdriver.chrome.driver", config.get("inputDirectory") + "\\exe\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-popup-blocking");
			options.addArguments("--disable-extensions");// change by ravi
			options.addArguments("disable-infobars");// change by ravi
			options.addArguments("--incognito");// change by nitin bansal
			Map<String, Object> prefs = new HashMap<String, Object>();
			// prefs.put("credentials_enable_service", false); //nitin bansal
			// prefs.put("profile.default_content_settings.popups", 0);// change
			// by
			// ravi
			// options.setExperimentalOption("prefs", prefs); //nitin bansal

			// change by inzi
			// options.addArguments("--disable-xss-auditor");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);// change
			// by
			// ravi

			Reporter.log("Capabilities : " + capabilities);
			/*
			 * // Proxy Set Proxy proxy = new Proxy();
			 * 
			 * Reporter.log("----------------------------1"); try {
			 * Reporter.log("----------------------------2");
			 * proxy.setHttpProxy(config.get("PROXYIP") + ":" + config.get("PROXYPORT"));
			 * capabilities.setCapability("proxy", proxy); } catch (Exception e) {
			 * isDriverValid = false; //nitin bansal Thread.sleep(60000);
			 * Reporter.log("----------------------------10"); Reporter.log(e.getMessage());
			 * 
			 * }
			 */

			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);

			try {
				try {
					System.out.println("Value of jspHit : " + config.get("jspHit"));
					config.get("jspHit");
				} catch (Exception e) {
					Reporter.log(e.getMessage());
				}

				if (config.get("jspHit").equalsIgnoreCase("yes")) {
					URL url = new URL(
							"http://" + config.get("GRIDSERVERIP") + ":" + config.get("GRIDSERVERPORT") + "/wd/hub");
					driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
					Reporter.log("----------------------------21");
				} else {
					Reporter.log("Opening Chrome Driver Instance");
					driver = new ChromeDriver(capabilities);
					Reporter.log("Value of driver : " + driver);
				}
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				Thread.sleep(15000);
			}

			// System.out.println("chrome driver set : ");

		} else if (browserName.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", config.get("inputDirectory") + "\\exe\\IEDriverServer.exe");
			String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";
			try {
				Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				System.out.println("Error ocured!");
			}
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability("nativeEvents", false);
			driver = new InternetExplorerDriver(capability);

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", config.get("inputDirectory") + "\\exe\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		// Requires phantonJs 1.2.0 jar

		/*
		 * else if(config.get("browserName").equalsIgnoreCase("headless")){ Capabilities
		 * capability = new DesiredCapabilities(); ((DesiredCapabilities)
		 * capability).setJavascriptEnabled(true); ((DesiredCapabilities)
		 * capability).setCapability("takesScreenshot", true); ((DesiredCapabilities)
		 * capability).setCapability(PhantomJSDriverService.
		 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY,config.get("inputDirectory")+
		 * "\\exe\\phantomjs.exe"); driver=new PhantomJSDriver(capability); }
		 */

		else {
			throw new SkipException("Browser not available");
		}

		driver.manage().window().maximize();

		System.out.println("browser initialized properly" + isDriverValid);

		printTestStep("Enter Build Url");
		driver.get(newUrl);

		return driver;
	}

	/*
	 * This method is to read the test data from excel sheet
	 */
	public Map<String, String> readTestData(String testCaseId) throws Exception {

		Reporter.log("Finding Test Data From Excel Sheet Now....");
		Reporter.log("Method readTestData " + testCaseId);
		Map<String, String> testData = new HashMap<String, String>();

		boolean isTestCaseFound = false;

		try {
			FileInputStream fis = null;
			int tcRowId = 0;
			File folder = new File(FranconnectUtil.config.get("testDataFolderPath"));
			File[] listOfFiles = folder.listFiles();
			String fileExtension = null;
			List<String> filePath = new ArrayList<String>();
			// storing all the file in a folder
			for (int x = 0; x < listOfFiles.length; x++) {
				fileExtension = FilenameUtils.getExtension(listOfFiles[x].getAbsolutePath());
				if (fileExtension != null && fileExtension.equalsIgnoreCase("xls")) {
					filePath.add(listOfFiles[x].getAbsolutePath());
				}
			}
			// iterating through each sheet
			for (int y = 0; y < filePath.size(); y++) {
				if (isTestCaseFound == false) {
					File file = new File(filePath.get(y));

					fis = new FileInputStream(file.getAbsoluteFile());
					// System.out.println(file.getAbsolutePath());
					HSSFWorkbook wb = new HSSFWorkbook(fis);
					try {
						wb.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
					} catch (Exception e) {
						Reporter.log(e.getMessage());
					}

					Sheet sh = wb.getSheetAt(0);
					int rowCount = sh.getLastRowNum();

					if (rowCount > 10000) {
						rowCount = sh.getPhysicalNumberOfRows();
					}

					if (rowCount > 0 && isTestCaseFound == false) {
						for (int rcnt = 0; rcnt < rowCount + 1; rcnt++) {

							if (isTestCaseFound == false) {
								Row row = null;
								try {
									row = sh.getRow(rcnt);
								} catch (Exception e) {
									Reporter.log(e.getMessage());
								}
								// System.out.println(rcnt);
								if (row != null) {
									boolean isRowEmpty = cu.isRowEmpty(row);
									if (isRowEmpty == false) {
										Cell cell = null;
										try {
											cell = row.getCell(0);
										} catch (Exception e) {
											Reporter.log(e.getMessage());
										}
										if (cell != null) {
											cell.setCellType(CellType.STRING);
											String cellVal = cell.getStringCellValue();
											if (cellVal != null && cellVal.trim().equalsIgnoreCase(testCaseId.trim())) {
												tcRowId = rcnt;
												testData = cu.getTestDataFromRow(wb, sh, tcRowId);
												isTestCaseFound = true;
											}
										}
									}
								}
							}
						}
					}
					wb.close();
					fis.close();
				}
			}
		} catch (Exception e) {
			Reporter.log("Exception in reading excel : " + e);
			// quitBrowserOnCatch(null, config, e, testCaseId); // Quit should
			// not be there .
		}

		// System.out.println("Reached................");
		return testData;
	}

	/*
	 * This method is to read the test data from excel sheet modified by ravi kumar
	 * pal
	 */
	public Map<String, String> readTestData_FormGenerator_count(String testCaseId, String count) throws Exception {
		Reporter.log("Method readTestData " + testCaseId);
		Map<String, String> testData = new HashMap<String, String>();

		boolean isTestCaseFound = false;

		try {
			FileInputStream fis = null;
			int tcRowId = 0;
			File folder = new File(FranconnectUtil.config.get("inputDirectory") + File.separator + "testData");
			File[] listOfFiles = folder.listFiles();
			String fileExtension = null;
			List<String> filePath = new ArrayList<String>();
			// storing all the file in a folder
			for (int x = 0; x < listOfFiles.length; x++) {
				fileExtension = FilenameUtils.getExtension(listOfFiles[x].getAbsolutePath());
				if (fileExtension != null && fileExtension.equalsIgnoreCase("xls")) {
					filePath.add(listOfFiles[x].getAbsolutePath());
				}
			}
			// iterating through each sheet
			for (int y = 0; y < filePath.size(); y++) {
				if (isTestCaseFound == false) {
					File file = new File(filePath.get(y));

					fis = new FileInputStream(file.getAbsoluteFile());
					// System.out.println(file.getAbsolutePath());
					HSSFWorkbook wb = new HSSFWorkbook(fis);
					try {
						wb.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
					} catch (Exception e) {
						Reporter.log(e.getMessage());
					}

					Sheet sh = wb.getSheetAt(0);
					int rowCount = sh.getLastRowNum();

					if (rowCount > 10000) {
						rowCount = sh.getPhysicalNumberOfRows();
					}

					if (rowCount > 0 && isTestCaseFound == false) {
						for (int rcnt = 0; rcnt < rowCount + 1; rcnt++) {

							if (isTestCaseFound == false) {
								Row row = null;
								try {
									row = sh.getRow(rcnt);
								} catch (Exception e) {
									Reporter.log(e.getMessage());
								}
								if (row != null) {
									boolean isRowEmpty = cu.isRowEmpty(row);
									if (isRowEmpty == false) {
										Cell cell = null;
										try {
											cell = row.getCell(0);
										} catch (Exception e) {
											Reporter.log(e.getMessage());
										}
										if (cell != null) {
											cell.setCellType(CellType.STRING);
											String cellVal = cell.getStringCellValue();
											if (cellVal != null && cellVal.trim().equalsIgnoreCase(testCaseId.trim())) {
												tcRowId = rcnt;
												int val = Integer.parseInt(count);
												testData = cu.getTestDataFromRow(wb, sh, tcRowId, val);
												isTestCaseFound = true;
											}
										}
									}
								}
							}
						}
					}
					wb.close();
					fis.close();
				}
			}
		} catch (Exception e) {
			Reporter.log("Exception in reading excel : " + e);
			quitBrowserOnCatch(null, e, testCaseId);
		}

		System.out.println("Reached................");
		return testData;
	}

	public Map<String, String> captureScreenShot(WebDriver driver, String testCaseId) throws Exception {

		File file = null;
		Map<String, String> screenPath = new HashMap<String, String>();
		String gDrivePath = "";
		try {
			if (!FranconnectUtil.config.get("browserName").equalsIgnoreCase("headless")) {

				sleep(1000);

				try {
					Alert alert = driver.switchTo().alert();
					Reporter.log("Unexpected Alert thrown : " + alert.getText());
					driver.switchTo().alert().dismiss();
				} catch (Exception e) {

				}

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String fileName = FranconnectUtil.config.get("screenShotPath").concat("/").concat(testCaseId)
						.concat(".png");
				FileUtils.copyFile(scrFile, new File(fileName));
				file = new File(fileName);
				String fileName2 = file.getAbsolutePath();
				final BufferedImage image = ImageIO.read(new File(fileName2));

				Graphics g = image.getGraphics();
				g.setFont(g.getFont().deriveFont(20f));
				g.setColor(Color.RED);
				g.drawString(driver.getCurrentUrl(), 50, 50);
				g.dispose();

				/**
				 * Updated By INZI : Add Date And Time In IST
				 */
				Graphics g1 = image.getGraphics();
				g1.setFont(g1.getFont().deriveFont(20f));
				g1.setColor(Color.RED);
				g1.drawString(FranconnectUtil.config.get("failedTimeStamp"), 50, 70);
				g1.dispose();
				/**
				 * End Of Time Stamp Update
				 */

				ImageIO.write(image, "png", new File(fileName2));

				GoogleDrive gd = new GoogleDrive();
				gDrivePath = gd.insertFileInFolder(gd.getDriveService(),
						FranconnectUtil.config.get("screenShotFolderId"), testCaseId.concat(".png"),
						FranconnectUtil.config.get("screenShotPath"), "image/jpeg");

				String longUrlscreenShot = cu.makeShortUrl(gDrivePath);

				screenPath.put("googleDriveScreenShotPath", longUrlscreenShot);
				screenPath.put("screenShotPath", file.getAbsolutePath());

				Reporter.log("Screenshot# :" + longUrlscreenShot);

			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		return screenPath;
	}

	/*
	 * Method used to generate random number
	 */
	public String generateRandomNumber() {
		DateFormat dateFormat = new SimpleDateFormat("ddHHmm");
		Date date = new Date();
		String dateVal = dateFormat.format(date);

		int randomNum = (int) (Math.random() * 9);
		String val1 = String.valueOf(randomNum);

		randomNum = (int) (Math.random() * 9);
		String val2 = String.valueOf(randomNum);

		String random = val1.concat(val2);
		random = dateVal.concat(String.valueOf(random));

		return random;
	}

	/*
	 * Method used to generate random character array
	 */
	public String generateRandomChar() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'A');

		r = new Random();
		char d = (char) (r.nextInt(26) + 'a');

		r = new Random();
		char e = (char) (r.nextInt(26) + 'a');

		r = new Random();
		char f = (char) (r.nextInt(26) + 'a');

		r = new Random();
		char g = (char) (r.nextInt(26) + 'a');

		r = new Random();
		char h = (char) (r.nextInt(26) + 'a');

		String randomChars = String.valueOf(c) + String.valueOf(d) + String.valueOf(e) + String.valueOf(f)
				+ String.valueOf(g) + String.valueOf(h);

		return randomChars;
	}

	/*
	 * This method generates random character
	 */
	public String getRandomChar() {
		Random r = new Random();

		r = new Random();
		char d = (char) (r.nextInt(26) + 'a');

		String randomChars = String.valueOf(d);

		return randomChars;
	}

	/*
	 * This method generates test data with provided text
	 */
	public String generateTestData(String testData) throws InterruptedException {
		Thread.sleep(2000);
		if (testData == null || testData.length() == 0) {
			testData = "Default" + generateRandomNumber() + getRandomChar();
		} else {
			testData = testData.concat(getRandomChar()) + generateRandomNumber();
		}
		// System.out.println("Generated Random Value "+testData);
		return testData;
	}

	/*
	 * This method is used to get the current date in yyyyMMdd format
	 */
	public String generateCurrentDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public String generateCurrentDatewithformat(String format) {
		SimpleDateFormat dateformat = new SimpleDateFormat(format);// for
		// example
		// like
		// format=""MM/dd/yyyy""
		Date date = new Date();
		String currentdate = dateformat.format(date);
		return currentdate;
	}

	public String generatefutureDatewithformat(String format, int days) {

		Calendar c = Calendar.getInstance();

		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, days);
		SimpleDateFormat dateformat = new SimpleDateFormat(format);// for
		// example
		// like
		// format=""MM/dd/yyyy""
		Date date = new Date();
		String currentdate = dateformat.format(date);
		return currentdate;
	}

	/*
	 * This method is used to quit the driver when any basic method fails
	 */
	public void quitBrowserOnCatchBasicMethod(WebDriver driver, Exception e, String testCaseId) throws Exception {
		throwsException(e.getMessage());
	}

	/*
	 * This method quits the browser when test case fails
	 */
	public void quitBrowserOnCatch(WebDriver driver, Exception e, String testCaseId) throws Exception {

		try {
			driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		} catch (Exception e1) {
			Reporter.log(e.getMessage());
		}
		String status = "Failed";

		String exceptionClass = e.getClass().getName();

		String exceptionMessage = "No Exception Message Found.";

		if (e.getMessage() != null && e.getMessage().length() > 0) {
			exceptionMessage = e.getMessage();
			System.out.println("FAILED --->>> " + e.getMessage());
		}

		/*
		 * int code = cu.getBuildResponseCode(FranconnectUtil.config.get("buildUrl"));
		 * 
		 * Reporter.log("quitBrowserOnCatch method : " + code);
		 * 
		 * if (code == 0) { status = "Skipped"; } else if (code == 503 || code == 404) {
		 * status = "Skipped"; } else if
		 * (exceptionMessage.toLowerCase().contains("skipexception")) { status =
		 * "Skipped"; } else if
		 * (exceptionClass.toLowerCase().contains("skipexception".toLowerCase()) ) {
		 * status = "Skipped"; }
		 */

		if (exceptionMessage.toLowerCase().contains("skipexception")) {
			status = "Skipped";
		} else if (exceptionClass.toLowerCase().contains("skipexception".toLowerCase())) {
			status = "Skipped";
		}

		try {

			try {
				Reporter.log("\nDriver Info : " + driver.toString());
			} catch (Exception e3) {

			}

			Map<String, String> screenShotPathMap = new HashMap<String, String>();
			screenShotPathMap = captureScreenShot(driver, testCaseId);

			try {
				Reporter.log("Closing Browser / Exit Test");
				driver.quit();
			} catch (Exception e3) {
				Reporter.log(e3.getMessage());
				Reporter.log("- - - - - - - - - - - - - - - - - -");
				Reporter.log("");
				if (!status.equalsIgnoreCase("Skipped")) {
					printBugStatus(e3.getMessage());
				}
				Reporter.log("- - - - - - - - - - - - - - - - - -");

				if (exceptionMessage.toLowerCase().contains("Session ID is null".toLowerCase())) {
					Reporter.log("");
					Reporter.log("** Note to Automation Team : Session not Found Warning **");
				}
			}

			Reporter.log("");

		} catch (Exception exp) {
			Reporter.log(exp.toString());
		}

		// deleteTempFiles();

		if (status.equalsIgnoreCase("Skipped")) {
			throw new SkipException("ExceptionMessage# :" + "Test Case Skipped : " + exceptionMessage);
		} else {
			throw new Exception("ExceptionMessage# :" + exceptionMessage);
		}
	}

	/*
	 * This method prints the test result of basic method in excel sheet
	 */
	public void printTestResultExcel(String testCaseId, String testCaseDescription, String testCaseStep, String status,
			String screenshotPath, Exception exception) throws Exception {
		/*
		 * 
		 * String exceptionMessage = getMessageFromException(exception);
		 * 
		 * testCaseId = testCaseId.trim();
		 * 
		 * if(status!=null && status.length()>0){ status = status.trim(); }
		 * 
		 * String reportPath =
		 * FranconnectUtil.config.get("testReportPath").concat("//").concat(
		 * "Test_Case_Status"+Thread.currentThread().getId()+".xls");
		 * 
		 * File file = new File(reportPath);
		 * 
		 * if(!file.exists()){ FileOutputStream fileOut = new FileOutputStream(file);
		 * HSSFWorkbook workbook = new HSSFWorkbook(); HSSFSheet worksheet =
		 * workbook.createSheet();
		 * 
		 * Row rHeader0 = worksheet.createRow(0);
		 * 
		 * Cell cHeader = rHeader0.createCell(0); cHeader.setCellValue("Test_Case_ID");
		 * 
		 * cHeader = rHeader0.createCell(1);
		 * cHeader.setCellValue("Test_Case_Description");
		 * 
		 * cHeader = rHeader0.createCell(2); cHeader.setCellValue("Test Steps");
		 * 
		 * cHeader = rHeader0.createCell(3); cHeader.setCellValue("Test Status" );
		 * 
		 * cHeader = rHeader0.createCell(4); cHeader.setCellValue("Screenshot");
		 * 
		 * cHeader = rHeader0.createCell(5); cHeader.setCellValue("Exception");
		 * 
		 * worksheet.createFreezePane(0, 1);
		 * 
		 * workbook.write(fileOut); workbook.close(); fileOut.flush(); fileOut.close();
		 * }
		 * 
		 * //Now file already exist
		 * 
		 * if(file!=null && file.length()>0){
		 * 
		 * int tcRow = getTCIDAtRowInExcel(file.getAbsolutePath(), testCaseId);
		 * 
		 * //if test case exist then new row is not required update in existing
		 * 
		 * FileInputStream fis = new FileInputStream(file); Workbook wb =
		 * WorkbookFactory.create(fis); Sheet sh = wb.getSheetAt(0);
		 * 
		 * Row row = null;
		 * 
		 * if(tcRow==0){//then test case does not exist row =
		 * sh.createRow(sh.getLastRowNum()+1);
		 * 
		 * Cell cell = row.createCell(0); if(testCaseId!=null && testCaseId.length()>0){
		 * cell.setCellValue(testCaseId); }
		 * 
		 * cell = row.createCell(1); if(testCaseDescription!=null &&
		 * testCaseDescription.length()>0){ cell.setCellValue(testCaseDescription); }
		 * 
		 * cell = row.createCell(2); if(testCaseStep!=null && testCaseStep.length()>0){
		 * cell.setCellValue(testCaseStep); }
		 * 
		 * try{ cell = row.createCell(3); }catch(Exception e){ cell = row.getCell(3); }
		 * 
		 * if(status!=null && status.length()>0){ cell.setCellValue(status); }
		 * 
		 * cell = row.createCell(4);
		 * 
		 * if(screenshotPath!=null && screenshotPath.length()>0){
		 * cell.setCellValue(screenshotPath); }
		 * 
		 * cell = row.createCell(5); cell.setCellValue(exceptionMessage); }else{ row =
		 * sh.getRow(tcRow);
		 * 
		 * Cell celltcid = row.getCell(1); if(testCaseDescription!=null &&
		 * testCaseDescription.length()>0){ celltcid.setCellValue(testCaseDescription);
		 * }
		 * 
		 * Cell cellstep = row.getCell(2); if(testCaseStep!=null &&
		 * testCaseStep.length()>0){ if(cellstep!=null &&
		 * cellstep.getStringCellValue().length()>0){ String newTestStep =
		 * cellstep.getStringCellValue(); newTestStep =
		 * newTestStep.concat("\n").concat(testCaseStep);
		 * cellstep.setCellValue(newTestStep); }else{
		 * cellstep.setCellValue(testCaseStep); } }
		 * 
		 * Cell cellstatus = row.getCell(3); if(status!=null && status.length()>0){
		 * cellstatus.setCellValue(status); }
		 * 
		 * Cell cellscr = row.getCell(4); if(status!=null &&
		 * status.equalsIgnoreCase("Passed")){ cellscr.setCellValue("");
		 * row.removeCell(cellscr);
		 * 
		 * try{ row.createCell(4); }catch(Exception e){ Reporter.log(e.getMessage()); }
		 * }else if (status!=null && (!status.equalsIgnoreCase("Passed"))){ cellscr =
		 * row.getCell(4); if(screenshotPath!=null && screenshotPath.length()>0){
		 * cellscr.setCellValue(screenshotPath); } }
		 * 
		 * Cell cellexp = row.getCell(5); if(status!=null &&
		 * status.equalsIgnoreCase("Passed")){ cellexp.setCellValue("");
		 * row.removeCell(cellexp);
		 * 
		 * try{ row.createCell(5); }catch(Exception e){ Reporter.log(e.getMessage()); }
		 * }else if(status!=null && (!status.equalsIgnoreCase("Passed"))){
		 * cellexp.setCellValue(exceptionMessage); } }
		 * 
		 * FileOutputStream fout = new FileOutputStream(file); wb.write(fout);
		 * fout.flush(); fout.close(); wb.close(); }
		 * 
		 * 
		 */
	}

	/*
	 * This method is used to quit the browser
	 */
	public void quitBrowser(WebDriver driver, Map<String, String> config, String testCaseId) throws Exception {

		printTestResultExcel(testCaseId, null, null, "Passed", null, null);

		Reporter.log("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

		// Reporter.log("\nquitBrowser - - - - - - - - - - - - - - Driver - - -
		// - - - - - - - - - - - \n"+driver.toString());

		Reporter.log("\nDriver Info : " + driver.toString());

		logReportMsg("Browser quit");
		try {
			driver.quit();
		} catch (Exception e) {
			if (e.toString().toLowerCase().contains("Session ID is null".toLowerCase())) {
				Reporter.log("** Note to Automation Team : Session not Found Warning **");
			}
		}
	}

	/*
	 * This method is used to logout and quit the browser
	 */
	public void logoutAndQuitBrowser(WebDriver driver, String testCaseId) throws Exception {
		try {
			System.out.println("PASSED ----->>> " + testCaseId);
			String fileName = FranconnectUtil.config.get("testReportPath");
			// System.out.println("---------------- "+fileName);
			LoginPageTest lp = new LoginPageTest();
			lp.home_page().logout(driver);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}

		printTestResultExcel(testCaseId, null, null, "Passed", null, null);

		Reporter.log("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

		// Reporter.log("\nquitBrowser - - - - - - - - - - - - - - Driver - - -
		// - - - - - - - - - - - \n"+driver.toString());

		Reporter.log("\nDriver Info : " + driver.toString());

		logReportMsg("Browser quit");
		try {

			driver.quit();
			driver = null;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			if (e.toString().toLowerCase().contains("Session ID is null".toLowerCase())) {
				Reporter.log("** Note to Automation Team : Session not Found Warning **");
			}
		}
	}

	/*
	 * This method is used to move to element through action class
	 */
	public void moveToElementThroughAction(WebDriver driver, WebElement element) throws Exception {
		moveToElement(driver, element);
		try {
			Actions actobj = new Actions(driver);
			actobj.moveToElement(element).perform();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Unable to move to Element::" + element);
		}
	}

	public boolean inSelectBox(WebDriver driver, WebElement dropDown, String testData) {
		boolean isValPresent = false;

		Select listing = new Select(dropDown);

		List<WebElement> listValues = listing.getOptions();
		for (int x = 0; x < listValues.size(); x++) {
			if (listValues.get(x).getText().trim().equalsIgnoreCase(testData)) {
				isValPresent = true;
				break;
			}
		}
		return isValPresent;
	}

	public void inPageSource(WebDriver driver, String testData) throws Exception {
		logReportMsg("Finding content in page source");
		getElementByXpath(driver, "//body[contains(text(), testData)]").getText();
	}

	public boolean searchInSelectBoxSingleValue(WebDriver driver, WebElement listDrp, String testData) {
		Boolean isValFound = false;
		int countOptions = 0;
		Select listing = new Select(listDrp);
		List<WebElement> listValues = listing.getOptions();
		for (int x = 0; x < listValues.size(); x++) {
			if (listValues.get(x).getText().trim().equalsIgnoreCase(testData)) {
				// System.out.println(listValues.get(x).getText().trim());
				countOptions++;
			}
		}
		if (countOptions > 0) {
			isValFound = true;
		}
		return isValFound;
	}

	// Akshat
	public boolean searchSingleValueInMultiSelect(WebDriver driver, String division, String testData) {
		Boolean isValFound = false;
		int countOptions = 0;
		List<WebElement> values = driver.findElements(
				By.xpath(".//td[contains(text(),'" + division + "')]/following-sibling::td//div/div/ul/li/label"));
		for (int x = 0; x < values.size(); x++) {
			System.out.println(values.get(x));
			System.out.println(values.get(x).getText());
			if (values.get(x).getText().trim().equalsIgnoreCase(testData)) {
				countOptions++;
			}
		}

		return isValFound;
	}

	public String getSelectedOptioninDropDown(WebDriver driver, WebElement element) throws Exception {
		moveToElement(driver, element);
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return option.getText().trim();
	}

	public void assertSingleLinkText(WebDriver driver, String testData) throws Exception {
		printTestStep("Verify the link is present :" + testData);
		int recordCount = 0;

		List<WebElement> linkList = null;
		try {
			linkList = driver.findElements(By.tagName("a"));
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		if (linkList != null && !linkList.isEmpty()) {
			for (WebElement el : linkList) {
				if (el.getText().trim().equalsIgnoreCase(testData.trim())) {
					recordCount++;
				}
			}
		} else {
			throwsException("No record found");
		}

		if (recordCount > 1) {
			throwsException("More than one record found with same information : " + testData);
		} else if (recordCount < 1) {
			throwsException("Record not Found : " + testData);
		} else {
			printTestStep("Match found : " + "Yes");
		}

	}

	public boolean assertLinkText(WebDriver driver, String testData) {
		boolean isLinkPresent = false;
		int linkCounts = driver.findElements(By.linkText(testData)).size();

		if (linkCounts > 0) {
			isLinkPresent = true;
		}

		if (linkCounts <= 0) {
			linkCounts = driver.findElements(By.linkText(testData)).size();
			if (linkCounts > 0) {
				isLinkPresent = true;
			}
		}
		return isLinkPresent;
	}

	public int assertNoSingleLinkText(WebDriver driver, String testData) {
		boolean isLinkPresent = false;
		int recordCount = 0;
		// System.out.println("Finding Link Text :"+testData);
		int linkListSize = 0;
		List<WebElement> linkList = null;
		// List<WebElement> listOfElement =
		// driver.findElements(By.partialLinkText(testData.trim()));
		try {
			linkList = driver.findElements(By.tagName("a"));
			linkListSize = linkList.size();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			linkListSize = 0;
		}
		// System.out.println(linkListSize);

		for (int x = 0; x < linkListSize; x++) {
			// System.out.println(linkList.get(x).getText());
			if (linkList.get(x).getText().toLowerCase().contains(testData.toLowerCase().trim())) {
				isLinkPresent = true;
				recordCount++;
			}
		}
		return recordCount;
	}

	public int findSingleLinkPartialText(WebDriver driver, String testData) throws Exception {
		boolean isLinkPresent = false;
		int recordCount = 0;
		int linkListSize = 0;
		List<WebElement> linkList = null;
		// List<WebElement> listOfElement =
		// driver.findElements(By.partialLinkText(testData.trim()));
		try {
			linkList = driver.findElements(By.tagName("a"));
			linkListSize = linkList.size();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			linkListSize = 0;
		}
		// System.out.println(linkListSize);

		for (int x = 0; x < linkListSize; x++) {
			// System.out.println(linkList.get(x).getText());
			if (linkList.get(x).getText().toLowerCase().contains(testData.toLowerCase().trim())) {
				isLinkPresent = true;
				recordCount++;
			}
		}
		return recordCount;
	}

	public boolean assertLinkPartialText(WebDriver driver, String testData) throws Exception {
		boolean isLinkPresent = false;
		sleep();
		int linkListSize = 0;
		List<WebElement> linkList = null;
		try {
			linkList = driver.findElements(By.tagName("a"));
			linkListSize = linkList.size();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			linkListSize = 0;
		}

		for (int x = 0; x < linkListSize; x++) {
			if (linkList.get(x).getText().toLowerCase().trim().contains(testData.toLowerCase().trim())) {
				isLinkPresent = true;
				break;
			}
		}
		return isLinkPresent;
	}

	public void assertLinkPartialTextNotPresent(WebDriver driver, String testData) {
		boolean isTrue = false;
		int linkCounts = driver.findElements(By.partialLinkText(testData)).size();
		if (linkCounts > 0) {
			isTrue = true;
		}
		Assert.assertFalse(isTrue, "Link Found! Expected - Link should not be present");
	}

	public void assertLinkTextNotPresent(WebDriver driver, String testData) throws Exception {
		int linkCounts = driver.findElements(By.linkText(testData)).size();
		if (linkCounts > 0) {
			throwsException("Link should not be present on the page. " + testData);
		}
	}

	public boolean assertPageSource(WebDriver driver, String testData) throws Exception {

		boolean isTextPresent = false;

		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small = "abcdefghijklmnopqrstuvwxyz";

		try {
			/*
			 * moveToElement(driver,
			 * driver.findElement(By.xpath(".//*[contains(translate(text(),'" + caps +
			 * "', '" + small + "'),'" + testData.toLowerCase() + "')]")));
			 */

			moveToElement(driver, getElementOnVisible(driver, "xpath", ".//*[contains(translate(text(),'" + caps
					+ "', '" + small + "'),'" + testData.toLowerCase() + "')]"));

			isTextPresent = true;
		} catch (Exception e) {
			isTextPresent = false;
		}

		if (isTextPresent == false) {
			try {
				String pageSource = driver.findElement(By.tagName("body")).getText();
				pageSource = pageSource.toLowerCase();
				sleep(10000);
				isTextPresent = pageSource.contains(testData.trim().toLowerCase());

				if (isTextPresent == false) {
					sleep();
					pageSource = driver.findElement(By.xpath("//html/body")).getText();
					pageSource = pageSource.toLowerCase();
					isTextPresent = pageSource.contains(testData.trim().toLowerCase());
				}
			} catch (Exception e) {
				isTextPresent = false;
			}
		}

		if (isTextPresent == true) {
			printTestStep("Expected text : [ " + testData + " ], Found");
		} else {
			printTestStep("Expected text : [ " + testData + " ], Not Found");
		}
		return isTextPresent;
	}

	public boolean assertPageSourceWithMultipleRecords(WebDriver driver, List<String> listItems) throws Exception {
		// Reporter.log("Searching for the multiple text in the page: ");
		boolean isPresent = false;
		sleep(5000);

		String pageSource = driver.findElement(By.tagName("body")).getText().toLowerCase();
		sleep(20000);

		for (int x = 0; x < listItems.size(); x++) {

			isPresent = pageSource.contains(listItems.get(x).trim().toLowerCase());

			if (isPresent == false) {
				sleep();
				pageSource = driver.findElement(By.xpath("//html/body")).getText().toLowerCase();
				isPresent = pageSource.contains(listItems.get(x).trim().toLowerCase());
			}

			if (isPresent == false) {
				Reporter.log(listItems.get(x) + " Not Found in Page ");

				return false;

			} else {
				isPresent = true;
			}
		}

		return isPresent;
	}

	public boolean assertNotInPageSource(WebDriver driver, String testData) throws Exception {

		sleep(2500);
		// System.out.println(testData);
		String pageSource = driver.findElement(By.tagName("body")).getText();

		Boolean isPresent = pageSource.contains(testData);
		// System.out.println("Value Found ? "+isPresent);

		if (isPresent == false) {
			sleep();
			pageSource = driver.findElement(By.xpath("//html/body")).getText().toLowerCase();
			isPresent = pageSource.contains(testData.trim().toLowerCase());
		} else {
			return isPresent;
		}
		return isPresent;
	}

	public String throwsException(String exceptionMsg) throws Exception {
		Reporter.log("");
		throw new Exception(exceptionMsg);
	}

	public Exception throwsException1(String exceptionMsg) throws Exception {
		Reporter.log("");
		throw new Exception(exceptionMsg);
	}

	public String throwsSkipException(String exceptionMsg) throws Exception {
		Reporter.log("");
		throw new SkipException(exceptionMsg);
	}

	private String altElementNameForTestng(WebElement elm) {
		String elementName = elm.toString();
		if (elementName.contains("[[")) {
			elementName = elementName.substring((elementName.indexOf("->") + 3), elementName.lastIndexOf("]"));
		}
		return elementName;
	}

	public void logReport(String customMsg, WebElement elm) {
		String elementName = altElementNameForTestng(elm);
		int maxPadLength = 40;
		String paddingCharacter = " ";
		customMsg = StringUtils.rightPad(customMsg, maxPadLength, paddingCharacter);
		Reporter.log(customMsg + " : " + elementName);
	}

	private void logReportMsg(String customMsg) {
		int maxPadLength = 40;
		String paddingCharacter = " ";
		customMsg = StringUtils.rightPad(customMsg, maxPadLength, paddingCharacter);
		Reporter.log(customMsg);
	}

	public void logReportMsg(String customMsg, String msg) {
		int maxPadLength = 40;
		String paddingCharacter = " ";
		customMsg = StringUtils.rightPad(customMsg, maxPadLength, paddingCharacter);
		Reporter.log(customMsg + " : " + msg);
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

	/*
	 * This method is used to get text from field
	 */
	public String getText(WebDriver driver, WebElement element) throws Exception {
		String text = null;
		moveToElement(driver, element);
		try {
			text = element.getText().trim();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Unable to get Text");
		}
		return text;
	}

	/*
	 * This method is used to get text field value
	 */
	public String getTextTxtFld(WebDriver driver, WebElement element) throws Exception {
		String txt = null;
		moveToElement(driver, element);
		try {
			txt = element.getAttribute("value").trim();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Unable to get Text from field");
		}
		return txt;
	}

	/*
	 * This method is used to select drop down value
	 */
	public String getSelectedDropDownValue(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Get Selected Value From Drop Down", element);

		moveToElement(driver, element);
		Select select = new Select(element);
		List<WebElement> values = select.getAllSelectedOptions();
		String value = values.get(0).getText();
		return value;
	}

	/*
	 * This method is used to return the random special character
	 */
	public String generateRandomSpecialChar() {
		final String alphabet = "!@#$%^&*~_<>,.:";
		final int N = alphabet.length();
		Random rd = new Random();
		int iLength = 10;
		StringBuilder sb = new StringBuilder(iLength);
		for (int i = 0; i < iLength; i++) {
			sb.append(alphabet.charAt(rd.nextInt(N)));
		}
		System.out.println(alphabet);
		return alphabet;
	}

	/*
	 * This method returns the current date value
	 */
	public String currentDate() {
		return cu.currentDate();
	}

	/*
	 * This method is to get text from all text field in the page and validate
	 * against the string list
	 */
	public boolean assertMultipleInputBoxValue(WebDriver driver, List<String> listItems) throws Exception {
		Reporter.log("Searching for the multiple input fields in page - ");
		boolean isPresent = false;
		boolean anyValueMismatch = true;
		List<WebElement> inputBoxValues = driver.findElements(By.xpath("//html/body//input"));
		List<WebElement> inputBoxValues1 = driver.findElements(By.xpath("//html/body//textarea"));
		inputBoxValues.addAll(inputBoxValues1);

		for (int x = 0; x < listItems.size(); x++) {
			isPresent = false;
			for (int y = 0; y < inputBoxValues.size(); y++) {
				String inputValue = inputBoxValues.get(y).getAttribute("value");
				// System.out.println("Value Searching : "+inputValue);
				// System.out.println("Value found : "+listItems.get(x));
				if (inputValue != null && inputValue.length() > 0
						&& inputValue.toLowerCase().equalsIgnoreCase(listItems.get(x).toLowerCase())) {
					// System.out.println("value searching :
					// "+listItems.get(x).toLowerCase());
					isPresent = true;
					break;
				}
			}

			if (isPresent == false) {
				printBugStatus(listItems.get(x) + " Not Found");
				anyValueMismatch = false;
			} else {
				isPresent = true;
			}
			// System.out.println(listItems.get(x).trim().toLowerCase()+" Value
			// Found ? "+isPresent);
		}
		return anyValueMismatch;
	}

	public void setToDefault(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Set To Default", element);

		moveToElement(driver, element);
		try {
			sleep(1000);
			clickElement(driver, element);
			WebElement selectAll = element.findElement(By.xpath(".//input[@id='selectAll']"));
			if (selectAll.isSelected() == true) {
				clickElement(driver, selectAll);
			} else {
				clickElement(driver, selectAll);
				clickElement(driver, selectAll);
			}
			clickElement(driver, element);

		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Set To Default");
		}
	}

	public void selectMultipleFromMultiList(WebDriver driver, String byId_AttributeValue, List<String> textOptions) {
		final WebElement element = driver.findElement(By.id(byId_AttributeValue));
		final Select dropdown = new Select(element);
		final List<WebElement> options = dropdown.getOptions();
		final Actions builder = new Actions(driver);
		final boolean isMultiple = dropdown.isMultiple();
		if (isMultiple) {
			dropdown.deselectAll();
		}
		builder.keyDown(Keys.CONTROL);
		for (String textOption : textOptions) {
			for (WebElement option : options) {
				final String optionText = option.getText().trim();
				if (optionText.equalsIgnoreCase(textOption)) {
					if (isMultiple) {
						if (!option.isSelected()) {
							builder.click(option);
						}
					} else {
						option.click();
					}
					break;
				}
			}
		}
		builder.keyUp(Keys.CONTROL).build().perform();
	}

	/*
	 * This method is used to select value in multi select field
	 */
	public void selectValFromMultiSelect(WebDriver driver, WebElement element, String value) throws Exception {

		printDetailedTestStep("Select (Multi Select)", element, value);

		try {
			sleep(500);
			clickElement(driver, element);
			sleep(500);

			WebElement selectAllCheck = element.findElement(By.xpath(".//*[@id='selectAll']"));

			if (selectAllCheck.isSelected()) {
				clickElement(driver, selectAllCheck);
			} else {
				clickElement(driver, selectAllCheck);
				sleep(1000);
				clickElement(driver, selectAllCheck);
			}
			WebElement searchTextBox = element.findElement(By.xpath("./div/div/input"));
			List<String> linkArray = translate(value);
			if (linkArray.size() > 0) {
				for (int i = 0; i < linkArray.size(); i++) {
					try {
						value = linkArray.get(i);
						sendKeys(driver, searchTextBox, value);
						sleep(500);
						// change as per functionality click on search icon
						WebElement searchBtn = searchTextBox
								.findElement(By.xpath("./following-sibling::input[@type='button']"));

						clickElement(driver, searchBtn);
						WebElement element3 = element
								.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
						try {
							if (!element3.isSelected()) {
								clickElement(driver, element3);
								sleep();
							}

						} catch (Exception e) {
							Reporter.log(e.getMessage());
							throwsException("Search Value not present in Multi Select Box");
						}

						clickElementByJS(driver, element);
						break;
					} catch (Exception e) {
					}
				}
			} else {
				sendKeys(driver, searchTextBox, value);
				sleep(500);

				try {
					WebElement element3 = element
							.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
					if (!element3.isSelected()) {
						clickElement(driver, element3);
					}

				} catch (Exception e) {
					Reporter.log(e.getMessage());
					throwsException("Search Value not present in Multi Select Box");
				}

				clickElement(driver, element);

			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}
	}

	public void selectValFromMultiSelectWithoutReset(WebDriver driver, WebElement element, String value)
			throws Exception {

		/*
		 * printDetailedTestStep("Select (Multi Select)", element, value);
		 * 
		 * try { sleep(500); clickElement(driver, element); sleep(500);
		 * 
		 * WebElement searchTextBox = element.findElement(By.xpath("./div/div/input"));
		 * 
		 * sendKeys(driver, searchTextBox, value); sleep(500);
		 * 
		 * try { WebElement element3 =
		 * element.findElement(By.xpath(".//label[contains(text(),'" + value +
		 * "')]/input")); if (!element3.isSelected()) { clickElement(driver, element3);
		 * }
		 * 
		 * } catch (Exception e) { Reporter.log(e.getMessage());
		 * throwsException("Search Value not present in Multi Select Box"); }
		 * 
		 * clickElement(driver, element);
		 * 
		 * } catch (Exception e) { Reporter.log(e.getMessage());
		 * throwsException("Problem in Multi Select Box! " + e.getMessage()); }
		 */

		printDetailedTestStep("Select (Multi Select)", element, value);

		try {
			sleep(500);
			clickElement(driver, element);
			sleep(500);

			WebElement selectAllCheck = element.findElement(By.xpath(".//*[@id='selectAll']"));

			WebElement searchTextBox = element.findElement(By.xpath("./div/div/input"));
			List<String> linkArray = translate(value);
			if (linkArray.size() > 0) {
				for (int i = 0; i < linkArray.size(); i++) {
					try {
						value = linkArray.get(i);
						sendKeys(driver, searchTextBox, value);
						sleep(500);
						// change as per functionality click on search icon

						try {
							WebElement searchBtn = searchTextBox
									.findElement(By.xpath("./following-sibling::input[@type='button']"));

							clickElement(driver, searchBtn);
						} catch (Exception e) {
							clickEnterOnElement(driver, searchTextBox);
						}
						WebElement element3 = element
								.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
						try {
							if (!element3.isSelected()) {
								clickElement(driver, element3);
								sleep();
							}

						} catch (Exception e) {
							Reporter.log(e.getMessage());
							throwsException("Search Value not present in Multi Select Box");
						}

						clickElement(driver, element);
						break;
					} catch (Exception e) {
					}
				}
			} else {
				sendKeys(driver, searchTextBox, value);
				sleep(500);

				try {
					WebElement element3 = element
							.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
					if (!element3.isSelected()) {
						clickElement(driver, element3);
					}

				} catch (Exception e) {
					Reporter.log(e.getMessage());
					throwsException("Search Value not present in Multi Select Box");
				}

				clickElement(driver, element);

			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}

	}

	/*
	 * This method is used to select value in multi select field
	 */
	public void selectValFromMultiSelect(WebDriver driver, WebElement element, WebElement elementInput, String value)
			throws Exception {

		printDetailedTestStep("Select (Multi Select)", element, value);

		try {
			sleep(500);
			clickElement(driver, element);
			sleep(500);

			// update by Inzi
			WebElement selectAllCheck = element.findElement(By.xpath(".//*[@id='selectAll']"));

			if (selectAllCheck.isSelected()) {
				clickElement(driver, selectAllCheck);
			}

			sendKeys(driver, elementInput, value);

			clickEnterOnElement(driver, elementInput);

			sleep(500);

			try {
				WebElement element3 = element.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
				clickElement(driver, element3);

			} catch (Exception e) {
				Reporter.log(e.getMessage());
				throwsException("Search Value not present in Multi Select Box");
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}
	}

	public void selectValFromMultiSelectRadioBtn(WebDriver driver, WebElement element, String value) throws Exception {

		printDetailedTestStep("Select (Multi Select)", element, value);

		try {
			sleep(500);
			clickElement(driver, element);
			sleep(500);

			WebElement element1 = element
					.findElement(By.xpath("./div/ul/li/label[contains(text () , 'Select')]/input"));

			if (!element1.isSelected()) {
				clickElement(driver, element1);
				clickElement(driver, element);
			}

			WebElement element2 = element.findElement(By.xpath("./div/div/input"));

			sendKeys(driver, element2, value);
			sleep(500);

			try {
				WebElement element3 = element
						.findElement(By.xpath("./div/ul/li/label[contains(text () , '" + value + "')]"));
				clickElement(driver, element3);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				throwsException("Search Value not present in Multi Select Box");
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}
	}

	/*
	 * This method is used to select multiple value in multi select field
	 */
	public void selectMultipleValFromMultiSelect(WebDriver driver, WebElement element, List<String> listInfo)
			throws Exception {

		try {
			clickElement(driver, element);
			sleep(500);
			WebElement searchTextBox = element.findElement(By.xpath(".//input[@class='searchInputMultiple']"));
			WebElement selectAllCheck = element.findElement(By.xpath(".//*[@id='selectAll']"));
			WebElement element3 = null;

			if (selectAllCheck.isSelected()) {
				clickElement(driver, selectAllCheck);
			} else {
				clickElement(driver, selectAllCheck);
				clickElement(driver, selectAllCheck);
			}

			for (int x = 0; x < listInfo.size(); x++) {
				try {
					sendKeys(driver, searchTextBox, listInfo.get(x));

					// change as per functionality click on search icon --
					// akshat
					clickElement(driver, ".//*[@class='search-btn on']");

					element3 = element
							.findElement(By.xpath(".//label[contains(text(),'" + listInfo.get(x) + "')]/input"));
					if (!element3.isSelected()) {
						clickElement(driver, element3);
					}
				} catch (Exception e) {
					Reporter.log(e.getMessage());
					throwsException("Search Value not present in Multi Select Box");
				}
			}
			// Akshat - closing the dropdown
			clickElement(driver, element);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}
	}

	/*
	 * This method is used to click on the action img on the right
	 */
	public void actionImgOption(WebDriver driver, String task, String option) throws Exception {

		printDetailedTestStep("Click", option);

		moveToElement(driver, getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer"));
		String alterText = getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer").getAttribute("id")
						.trim();
		alterText = alterText.replace("Actions_dynamicmenu", "");
		alterText = alterText.replace("Bar", "");
		clickElement(driver, getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer/a/img"));

		List<String> linkArray = translate(option);
		if (!(linkArray.size() < 1)) {
			for (int i = 0; i < linkArray.size(); i++) {
				try {
					option = linkArray.get(i);
					clickElement(driver, driver.findElement(By.xpath(".//div[@id='Actions_dynamicmenu" + alterText
							+ "Menu']/*[contains(text () , '" + option + "')]")));
					break;
				} catch (Exception e) {
				}
			}
		} else {
			clickElement(driver, driver.findElement(By.xpath(
					".//div[@id='Actions_dynamicmenu" + alterText + "Menu']/*[contains(text () , '" + option + "')]")));
		}
	}
	
	public void actionImgOptionError(WebDriver driver, String task, String option) throws Exception {

		printDetailedTestStep("Click", option);

		moveToElement(driver, getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer"));
		String alterText = getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer").getAttribute("id")
						.trim();
		alterText = alterText.replace("Actions_dynamicmenu", "");
		alterText = alterText.replace("Bar", "");
		clickElement(driver, getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer/a/img"));

		
			clickElement(driver, driver.findElement(By.xpath(
					".//div[@id='Actions_dynamicmenu" + alterText + "Menu']/*[contains(text () , '" + option + "')]")));
	}


	/*
	 * This method is used to click on the action img on the right without using i18
	 * translation
	 */
	// Akshat
	public void actionImgOption_WithoutTranslation(WebDriver driver, String task, String option) throws Exception {

		printDetailedTestStep("Click", option);

		moveToElement(driver, getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer"));
		String alterText = getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer").getAttribute("id")
						.trim();
		alterText = alterText.replace("Actions_dynamicmenu", "");
		alterText = alterText.replace("Bar", "");
		clickElement(driver, getElementByXpath(driver,
				".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer/a/img"));

		clickElement(driver, driver.findElement(By.xpath(
				".//div[@id='Actions_dynamicmenu" + alterText + "Menu']/*[contains(text () , '" + option + "')]")));

	}

	/*
	 * This method click on the link Show All
	 */
	public void showAll(WebDriver driver) throws Exception {

		printDetailedTestStep("Click Link", "Show All");

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//a[contains(@title ,'Show All')]")).click();
		} catch (Exception e) {
		} finally {
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		}
	}

	/*
	 * This method is used to enter date in date field
	 */
	public void sendKeys(WebDriver driver, WebElement txtField, String value) throws Exception {

		printDetailedTestStep("Enter", txtField, value);

		if (value != null) {

			moveToElement(driver, txtField);

			boolean isFieldFound = false;

			try {
				txtField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				txtField.sendKeys(Keys.DELETE);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
			}

			try {
				txtField.clear();
			} catch (Exception e2) {
				Reporter.log(e2.toString());
			}

			boolean isNewDatePickerAvailable = false;
			try {

				if (txtField.getAttribute("class")
						.equalsIgnoreCase("fTextBox dateTimepicker hasDatepicker CurrentActiveDateTimePicker")) {
					((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", txtField, value);
					isNewDatePickerAvailable = true;
					isFieldFound = true;
				}
			} catch (Exception e) {
				Reporter.log("Unable to enter date in jQuery Date Picker");
			}

			if (isNewDatePickerAvailable == false) {
				try {
					txtField.sendKeys(value);
					try {
						if (txtField.getAttribute("class").equalsIgnoreCase("datepicker form-ctrl hasDatepicker")) {
							clickElement(driver,
									getElementByXpath(driver, ".//a[@class='fc-state-default fc-state-active']"));
						} else if (txtField.getAttribute("class").equalsIgnoreCase("fTextBoxDate hasDatepicker")
								|| txtField.getAttribute("class").equalsIgnoreCase("fTextBoxDate")) {
							sleep(500);
							txtField.sendKeys(Keys.TAB);
						}

					} catch (Exception e) {
						Reporter.log("Unable to Close / Open Calendar");
					}
					isFieldFound = true;
				} catch (Exception e) {
					Reporter.log(e.getMessage());
					throwsException("Not able to enter data : " + txtField);
				}
			}
			if (isFieldFound == false) {
				throwsException("Unable to enter data in field " + txtField.getText());
			}
		} else {
			throwsException("Supported Data not found, to be entered into the field : " + txtField);
		}
	}

	// Check this method
	/*
	 * This method is to get the file name in the test data folder
	 */
	public String getFilePathFromTestData(String fileName) {

		// String filePath = config.get("testDataPath");
		String filePath = FranconnectUtil.config.get("inputDirectory") + "\\testData";

		String foundPath = null;
		List<String> list = new ArrayList<String>();

		list = getTestFiles(filePath, list);

		if (list.size() > 0) {
			foundPath = findFileName(list, fileName);
		}
		return foundPath;
	}

	/*
	 * This method is to get the test files for test configuration
	 */
	private List<String> getTestFiles(String filePath, List<String> list) {
		try {
			File mainFolder = new File(filePath);
			File[] file = mainFolder.listFiles();
			for (int x = 0; x < file.length; x++) {

				if (file[x].isDirectory()) {
					list.add(file[x].getAbsolutePath());
					getTestFiles(file[x].getAbsolutePath(), list);
				}
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			Reporter.log("File Not Found / Problem in reading location of file " + e);
		}
		return list;
	}

	/*
	 * This method is used to find the file name in the folder
	 */
	private String findFileName(List<String> list, String fileName) {
		String path = null;
		if (fileName != null) {
			File file = null;
			File[] files = null;
			for (int x = 0; x < list.size(); x++) {
				file = new File(list.get(x));
				files = file.listFiles();
				for (int y = 0; y < files.length; y++) {
					if (files[y].getAbsolutePath().contains(fileName)) {
						path = files[y].getAbsolutePath();
					}
				}
			}
		}
		Reporter.log("Path for document upload : : ::::::::" + path);
		return path;
	}

	/*
	 * This method is to report the error in the html report
	 */
	public void printBugStatus(String bugDescription) {
		Reporter.log("---------------------------------------------------------------");
		Reporter.log("Defect ## : " + bugDescription);
		Reporter.log("");
	}

	/*
	 * To check if the text is present on the page or not
	 */
	public void isTextDisplayed(WebDriver driver, String content, String throwMessage) throws Exception {

		try {
			List<WebElement> element = driver.findElements(By.xpath(".//*[contains(text(),'" + content + "')]"));

			if (element.size() < 1) {
				throwsException(throwMessage);
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException(throwMessage);
		}
	}

	// Check this method
	/*
	 * This method is used to check if the element is present or not
	 */
	public boolean verifyElementOnVisible_ByXpath(WebDriver driver, String xpath) {
		boolean status = false;
		try {
			WebElement element = getElementByXpath(driver, xpath);
			moveToElement(driver, element);
			status = true;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			status = false;
		}
		return status;
	}

	public boolean verifyCaseID(WebDriver driver, String id) {
		boolean status = false;
		try {
			WebElement element = getElementByID(driver, id);
			moveToElement(driver, element);
			status = true;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
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

	/*
	 * This method validates if the basis method is executed with passed / skipped
	 */

	public boolean validate(String testCaseId) throws Exception {
		/*
		 * boolean exitMethod = false; boolean testToRun = false; boolean tcExist =
		 * false; String folderPath = config.get("testReportPath"); //String reportPath
		 * = folderPath.concat("/").concat("Test_Case_Status"+Thread.currentThread
		 * ().getId()+".xls");
		 * 
		 * File file1 = new File(folderPath); File[] file2 = file1.listFiles(); for(File
		 * f:file2){ if(f.exists() && exitMethod==false){ FileInputStream fis = new
		 * FileInputStream(f); Workbook wb = WorkbookFactory.create(fis); Sheet sh =
		 * wb.getSheetAt(0); for(int x=0;x<sh.getLastRowNum()+1;x++){ Row r =
		 * sh.getRow(x); Cell cell = r.getCell(0); if(cell!=null &&
		 * cell.getStringCellValue().equalsIgnoreCase(testCaseId)){ tcExist = true; Cell
		 * cell2 = r.getCell(3); if(cell2!=null &&
		 * (cell2.getStringCellValue().equalsIgnoreCase("Passed") ||
		 * cell2.getStringCellValue().equalsIgnoreCase("Skipped"))){ testToRun = true;
		 * break; } exitMethod = true; } } if(tcExist==false){ testToRun = true; }
		 * }else{ testToRun = true; } } return testToRun;
		 */
		return true;
	}

	/*
	 * This method is used for Drag & Drop
	 */
	public void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).build().perform();
	}

	/*
	 * This method select values in the list box
	 */
	public void listBoxSelectValues(List<String> lstFields, WebElement ele) throws Exception {
		Select select = new Select(ele);
		try {
			for (String str : lstFields) {
				select.selectByVisibleText(str);
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Was not able to Select values in List Box");
		}
	}

	/*
	 * This method selects all the values in List Box
	 */

	public int listBoxSelectAllValues(WebElement ele) throws Exception {
		int count = 0;
		Select lstBoxSelectedFields = new Select(ele);
		List<WebElement> lstWebElements = lstBoxSelectedFields.getOptions();

		try {
			for (WebElement element : lstWebElements) {
				count++;
				element.click();
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Was not able to select all the values in the list box");
		}

		return count;
	}

	/*
	 * This method returns the attribute of the element
	 */
	public String getAttributeValue(WebElement element, String attribute) {
		String value = element.getAttribute(attribute);
		return value;
	}

	/*
	 * This method uploads the file
	 */
	public void pdfFileUpload(WebElement fddFileUploadBtn, String filePath) throws Exception {
		fddFileUploadBtn.clear();
		File file = new File(filePath);
		fddFileUploadBtn.sendKeys(file.getAbsolutePath());
	}

	/*
	 * This method clicks on the Radio button
	 */
	public void clickRadioButton(WebDriver driver, List<WebElement> lstRadiobuttons, String value) throws Exception {

		printDetailedTestStep("Click (Radio Button)", value);

		try {
			for (WebElement ele : lstRadiobuttons) {
				if (getAttributeValue(ele, "value").equalsIgnoreCase(value)) {
					if (ele.isSelected() == false) {
						ele.click();
					}
					break;
				}
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Was not able to click on Radio Button");
		}
	}

	// method to select yes or no radio
	public void clickRadioButton(WebDriver driver, WebElement radio, String value) throws Exception {

		printDetailedTestStep("Click (Radio Button)", value);

		try {

			if (getAttributeValue(radio, "value").contains(value)) {
				if (radio.isSelected() == false) {
					radio.click();
				}

			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Was not able to click on Radio Button");
		}
	}

	/*
	 * This Test Case is used in Reading the Test Case Id Based on Class and Method
	 * Name.
	 */
	public String readTestCaseInfo(String methodName) throws ClassNotFoundException {

		String mName = methodName.substring(methodName.lastIndexOf(".") + 1);
		String cName = methodName.replace(mName, "");
		cName = cName.substring(0, cName.lastIndexOf("."));

		cName = cName.substring(cName.indexOf(" ") + 1, cName.length());

		String testCaseId = "";
		String testCaseDescription = "";
		Class<?> aClass = Class.forName(cName);
		// Get the methods
		Method[] methods = aClass.getDeclaredMethods();
		// Loop through the methods and print out their names
		for (Method method : methods) {
			// System.out.println(method.getName());
			if ((method.isAnnotationPresent(com.builds.utilities.TestCase.class))
					&& method.getName().equalsIgnoreCase(mName)) {
				testCaseId = method.getAnnotation(com.builds.utilities.TestCase.class).testCaseId();
				testCaseDescription = method.getAnnotation(com.builds.utilities.TestCase.class).testCaseDescription();
			}
		}

		Reporter.log("Test_WorkFlow_Id# : " + testCaseId);
		System.out.println("Test_WorkFlow_Id# : " + testCaseId);

		String jid = cu.getJiraIdForTc_Id(testCaseId);
		if (jid != null && jid.length() > 0) {

		} else {
			jid = "";
		}

		Reporter.log("Start_Time# :" + getCurrentDateAndTime());
		Reporter.log("Test_WorkFlow_Description# : " + testCaseDescription);

		return testCaseId;
	}

	/*
	 * This Test Case is Used to Print the Test Step in the Excel Sheet against the
	 * Test Case.
	 */
	public void printTestStep(ExtentTest test, String testCaseStep) throws Exception {
		Reporter.log("Test Steps# :" + testCaseStep);
	}

	public void printTestStep(String testCaseStep) throws Exception {
		Reporter.log("Test Steps# :" + testCaseStep);
		Reporter.log("Detailed Test Steps# :" + testCaseStep);

	}

	/*
	 * This Test Case is Used to Wait for an Element for Given Time.
	 */
	public void webDriverWait(WebDriver driver, String xpath) throws Exception {
		getElementOnVisible(driver, "xpath", xpath);
	}

	/*
	 * This test case is used to check if the provided testCaseId has been executed
	 * once for one Test Cycle. If the test case is never executed then it is
	 * executed once and the excel sheet is updated.
	 */
	public boolean configurationTestCaseToExecute(String testCaseId) throws Exception {
		return cu.configurationTestCaseToExecute(testCaseId);
	}

	/*
	 * This Method is used to Generate Random 6 Digit number
	 */
	public String generateRandomNumber6Digit() {
		Random rnd = new Random();
		int randomNum = 100000 + rnd.nextInt(900000);
		String randomVal = String.valueOf(randomNum);
		return randomVal;
	}

	/*
	 * This method is used to select option from Bottom Action Menu
	 */
	public void selectMoreActionMenuItemsWithTagA(WebDriver driver, String menuName) throws Exception {

		printDetailedTestStep("Select (More Action Menu)", menuName);

		WebElement moreActionsLink = null;
		List<WebElement> menu = null;
		try {
			moreActionsLink = getElementByXpath(driver,
					".//*[@id='leadsForm']/a[.='More Actions' or @class='showActionMore link-btn text_b']");
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Unable to find Element:: " + moreActionsLink);
		}
		moveToElement(driver, moreActionsLink);
		clickElement(driver, moreActionsLink);
		sleep();
		try {
			menu = driver
					.findElements(By.xpath(".//*[@id='actionListButtons1']/table/tbody/tr[2]/td[2]/table/tbody/tr/td"));
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("unable to find Element::" + menu);
		}
		selectMoreActionMenu(driver, moreActionsLink, menu, menuName);
	}

	/**
	 * This method will return mailInfo from,to,subject,mailBody and receivedDate if
	 * the expectedSubject and expectedMessageBody matches the mail.
	 * 
	 * Provide Subject, Expected Message Body, Email and Password
	 */
	public Map<String, String> readMailBox(String expectedSubject, String expectedMessageBody, String userName,
			String password) throws Exception {

		Map<String, String> mailInfo = new HashMap<String, String>();
		boolean noConnection = false;

		for (int it = 0; it < 10; it++) {
			try {
				String hostName = "mail2.staffex.com";
				String provider = "pop3";

				Properties props = new Properties();

				// Create Session
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore(provider);

				try {
					store.connect(hostName, userName, password);
					noConnection = true;
				} catch (Exception e) {
					Reporter.log(e.getMessage().toString());
					noConnection = false;
					break;
				}
				// Open Folder

				Folder inbox = store.getFolder("INBOX");
				inbox.open(Folder.READ_ONLY);

				Message[] messages = inbox.getMessages();

				List<Message> m = new ArrayList<Message>();
				for (int x = 0; x < messages.length; x++) {
					m.add(messages[x]);
				}

				Collections.reverse(m);
				for (int x = 0; x < 1000 && x < m.size(); x++) {
					if (m != null && !m.isEmpty()) {
						String from = getFrom(m.get(x));
						String to = getTo(m.get(x));
						String subject = getSubject(m.get(x));
						String receivedDate = getReceivedDate(m.get(x));
						String mailBody = null;
						if (expectedSubject != null && subject != null
								&& expectedSubject.trim().equalsIgnoreCase(subject.trim())) {

							mailBody = getTextFromMessage(m.get(x));
							if (mailBody.contains(expectedMessageBody)) {
								mailInfo.put("from", from);
								mailInfo.put("to", to);
								mailInfo.put("subject", subject);
								mailInfo.put("mailBody", mailBody);
								mailInfo.put("receivedDate", receivedDate);
								return mailInfo;
							}
						}
					}
				}
				inbox.close(false);
				store.close();
			} catch (Exception e) {
				Reporter.log(e.getMessage().toString());
			}
			sleep(1500);
		}

		if (!noConnection) {
			throwsException("Please check mail id / password is not correct");
		}

		if (mailInfo.size() <= 0) {
			throwsException(
					"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		}
		throwsException(
				"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		return mailInfo;
	}
	
	public Map<String, String> readMailBoxFddInfoMgr(String expectedSubject, String expectedMessageBody, String userName,
			String password) throws Exception {

		Map<String, String> mailInfo = new HashMap<String, String>();
		boolean noConnection = false;

		for (int it = 0; it < 10; it++) {
			try {
				String hostName = "mail2.staffex.com";
				String provider = "pop3";

				Properties props = new Properties();

				// Create Session
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore(provider);

				try {
					store.connect(hostName, userName, password);
					noConnection = true;
				} catch (Exception e) {
					Reporter.log(e.getMessage().toString());
					noConnection = false;
					break;
				}
				// Open Folder

				Folder inbox = store.getFolder("INBOX");
				inbox.open(Folder.READ_ONLY);

				Message[] messages = inbox.getMessages();

				List<Message> m = new ArrayList<Message>();
				for (int x = 0; x < messages.length; x++) {
					m.add(messages[x]);
				}

				Collections.reverse(m);
				for (int x = 0; x < 10 && x < m.size(); x++) {
					if (m != null && !m.isEmpty()) {
						String subject = getSubject(m.get(x));
						String mailBody = null;
						if (expectedSubject != null && subject != null
								&& expectedSubject.trim().equalsIgnoreCase(subject.trim())) {

							mailBody = getTextFromMessage(m.get(x));
								mailInfo.put("subject", subject);
								mailInfo.put("mailBody", mailBody);
								return mailInfo;
							}
						}
				}
				inbox.close(false);
				store.close();
			} catch (Exception e) {
				Reporter.log(e.getMessage().toString());
			}
			sleep(30000);
		}

		if (!noConnection) {
			throwsException("Please check mail id / password is not correct");
		}

		if (mailInfo.size() <= 0) {
			throwsException(
					"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		}
		throwsException(
				"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		return mailInfo;
	}

	/*
	 * This method will return mailInfo from,to,subject,mailBody and receivedDate if
	 * the expectedSubject and expectedMessageBody matches the mail.
	 */
	public Map<String, String> readMailBoxForNoMail(String expectedSubject, String expectedMessageBody, String userName,
			String password) throws Exception {

		Map<String, String> mailInfo = new HashMap<String, String>();

		for (int it = 0; it < 5; it++) {
			if (mailInfo == null || mailInfo.size() <= 0) {
				try {
					String hostName = "mail2.staffex.com";
					String provider = "pop3";
					Properties props = new Properties();

					// Create Session
					Session session = Session.getDefaultInstance(props, null);
					Store store = session.getStore(provider);
					store.connect(hostName, userName, password);

					// Open Folder
					Folder inbox = store.getFolder("INBOX");
					inbox.open(Folder.READ_ONLY);
					Message[] messages = inbox.getMessages();

					List<Message> m = new ArrayList<Message>();
					for (int x = 0; x < messages.length; x++) {
						m.add(messages[x]);
					}
					Collections.reverse(m);

					for (int x = 0; x < 1000 && x < m.size(); x++) {
						if (m != null && !m.isEmpty()) {
							String from = getFrom(m.get(x));
							String to = getTo(m.get(x));
							String subject = getSubject(m.get(x));
							String receivedDate = getReceivedDate(m.get(x));
							String mailBody = null;
							if (expectedSubject != null && subject != null
									&& expectedSubject.trim().equalsIgnoreCase(subject.trim())) {
								mailBody = getTextFromMessage(m.get(x));
								if (mailBody.contains(expectedMessageBody)) {
									mailInfo.put("from", from);
									mailInfo.put("to", to);
									mailInfo.put("subject", subject);
									mailInfo.put("mailBody", mailBody);
									mailInfo.put("receivedDate", receivedDate);
									return mailInfo;
								}
							}
						}
					}
					inbox.close(false);
					store.close();
				} catch (Exception e) {
				}
			}
			sleep(30000);
		}
		if (mailInfo.size() <= 0) {
			mailInfo.put("flag", "true");
		} else {
			mailInfo.put("flag", "false");
		}
		return mailInfo;
	}

	public Map<String, String> readMailBoxGmail(String expectedSubject, String expectedMessageBody, String userName,
			String password) throws Exception {

		Map<String, String> mailInfo = new HashMap<String, String>();
		boolean noConnection = false;

		for (int it = 0; it < 20; it++) {
			try {
				String hostName = "pop.gmail.com";
				String provider = "imaps";

				Properties props = new Properties();

				// Create Session
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore(provider);

				try {
					store.connect(hostName, userName, password);
					noConnection = true;
				} catch (Exception e) {
					Reporter.log(e.getMessage().toString());
					noConnection = false;
					break;
				}
				// Open Folder

				Folder inbox = store.getFolder("INBOX");
				inbox.open(Folder.READ_ONLY);

				Message[] messages = inbox.getMessages();

				List<Message> m = new ArrayList<Message>();
				for (int x = 0; x < messages.length; x++) {
					m.add(messages[x]);
				}

				Collections.reverse(m);
				for (int x = 0; x < 1000 && x < m.size(); x++) {
					if (m != null && !m.isEmpty()) {
						String from = getFrom(m.get(x));
						String to = getTo(m.get(x));
						String subject = getSubject(m.get(x));
						// System.out.println("actual:"+subject);
						String receivedDate = getReceivedDate(m.get(x));
						String mailBody = null;
						if (expectedSubject != null && subject != null
								&& expectedSubject.trim().equalsIgnoreCase(subject.trim())) {

							mailBody = getTextFromMessage(m.get(x));
							// System.out.println("actual:"+mailBody);
							if (mailBody.contains(expectedMessageBody)) {
								mailInfo.put("from", from);
								mailInfo.put("to", to);
								mailInfo.put("subject", subject);
								mailInfo.put("mailBody", mailBody);
								mailInfo.put("receivedDate", receivedDate);
								return mailInfo;
							}
						}
					}
				}
				inbox.close(false);
				store.close();
			} catch (Exception e) {
				Reporter.log(e.getMessage().toString());
			}

		}

		if (!noConnection) {
			throwsException("Please check mail id / password is not correct");
		}

		if (mailInfo.size() <= 0) {
			throwsException(
					"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		}
		return mailInfo;
	}
	
	public Map<String, String> readMailBoxContent(String expectedSubject, String expectedMessageBody, String userName,
			String password) throws Exception {

		expectedSubject = expectedSubject.toLowerCase();
		Map<String, String> mailInfo = new HashMap<String, String>();
		boolean noConnection = false;

		for (int it = 0; it < 10; it++) {
			try {
				String hostName = "mail2.staffex.com";
				String provider = "pop3";

				Properties props = new Properties();

				// Create Session
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore(provider);

				try {
					store.connect(hostName, userName, password);
					noConnection = true;
				} catch (Exception e) {
					Reporter.log(e.getMessage().toString());
					noConnection = false;
					break;
				}
				// Open Folder

				Folder inbox = store.getFolder("INBOX");
				inbox.open(Folder.READ_ONLY);

				Message[] messages = inbox.getMessages();

				List<Message> m = new ArrayList<Message>();
				for (int x = 0; x < messages.length; x++) {
					m.add(messages[x]);
					
				}

				Collections.reverse(m);
				for (int x = 0; x < 10 && x < m.size(); x++) {
					if (m != null && !m.isEmpty()) {
						String from = getFrom(m.get(x));
						String to = getTo(m.get(x));
						String subject = getSubject(m.get(x)).toLowerCase();
						String receivedDate = getReceivedDate(m.get(x));
						String mailBody = null;
						System.out.println(subject);
						if (expectedSubject != null && subject != null
								&& subject.trim().contains(expectedSubject.trim())) {

							mailBody = getTextFromMessage(m.get(x));
							if (mailBody.contains("?")) {
								mailBody = mailBody.replace("?", "");
							}
							//if (mailBody.contains(expectedMessageBody)) {
								mailInfo.put("from", from);
								mailInfo.put("to", to);
								mailInfo.put("subject", subject);
								mailInfo.put("mailBody", mailBody);
								mailInfo.put("receivedDate", receivedDate);
								return mailInfo;
							//}
						}
					}
				}
				inbox.close(false);
				store.close();
			} catch (Exception e) {
				Reporter.log(e.getMessage().toString());
			}
			sleep(1500);
		}

		if (!noConnection) {
			throwsException("Please check mail id / password is not correct");
		}

		if (mailInfo.size() <= 0) {
			throwsException(
					"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		}
		throwsException(
				"Unable to Read Email in the Mail Box. / Mail not Found in the Mail Box. (wait time 5 minutes)");
		return mailInfo;
	}

	private String getTextFromMessage(Message message) throws Exception {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}

	private static String getFrom(Message javaMailMessage) throws MessagingException {
		String from = "";
		Address a[] = javaMailMessage.getFrom();
		if (a == null)
			return null;
		for (int i = 0; i < a.length; i++) {
			Address address = a[i];
			from = from + address.toString();
		}
		return from;
	}

	private static String getTo(Message javaMailMessage) throws MessagingException {
		String to = "";
		Address a[] = javaMailMessage.getAllRecipients();
		if (a == null)
			return null;
		for (int i = 0; i < a.length; i++) {
			Address address = a[i];
			to = to + address.toString();
		}
		return to;
	}

	private static String getSubject(Message javaMailMessage) throws MessagingException {
		String subject = "";

		try {
			subject = javaMailMessage.getSubject();
		} catch (Exception e) {
			// Reporter.log(e.getMessage());
		}

		return subject;
	}

	private String getReceivedDate(Message javaMailMessage) throws MessagingException {
		Date date = null;
		String dateStr = null;

		try {
			date = javaMailMessage.getReceivedDate();
			dateStr = date.toString();
		} catch (Exception e) {
			// Reporter.log(e.getMessage());
		}

		return dateStr;
	}

	// Create Base Folder In Google Drive

	public String getCurrentYear() {

		Calendar now = Calendar.getInstance(); // Gets the current date and time
		int year = now.get(Calendar.YEAR); // The current year

		String currentYear = Integer.toString(year);

		return currentYear;
	}

	/**
	 * This Method is used for make short URl using google Url shortening API
	 */

	/* Harish Dwivedi */

	public void selectCustomManadatoryFieldsOfClient(WebDriver driver, String menuName) throws Exception {

		List<WebElement> mandateBox = null;
		mandateBox = driver.findElements(By.xpath(
				".//*[@id='startRecords']/.//*[@class='urgent_fields']/ancestor::td[1]/following-sibling::td[1]//*[@type='text' or @class='fTextBoxDate' or @class='fTextBox' or @class='multiList' or @type='radio' or @type='checkbox' or @type='checkBox' or @id='ms-parentsellerCombo' or @class='ms-choice' or @class='form-control' ]"));
		if ("fs".equals(menuName))
			mandateBox = driver.findElements(By.xpath(
					".//*[@id='siteMainTable']/.//*[@class='urgent_fields']/ancestor::td[1]/following-sibling::td[1]//*[@type='text' or @class='fTextBoxDate' or @class='fTextBox' or @class='multiList' or @type='radio' or @type='checkbox' or @type='checkBox' or @id='ms-parentsellerCombo' or @class='ms-choice' or @class='form-control' ]"));
		else if ("crm".equals(menuName))
			mandateBox = driver.findElements(By.xpath(
					".//*[@id='siteMainBody']/.//*[@class='urgent_fields']/ancestor::td[1]/following-sibling::td[1]//*[@type='text' or @class='fTextBoxDate' or @class='fTextBox' or @class='multiList' or @type='radio' or @type='checkbox' or @type='checkBox' or @id='ms-parentsellerCombo' or @class='ms-choice' or @class='form-control' ]"));

		Map<String, String> alreadyradio = new HashMap<>();
		Map<String, String> alreadycheckBox = new HashMap<>();
		Map<String, String> alreadyitrateElement = new HashMap<>();
		try {
			for (WebElement webElement : mandateBox) {

				if (webElement.getAttribute("name").startsWith("_")) {
					WebElement elementmovepostion = driver.findElement(By.id("" + webElement.getAttribute("id")));
					moveToElement(driver, elementmovepostion);

					if (alreadyitrateElement.containsKey(webElement.getAttribute("id"))) {

					} else {

						System.out.println(webElement.getAttribute("id") + "=====>>" + webElement.getAttribute("value")
								+ "=====Type=" + webElement.getAttribute("type"));
						if (webElement.getAttribute("type").indexOf("select-one") != -1) {
							Select singledrop = new Select(
									driver.findElement(By.id("" + webElement.getAttribute("id"))));
							if (webElement.getAttribute("value") == null || "".equals(webElement.getAttribute("value"))
									|| "null".equals(webElement.getAttribute("value"))
									|| "-1".equals(webElement.getAttribute("value"))) {
								singledrop.selectByIndex(1);
							}

						} else if (webElement.getAttribute("type").indexOf("select-multiple") != -1) {
							if (webElement.getAttribute("value") == null || "".equals(webElement.getAttribute("value"))
									|| "null".equals(webElement.getAttribute("value"))
									|| "-1".equals(webElement.getAttribute("value"))) {
								WebElement element = driver
										.findElement(By.id("ms-parent" + webElement.getAttribute("id")));
								clickElement(driver, element);
								clickElement(driver, driver.findElement(By.xpath(".//*[@id='selectAll']")));
								clickElement(driver, element);
							}
						} else if (webElement.getAttribute("type").indexOf("textarea") != -1) {
							if (webElement.getAttribute("value") == null || "".equals(webElement.getAttribute("value"))
									|| "null".equals(webElement.getAttribute("value"))) {
								driver.findElement(By.name("" + webElement.getAttribute("id")))
										.sendKeys("CustomTaxt_" + webElement.getAttribute("type"));
							}
						} else if (webElement.getAttribute("type").indexOf("radio") != -1) {
							try {
								String sValue = "";
								List<WebElement> rdBtn_Sex = driver
										.findElements(By.name("" + webElement.getAttribute("id"))); //
								// Thread.sleep(5000);
								if (alreadyradio.containsKey(webElement.getAttribute("id"))) {

								} else {

									int size = rdBtn_Sex.size();
									for (int i = 0; i < size; i++) {
										// Thread.sleep(1000);
										sValue = rdBtn_Sex.get(i).getAttribute("value");
										if (i == (size - 1)) {
											// Thread.sleep(1000);
											// rdBtn_Sex.get(0).click();
										}

									}
									// Thread.sleep(1000);
									List<WebElement> rdBtn_Field = driver.findElements(
											By.xpath("//*[contains(@name, '" + webElement.getAttribute("id") + "')]")); // work
									WebElement element = driver.findElement(
											By.xpath("//*[contains(@name, '" + webElement.getAttribute("id") + "')]"));
									moveToElement(driver, element);
									clickRadioButton(driver, rdBtn_Field, sValue); // work
									alreadyradio.put(webElement.getAttribute("id"), webElement.getAttribute("id"));
								}
							} catch (Exception exp) {
								Reporter.log(exp.toString());
								exp.printStackTrace();
							}

						} else if (webElement.getAttribute("type").toLowerCase().indexOf("checkbox") != -1) {
							List<WebElement> oCheckBox = driver
									.findElements(By.name("" + webElement.getAttribute("id")));
							String sValue = "";
							if (alreadycheckBox.containsKey(webElement.getAttribute("id"))) {

							} else {

								int size = oCheckBox.size();
								for (int i = 0; i < size; i++) {
									sValue = oCheckBox.get(i).getAttribute("value");
									// Thread.sleep(2000);
									if (i == (size - 1)) {
										// break;
									}

								}
								List<WebElement> rdBtn_Field = driver.findElements(
										By.xpath("//*[contains(@name, '" + webElement.getAttribute("id") + "')]")); // work
								WebElement element = driver.findElement(
										By.xpath("//*[contains(@name, '" + webElement.getAttribute("id") + "')]"));
								moveToElement(driver, element);
								clickRadioButton(driver, rdBtn_Field, sValue); // work
								alreadycheckBox.put(webElement.getAttribute("id"), webElement.getAttribute("id"));
							}

						} else if (webElement.getAttribute("type").indexOf("file") != -1) {
							String fileName = getFilePathFromTestData("pictureFile");
							sendKeys(driver, driver.findElement(By.id("" + webElement.getAttribute("id"))), fileName);
						} else if (webElement.getAttribute("type").indexOf("text") != -1) {
							if (webElement.getAttribute("value") == null || "".equals(webElement.getAttribute("value"))
									|| "null".equals(webElement.getAttribute("value"))) {
								if (webElement.getAttribute("class").indexOf("fTextBoxDate") != -1) {
									sendKeys(driver, driver.findElement(By.name("" + webElement.getAttribute("id"))),
											"02/08/2018"); // work
								} else {
									driver.findElement(By.name("" + webElement.getAttribute("id"))).sendKeys("21");

								}
							}
						}
						alreadyitrateElement.put(webElement.getAttribute("id"), webElement.getAttribute("id"));
					}

				}

				// System.out.println(webElement.getText());
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Was not able fill custom fields by client" + e.getMessage());

		}
	}// End

	/*
	 * This method is used to select value in multi select field
	 */
	public void selectValFromMultiSelectwithoutSelectAll(WebDriver driver, WebElement element, String value)
			throws Exception {

		printDetailedTestStep("Select (Multi Select)", element, value);

		try {
			sleep(500);
			clickElement(driver, element);
			sleep(500);

			/*
			 * WebElement selectAllCheck=element.findElement(By.xpath(
			 * ".//*[@id='selectAll']"));
			 * 
			 * if (selectAllCheck.isSelected()) { clickElement(driver, selectAllCheck); }
			 */

			// WebElement searchTextBox =
			// element.findElement(By.xpath(".//input[@class='searchInputMultiple']"));

			WebElement searchTextBox = element.findElement(By.xpath("./div/div/input"));

			sendKeys(driver, searchTextBox, value);
			clickEnterOnElement(driver, searchTextBox);
			sleep(500);

			WebElement element3 = element.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
			try {

				if (!element3.isSelected()) {
					clickElement(driver, element3);
				}

			} catch (Exception e) {
				Reporter.log(e.getMessage());
				throwsException("Search Value not present in Multi Select Box");
			}

			clickElement(driver, element);

		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box");
		}
	}

	/*
	 * This method returns the current month (Full Name of month)
	 */
	public String getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		return month;
	}

	/*
	 * This method is used to select value in Action Menu(Of Tag A With MoreAction
	 * CRM > Contact Page)
	 */
	public void selectActionMenuItemsWithTagACRM(WebDriver driver, String menuName) throws Exception {
		WebElement moreActionsLink = null;
		List<WebElement> menu = null;
		try {
			moreActionsLink = driver
					.findElement(By.xpath(".//*[@class='showAction_cdetails link-btn' and .='More Actions']"));
		} catch (Exception e) {
			Reporter.log("Method selectActionMenuItemsWithTagInput : " + e.toString());
			throwsException("Unable to find Element:: " + moreActionsLink);
		}
		moveToElement(driver, moreActionsLink);
		clickElement(driver, moreActionsLink);
		sleep();
		try {
			menu = driver.findElements(
					By.xpath(".//*[@id='actionListButtonsForCM']/table/tbody/tr[2]/td[2]/table/tbody/tr/td"));
		} catch (Exception e) {
			Reporter.log("Method selectActionMenuItemsWithTagInput : " + e.toString());
			throwsException("unable to find Element::" + menu);
		}
		selectMoreActionMenu(driver, moreActionsLink, menu, menuName);
	}

	public String getMajorSpecialCharacter() {
		String specialChar = "$`~!@#%^&*(-+={_[:|;'\",.?";
		System.out.println(specialChar);
		return specialChar;
	}

	public Map<String, String> readTestData(String moduleName, String testCaseId) throws Exception {
		Reporter.log("Finding Test Data From DataBase....");
		Map<String, Map<String, String>> tableMap = null;

		String tableName = "";

		if (moduleName.toLowerCase().contains("infomgrrestapi")) {
			tableName = "infomgr_rest_api";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("salesrestapi")) {
			tableName = "sales_rest_api";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("support")) {
			tableName = "SUPPORT";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("sales")) {
			tableName = "SALES";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("crm")) {
			tableName = "CRM";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("finance")) {
			tableName = "FINANCE";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("infomgr")) {
			tableName = "INFOMGR";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("training")) {
			tableName = "TRAINING";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("opener")) {
			tableName = "OPENER";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("admin")) {
			tableName = "ADMIN";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("thehub")) {
			tableName = "THEHUB";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("fieldops")) {
			tableName = "FIELDOPS";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		} else if (moduleName.toLowerCase().contains("crmworkflow")
				|| moduleName.toLowerCase().contains("crmcampaigncenter")) {
			tableName = "CRM_CAMPAIGN_CENTER";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		}else if (moduleName.toLowerCase().contains("shop")) {
			tableName = "SHOP_TESTCASE";
			tableMap = getTableDataFromDB(tableName, testCaseId);
		}

		if (tableMap != null && tableMap.size() > 0) {

			for (Entry<String, Map<String, String>> entry : tableMap.entrySet()) {
				if (entry.getKey().equalsIgnoreCase(testCaseId)) {
					return entry.getValue();
				}
			}
		}

		return readTestData(testCaseId);
	}

	private Map<String, Map<String, String>> getTableDataFromDB(String tableName, String testCaseId) throws Exception {
		Map<String, Map<String, String>> testData = new HashMap<String, Map<String, String>>();

		tableName = tableName.trim().toUpperCase();

		try {

			String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
			java.sql.Connection conn = null;
			Statement stmt = null;
			String sql;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			stmt = conn.createStatement();

			String TC_ID = "";
			String TCKEY = "";
			String TCVAL = "";

			sql = "SELECT * FROM " + tableName + " WHERE TC_ID IN ('" + testCaseId + "')";
			ResultSet rs = stmt.executeQuery(sql);
			int size = rs.getFetchSize();
			// ResultSet rsTemp = stmt.executeQuery(sql);
			// rsTemp.next();
			int cnt = 0;
			while (rs.next()) {
				Map<String, String> keyval = new HashMap<String, String>();
				TC_ID = rs.getString("TC_ID");
				TCKEY = rs.getString("TCKEY");
				TCVAL = rs.getString("TCVAL");
				keyval.put(TCKEY, TCVAL);
				// System.out.println(TC_ID);
				// rs.next();
				if (rs.isLast() == false) {
					while (rs.next()) {
						String nextTestCaseId = rs.getString("TC_ID");
						if (nextTestCaseId.equalsIgnoreCase(TC_ID)) {
							// TC_ID = rs.getString("TC_ID");
							// System.out.println("Compare : "+tempTestCaseId);
							TCKEY = rs.getString("TCKEY");
							TCVAL = rs.getString("TCVAL");
							keyval.put(TCKEY, TCVAL);

							testData.put(TC_ID, keyval);
						}

						else {
							rs.previous();
							break;
						}
					}
				} else {
					testData.put(TC_ID, keyval);
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// throw new SkipException(e.getMessage());
		}

		return testData;
	}

	/* This method is used to get translation key-values from Database */
	public List<String> translate(String searchKey) throws IOException {

		List<String> listValues = new ArrayList<>();
		try {
			String i18n = FranconnectUtil.config.get("i18Files");
			if (i18n != null && !i18n.isEmpty()) {
				String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				String valueName = null;
				conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
				PreparedStatement stmtp = conn
						.prepareStatement("select VALUE_NAME from TRANSLATION where KEY_NAME=(?)");

				stmtp.setString(1, searchKey);
				ResultSet rs = stmtp.executeQuery();
				while (rs.next()) {
					valueName = rs.getString("VALUE_NAME");
					listValues.add(valueName);
				}
				stmtp.close();
				conn.close();
			}

			else {
				listValues.add(searchKey);

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return listValues;

	}

	public String translateString(String searchKey) throws IOException {

		String valueName = null;
		try {
			String i18n = FranconnectUtil.config.get("i18Files");
			if (i18n != null && !i18n.isEmpty()) {
				String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
				PreparedStatement stmtp = conn
						.prepareStatement("select VALUE_NAME from TRANSLATION where KEY_NAME=(?)");

				stmtp.setString(1, searchKey);
				ResultSet rs = stmtp.executeQuery();
				if (rs.next()) {
					valueName = rs.getString("VALUE_NAME");
					// listValues.add(valueName);
				}
				stmtp.close();
				conn.close();
			}

			else {
				valueName = searchKey;

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return valueName;

	}

	public void clickElementByJS(WebDriver driver, WebElement element) throws Exception {

		printDetailedTestStep("Click (JavaScriptExecuter)", element);

		boolean isElementClickable = false;
		for (int x = 0; x < 3; x++) {
			try {
				if (isElementClickable == false) {
					// element.click();
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					isElementClickable = true;
				}
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				isElementClickable = false;
				sleep();
			}
		}

		if (isElementClickable == false) {
			throwsException("Element not clickable : " + element);
		}
	}

	/*
	 * This method is used for verify value in MultiSelect Box
	 */

	public boolean assertMultiSelect(WebDriver driver, WebElement element, String value) throws Exception {
		boolean isTextFound = false;
		try {
			sleep(500);
			clickElement(driver, element);
			String tempText = null;

			List<WebElement> elementList = element.findElements(By.xpath(".//ul/li/label"));

			for (WebElement webElement : elementList) {
				tempText = webElement.getText();
				if (tempText != null && tempText.length() > 0) {
					tempText = tempText.trim();

					if (tempText.equalsIgnoreCase(value)) {
						isTextFound = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}
		return isTextFound;
	}

	// soft Assertion to compare values
	public void assertCompareValues(String expected, String actual) throws Exception {

		if (expected.equals(actual)) {

		} else {
			throwsException("Assertion failed , Expected and Actual Values donot Match " + expected + "," + actual);
		}

	}

	public boolean isAlertPresent(WebDriver driver) {

		printDetailedTestStep("Check if Alert is present.");

		try {
			Alert alert = driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clipBoardData(String myString) {
		StringSelection stringSelection = new StringSelection(myString);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}

	public void selectRadioValueInDropDown(WebDriver driver, WebElement dropdown, WebElement searchTextField,
			String searchText) throws Exception {

		printDetailedTestStep("Select Radio", dropdown, searchTextField);

		moveToElement(driver, dropdown);
		clickElement(driver, dropdown);
		sendKeys(driver, searchTextField, searchText);
		clickElement(driver, dropdown.findElement(By.xpath(".//*[.='" + searchText + "']")));
	}

	/*
	 * This method is used to click on the action img on the right
	 */
	public boolean optionPresentInActionMenu(WebDriver driver, String task, String option) throws Exception {

		boolean optionsPresent = false;

		try {
			moveToElement(driver, getElementByXpath(driver,
					(".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer")));
			String alterText = driver
					.findElement(By
							.xpath(".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer"))
					.getAttribute("id").trim();
			alterText = alterText.replace("Actions_dynamicmenu", "");
			alterText = alterText.replace("Bar", "");
			clickElement(driver, getElementByXpath(driver,
					".//*[contains(text () ,'" + task + "')]/ancestor::tr/td/div[@id='menuBar']/layer/a/img"));
			optionsPresent = driver.findElement(By.xpath(
					".//div[@id='Actions_dynamicmenu" + alterText + "Menu']/*[contains(text () , '" + option + "')]"))
					.isDisplayed();
		} catch (Exception e) {
			optionsPresent = false;
		}
		return optionsPresent;
	}

	/*
	 * This method is used to verify multiple options from action icon
	 */

	/*
	 * This method is used to click on the action img on the right
	 */
	public void optionPresentInActionMenu(WebDriver driver, String title, List<String> options) throws Exception {
		String temp = null;
		boolean optionsPresent = false;

		try {
			moveToElement(driver, getElementByXpath(driver,
					(".//*[contains(text () ,'" + title + "')]/ancestor::tr/td/div[@id='menuBar']/layer")));
			String alterText = driver
					.findElement(By
							.xpath(".//*[contains(text () ,'" + title + "')]/ancestor::tr/td/div[@id='menuBar']/layer"))
					.getAttribute("id").trim();
			alterText = alterText.replace("Actions_dynamicmenu", "");
			alterText = alterText.replace("Bar", "");
			clickElement(driver, getElementByXpath(driver,
					".//*[contains(text () ,'" + title + "')]/ancestor::tr/td/div[@id='menuBar']/layer/a/img"));

			for (int i = 0; i < options.size(); i++) {
				temp = options.get(i);
				optionsPresent = driver.findElement(By.xpath(".//div[@id='Actions_dynamicmenu" + alterText
						+ "Menu']/*[contains(text () , '" + options.get(i) + "')]")).isDisplayed();
			}
		} catch (Exception e) {
			optionsPresent = false;
		}
		if (optionsPresent == false) {
			throwsException(temp + " Option is not available in Action Icon");
		}
	}

	/*
	 * This method is used to get current date us format
	 */
	public String getCurrentDateUserDefineTimeZoneUSFormat(String timeZone) {
		// GMT-5:00
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	/**
	 * This will return with passed formate and timezone 10/01/2018 06:36 AM
	 * 
	 * @param format
	 * @param timezone
	 * @return
	 * @throws Exception
	 */
	public String getCurrentTimeUDF(String format, String timezone) throws Exception {

		if (format.isEmpty()) {
			format = "MM/dd/yyyy hh:mm aa";
		}
		if (timezone.isEmpty()) {
			timezone = "GMT-4:00";
		}

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat(format);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone(timezone));
		// Local time zone
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(format);
		// Time in GMT
		Date date = dateFormatLocal.parse(dateFormatGmt.format(new Date()));
		String dateS = dateFormatLocal.format(date);
		return dateS;
	}

	/*
	 * This method is used to get future date in us format with timezone
	 */

	public String getFutureDateUserDefineTimeZoneUSFormat(String timeZone, int afterNoOfDays) {
		// GMT-5:00
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
		Date now = DateUtils.addDays(new Date(), afterNoOfDays);
		String strDate = sdfDate.format(now);
		return strDate;
	}

	private WebElement getElementOnVisible(WebDriver driver, String locatorType, String value) throws Exception {
		MyWaitClass waitMethod = new MyWaitClass();
		return waitMethod.getElement(driver, locatorType, value);
	}

	private WebElement getElementOnClickable(WebDriver driver, String locatorType, String value) throws Exception {
		MyWaitClass waitMethod = new MyWaitClass();
		return waitMethod.getElementOnClickable(driver, locatorType, value);
	}

	public WebElement getElementByXpath(WebDriver driver, String xpath) throws Exception {
		return getElementOnVisible(driver, "xpath", xpath);
	}

	public WebElement getElementByID(WebDriver driver, String id) throws Exception {
		return getElementOnVisible(driver, "id", id);
	}

	public WebElement getElementByLinkText(WebDriver driver, String linkText) throws Exception {
		return getElementOnVisible(driver, "linkText", linkText);
	}

	public WebElement getElementByPartialLinkText(WebDriver driver, String partialLinkText) throws Exception {
		return getElementOnVisible(driver, "partialLinkText", partialLinkText);
	}

	public WebElement getElementByName(WebDriver driver, String name) throws Exception {
		return getElementOnVisible(driver, "name", name);
	}

	public WebElement getElementByCssSelector(WebDriver driver, String cssSelector) throws Exception {
		return moveToElement(driver, getElementOnVisible(driver, "cssSelector", cssSelector));
	}

	public WebElement getElementByTagName(WebDriver driver, String tagName) throws Exception {
		return getElementOnVisible(driver, "tagName", tagName);
	}

	public WebElement getElementByClassName(WebDriver driver, String className) throws Exception {
		return getElementOnVisible(driver, "className", className);
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

	public List<WebElement> getElementListByXpath(WebDriver driver, String xpath) throws Exception {

		MyWaitClass waitMethod = new MyWaitClass();
		waitMethod.getElement(driver, "xpath", xpath);
		return driver.findElements(By.xpath(xpath));

		/*
		 * if (list.size() > 0) { return driver.findElements(By.xpath(xpath)); } else {
		 * throw new Exception("Element not found : " + xpath); }
		 */
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
	 * This method search for the value (spaces removed) in Drop Down box.
	 */
	public boolean selectDropDownByVisibleTextTrimed(WebDriver driver, WebElement dropDown, String visibleText)
			throws Exception {

		printTestStep("Select Value in Drop Down : " + visibleText);

		moveToElement(driver, dropDown);

		Select listing = null;
		try {
			listing = new Select(dropDown);
			List<WebElement> listValues = listing.getOptions();
			for (int x = 0; x < listValues.size(); x++) {
				if (listValues.get(x).getText().trim().equalsIgnoreCase(visibleText.trim())) {
					return SelectDropDownValue(driver, listing, "index", String.valueOf(x));
				}
			}
		} catch (Exception e) {
			throwsException("Issue in selecting Drop Down value : " + dropDown);
		}
		return false;
	}

	/*
	 * This method Select the Value in Drop Down by the index value
	 */
	public void selectDropDownByIndex(WebDriver driver, WebElement dropDown, int testValue) throws Exception {

		printTestStep("Select Value in Drop Down : " + testValue);

		moveToElement(driver, dropDown);

		Select listing = null;
		try {
			listing = new Select(dropDown);
		} catch (Exception e) {
			throwsException("Field not found : " + dropDown);
		}

		try {
			SelectDropDownValue(driver, listing, "index", String.valueOf(testValue));
		} catch (Exception e) {
			throwsException("Unable to Select given value :" + testValue + " in field : " + dropDown);
		}
	}

	/*
	 * This method is used to select drop down value
	 */
	public void selectDropDown(WebDriver driver, WebElement dropDownField, String txt) throws Exception {

		printDetailedTestStep("Select", dropDownField, String.valueOf(txt));

		moveToElement(driver, dropDownField);

		try {
			Select dropDown = new Select(dropDownField);
			SelectDropDownValue(driver, dropDown, "visibleText", txt);
		} catch (Exception e) {
			throwsException("Not able to select value " + txt + " from drop down :" + dropDownField);
		}
	}

	/*
	 * This method is used to select drop down value by index
	 */
	public void selectDropDown(WebDriver driver, WebElement dropDownField, int txt) throws Exception {

		printDetailedTestStep("Select", dropDownField, String.valueOf(txt));

		moveToElement(driver, dropDownField);
		try {
			Select dropDown = new Select(dropDownField);
			SelectDropDownValue(driver, dropDown, "index", String.valueOf(txt));
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Not able to select value " + txt + " from drop down :" + dropDownField);
		}
	}

	/*
	 * This method is used to select drop down value by value
	 */
	public void selectDropDownByValue(WebDriver driver, WebElement dropDownField, String txt) throws Exception {

		printDetailedTestStep("Select", dropDownField, txt);

		Select dropDown = new Select(dropDownField);
		moveToElement(driver, dropDownField);
		dropDown = new Select(dropDownField);
		boolean isTextPresent = false;

		// logReport("Selecting Value in Drop Down", dropDownField);
		try {
			List<String> linkArray = translate(txt);
			if (!(linkArray.size() < 1)) {
				for (int i = 0; i < linkArray.size(); i++) {
					try {
						// element=driver.findElement(By.linkText(linkArray.get(i)));
						txt = linkArray.get(i);
						isTextPresent = SelectDropDownValue(driver, dropDown, "value", txt);
						break;
					} catch (Exception e) {
					}
				}
			} else {
				isTextPresent = SelectDropDownValue(driver, dropDown, "value", txt);
			}

			if (isTextPresent == false) {
				throwsException("Not able to select value " + txt + " from drop down :" + dropDownField);
			}

			// logReportMsg("Value selected in drop down",txt);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Not able to select value " + txt + " from drop down :" + dropDownField);
		}
	}

	/*
	 * This method is used to select drop down value by Visible Text
	 */
	public void selectDropDownByVisibleText(WebDriver driver, WebElement dropDownField, String txt) throws Exception {

		printDetailedTestStep("Select", dropDownField, txt);

		Select dropDown = null;
		try {
			moveToElement(driver, dropDownField);
			boolean isTextPresent = false;
			List<String> linkArray = translate(txt);
			dropDown = new Select(dropDownField);

			if (dropDown.getOptions().size() < 1) {
				sleep(2500);
				dropDown = new Select(dropDownField);
			}

			if (!(linkArray.size() < 1)) {
				for (int i = 0; i < linkArray.size(); i++) {
					try {
						txt = linkArray.get(i);
						isTextPresent = SelectDropDownValue(driver, dropDown, "visibleText", txt);
						break;
					} catch (Exception e) {
					}
				}
			} else {
				isTextPresent = SelectDropDownValue(driver, dropDown, "visibleText", txt);
			}

			if (isTextPresent == false) {
				throwsException("Not able to select value " + txt + " from drop down :" + dropDownField);
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Value not selected in drop down / list : " + txt);
		}
	}

	public void selectDropDownByVisibleText(WebDriver driver, String elt, String txt) throws Exception {

		printDetailedTestStep("Select", elt, txt);

		WebElement dropDownField = getElementfromText(driver, elt);
		Select dropDown = null;
		try {
			moveToElement(driver, dropDownField);
			dropDown = new Select(dropDownField);
			SelectDropDownValue(driver, dropDown, "visibleText", txt);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Value not selected in drop down / list : " + txt);
		}
	}

	/*
	 * This method is used to select drop down value by partial text
	 */
	public void selectDropDownByPartialText(WebDriver driver, WebElement dropDownField, String txt) throws Exception {

		printDetailedTestStep("Select", dropDownField, txt);

		moveToElement(driver, dropDownField);
		Select dropDown = new Select(dropDownField);
		String options;
		List<WebElement> listValues = dropDown.getOptions();
		sleep(2500);
		int index = 0;

		List<String> linkArray = translate(txt);
		if (!(linkArray.size() < 1)) {
			for (int i = 0; i < linkArray.size(); i++) {
				try {
					txt = linkArray.get(i);

					for (int x = 0; x < listValues.size(); x++) {
						options = listValues.get(x).getText();
						if (options != null && options.toLowerCase().contains(txt.toLowerCase())) {
							index = x;
							break;
						}
					}
					SelectDropDownValue(driver, dropDown, "index", String.valueOf(index));
					break;
				} catch (Exception e) {
				}
			}
		} else {
			for (int x = 0; x < listValues.size(); x++) {
				options = listValues.get(x).getText();
				if (options != null && options.toLowerCase().contains(txt.toLowerCase())) {
					index = x;
					break;
				}
			}
			SelectDropDownValue(driver, dropDown, "index", String.valueOf(index));
		}
	}

	public void refresh(WebDriver driver) throws Exception {
		driver.navigate().refresh();
		// changed by Vimal :06/sep/2018:
		if (isAlertPresent(driver)) {
			acceptAlertBox(driver);
		}
	}

	/**
	 * This method is used to go back window
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void back(WebDriver driver) throws Exception {
		driver.navigate().back();
		if (isAlertPresent(driver)) {
			acceptAlertBox(driver);
		}
	}

	private void click(WebDriver driver, WebElement element) throws Exception {
		try {
			if (element.getText() != null && !element.getText().isEmpty()) {
			}
			element.click();
			/**
			 * put current date time stamp
			 */
			FranconnectUtil.config.put("failedTimeStamp", getCurrentDateAndTime());
		} catch (Exception e) {
			// element.click();
			/*
			 * JavascriptExecutor executor = (JavascriptExecutor) driver;
			 * executor.executeScript("arguments[0].click();", element);
			 */
			clickElementByJS(driver, element);
		}
		// Thread.sleep(3500);
	}

	/**
	 * 
	 * Method for verify downloaded file in logs folder
	 * 
	 * @param downloadPath
	 * @param fileName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isFileFound(File downloadPath, String fileName) throws Exception {
		boolean isFileFound = false;
		label: for (int k = 0; k < 60; k++) {
			String[] array = downloadPath.list();
			if (array != null && array.length > 0 && isFileFound == false) {
				for (int i = 0; i < array.length; i++) {
					if (array[i].equalsIgnoreCase(fileName)) {

						String temp = downloadPath.getAbsolutePath() + File.separator + fileName;

						File tempFile = new File(temp);
						if (tempFile.length() > 0) {
							isFileFound = true;
						}
						break label;
					}
				}
			}
			if (!isFileFound) {
				sleep(3000);
				array = downloadPath.list();
			}
		}
		return isFileFound;

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

	/**
	 * 
	 * @param Action
	 * @param element
	 * @throws Exception
	 */

	private void printDetailedTestStep(String Action, WebElement element) throws Exception {
		Reporter.log("Detailed Test Steps# :" + Action + " : " + elementToString(element));
	}

	/**
	 * 
	 * @param Action
	 * @param element
	 * @throws Exception
	 */
	private void printDetailedTestStep(String Action, String element) throws Exception {
		Reporter.log("Detailed Test Steps# :" + Action + " : " + element);
	}

	/**
	 * 
	 * @param Action
	 * @param element
	 * @param value
	 * @throws Exception
	 */
	private void printDetailedTestStep(String Action, WebElement element, String value) throws Exception {
		Reporter.log("Detailed Test Steps# :" + Action + " : " + value + " : " + elementToString(element));
	}

	/**
	 * 
	 * @param Action
	 * @param element
	 * @param value
	 * @throws Exception
	 */
	private void printDetailedTestStep(String Action, WebElement element, WebElement element2) throws Exception {
		Reporter.log("Detailed Test Steps# :" + Action + " : " + elementToString(element) + " : "
				+ elementToString(element2));
	}

	/**
	 * 
	 * @param Action
	 * @param element
	 * @param value
	 * @throws Exception
	 */
	private void printDetailedTestStep(String Action, String element, String value) throws Exception {
		Reporter.log("Detailed Test Steps# :" + Action + " : " + value + " : " + element);
	}

	private void printDetailedTestStep(String Action) {
		Reporter.log("Detailed Test Steps# :" + Action);
	}

	private String elementToString(WebElement element) {

		String text = element.toString();

		String subString = "";
		String start = "[RemoteWebDriver:";
		String end = "] -> ";

		try {
			if (text != null && !text.isEmpty() && text.contains(start) && text.contains(end)) {
				subString = text.substring(text.indexOf(start), text.indexOf(end) + end.length());
				text = text.replace(subString, "");
			}
		} catch (Exception e) {

		}

		return text;
	}

	/*
	 * public Map<String, String> readTestDatawithsqllite(String moduleName, String
	 * testCaseId) throws Exception { Reporter.log(
	 * "Finding Test Data From DataBase...."); Map<String, Map<String, String>>
	 * tableMap = null;
	 * 
	 * String tableName = "";
	 * 
	 * if (moduleName.toLowerCase().contains("crm")) { tableName = "CRM_Login";
	 * tableMap = getTableDataFromDBwithsqllite(tableName, testCaseId); } return
	 * null; }
	 */

	public Map<String, String> readTestDatawithsqllite(String moduleName, String testCaseId, String area)
			throws Exception {
		Reporter.log("Finding Test Data From DataBase....");
		Map<String, String> tableMap = null;

		String tableName = "";

		if (moduleName.toLowerCase().contains("crm")) {
			tableName = "CRM";
			tableMap = getTableDataFromDBwithsqllite(tableName, testCaseId, area);
		} else if (moduleName.toLowerCase().contains("info")) {
			tableName = "infomgr";
			tableMap = getTableDataFromDBwithsqllite(tableName, testCaseId, area);
		}else if (moduleName.toLowerCase().contains("shop")) {
			tableName = "shop";
			tableMap = getTableDataFromDBwithsqllite(tableName, testCaseId, area);
		}

		return tableMap;
	}

	public Map<String, String> getTableDataFromDBwithsqllite(String tableName, String testCaseId, String area)
			throws Exception {
		Map<String, String> KeyVal = new HashMap<>();
		String sql = "SELECT * FROM " + tableName + " WHERE TC_ID IN ('" + testCaseId + "')" + " and Area IN ('" + area
				+ "')";
		String url = null;
		String current = null;

		if ("No".equalsIgnoreCase(FranconnectUtil.config.get("inserttoDB"))) {
			current = System.getProperty("user.dir");
		} else {
			current = FranconnectUtil.config.get("jwPath");
		}

		if (tableName.equalsIgnoreCase("CRM")) {
			url = "jdbc:sqlite:'" + current + "'\\Test_data\\Test_Data.db";
			url = url.replaceAll("\'", "");

		} else if (tableName.equalsIgnoreCase("infomgr")) {
			url = "jdbc:sqlite:'" + current + "'\\Test_data\\databaseqinfo.db";
			url = url.replaceAll("\'", "");
		}

		java.sql.Connection conn = DriverManager.getConnection(url);
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			// loop through the result set
			while (rs.next()) {
				// yo
				String Key = rs.getString("Key");
				String Keyvalue = rs.getString("Keyvalue");
				KeyVal.put(Key, Keyvalue);
			}

		} catch (SQLException e) {
			System.out.println("SQL Exceptione " + e.getMessage());
		}
		return KeyVal;
	}

	// Govind This method is use to click the Action Menu for Log a Task, Call etc
	public void singleclickActionMenu(WebDriver driver, String option) throws Exception {

		FranconnectUtil fc = new FranconnectUtil();
		fc.utobj().printTestStep("Click on Action Menu :" +option);

		try {

			fc.utobj().clickElement(driver, "//td/a[contains(text(),'Actions')]");
			List<WebElement> menu = driver
					.findElements(By.xpath(".//*[@id='actionListButtons']/table/tbody/tr[2]/td[2]/table/tbody//td"));
			for (WebElement ActionMenu : menu) {

				System.out.println(ActionMenu.getText().trim());
				if (ActionMenu.getText().trim().contains(option)) {
					ActionMenu.click();
					break;
				}
			}
		} catch (Exception e) {
			throwsException("Unable to click on :" +option);
		}
	}

	// Govind: This method is used for Data Provider

	public Object[][] getTableDataFromDBforDataProvider(String tableName) throws Exception {
		Map<String, Map<String, String>> testData = new HashMap<String, Map<String, String>>();

		tableName = tableName.trim().toUpperCase();

		try {

			String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
			java.sql.Connection conn = null;
			Statement stmt = null;
			String sql;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			stmt = conn.createStatement();

			sql = "SELECT * FROM " + tableName + " WHERE TC_EXECUTE IN ('YES')";
			ResultSet rs = stmt.executeQuery(sql);
			int size = rs.getFetchSize();

			int rowSize = 0;

			System.out.println(rs.getFetchSize());
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnSize = rsmd.getColumnCount();
			ArrayList<String[]> dataList = new ArrayList<String[]>();

			String[] colDataArray = new String[columnSize];
			while (rs.next()) {
				colDataArray = new String[columnSize];
				for (int j = 0; j < columnSize; j++) {
					colDataArray[j] = rs.getString(j + 1);
				}
				dataList.add(colDataArray);

				rowSize++; // typeID is the number of rows in the ResultSet
			}
			String[][] finalDataMatrix = new String[rowSize][columnSize];
			finalDataMatrix = dataList.toArray(finalDataMatrix);
			stmt.close();
			conn.close();
			return finalDataMatrix;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
			// throw new SkipException(e.getMessage());
		}
	}

	/***
	 * @author : Akshat
	 * @param tableName
	 * @param columnNameToBeUpdated
	 * @param columnValueToBeUpdated
	 * @param whereColumn1
	 * @param whereValue1
	 */
	public void updateDatabase(String tableName, String columnNameToBeUpdated, String columnValueToBeUpdated,
			String whereColumn1, String whereValue1) {
		try {
			String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
			java.sql.Connection conn = null;
			Statement stmt = null;
			String sql;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			stmt = conn.createStatement();

			sql = "UPDATE " + tableName + " SET " + columnNameToBeUpdated + "=" + "'" + columnValueToBeUpdated + "'"
					+ " WHERE " + whereColumn1 + "=" + "'" + whereValue1 + "'";
			stmt.executeUpdate(sql);
			System.out.println("Table Updated Success");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	// Govind: This method will click on multi select drop-down, Type & Enter, and
	// select value.

	public void selectValueFromMultiSelectwithSearchAndSelect(WebDriver driver, WebElement element, String value)
			throws Exception {

		printDetailedTestStep("Select (Multi Select)", element, value);

		try {
			sleep(500);
			clickElement(driver, element);
			sleep(500);

			WebElement searchTextBox = element.findElement(By.xpath("./div/div/input"));
			List<String> linkArray = translate(value);
			if (linkArray.size() > 0) {
				for (int i = 0; i < linkArray.size(); i++) {
					try {
						value = linkArray.get(i);
						sendKeys(driver, searchTextBox, value);
						sleep(500);
						// change as per functionality click on search icon
						WebElement searchBtn = searchTextBox
								.findElement(By.xpath("./following-sibling::input[@type='button']"));

						clickElement(driver, searchBtn);
						WebElement element3 = element
								.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
						try {
							if (!element3.isSelected()) {
								clickElement(driver, element3);
								sleep();
							}

						} catch (Exception e) {
							Reporter.log(e.getMessage());
							throwsException("Search Value not present in Multi Select Box");
						}

						clickElementByJS(driver, element);
						break;
					} catch (Exception e) {
					}
				}
			} else {
				sendKeys(driver, searchTextBox, value);
				sleep(500);

				try {
					WebElement element3 = element
							.findElement(By.xpath(".//label[contains(text(),'" + value + "')]/input"));
					if (!element3.isSelected()) {
						clickElement(driver, element3);
					}

				} catch (Exception e) {
					Reporter.log(e.getMessage());
					throwsException("Search Value not present in Multi Select Box");
				}

				clickElement(driver, element);

			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			throwsException("Problem in Multi Select Box! " + e.getMessage());
		}
	}
	
	/* Traverse WebElements and click on required element by text */
	public WebElement traverseListElement(WebDriver driver, List<WebElement> list, String elemToReturned) throws Exception {
		WebElement element = null;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement);
			if (webElement.getText().trim().contains(elemToReturned)) {
				element = webElement;
			}
		}
		return element;
	}
	
	public boolean verifyPresent(WebDriver driver, List<WebElement> list, String elemToReturned) {
		boolean flag = false;
			WebElement element = null;
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				System.out.println(webElement);
				if (webElement.getText().trim().contains(elemToReturned)) {
					element = webElement;
					flag = true;
				}
			}
			return flag;
	}
	
	public Map<String, String> getTableData(String tableName,String testCaseId) throws Exception {
		Map<String, String> testData = new HashMap<String, String>();

		tableName = tableName.trim().toUpperCase();
		try {
			String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
			java.sql.Connection conn = null;
			Statement stmt = null;
			String sql;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			stmt = conn.createStatement();

			sql = "SELECT * FROM " + tableName + " WHERE TC_ID IN ('" + testCaseId + "')";
			ResultSet rs = stmt.executeQuery(sql);
			int size = rs.getFetchSize();

			int rowSize = 0;

			System.out.println(rs.getFetchSize());
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i <= columnCount; i++ ) {
					
					  String name = rsmd.getColumnName(i);
					  testData.put(name, rs.getString(i));
					  
					}
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			// throw new SkipException(e.getMessage());
		}

		return testData;

	}
	
/* Anubhav Start*/
	
	public void highlightObject(WebDriver driver, WebElement Element) throws Exception {

		try {
			if (driver != null) {
				JavascriptExecutor javascript = (JavascriptExecutor) driver;
				javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", Element,
						"border: 3px solid yellow;");
			}
		} catch (Exception e) {
			throwsException("Unable to highlight");
		}
	}
	
	public boolean isElementPresentHighLighted(WebDriver driver, WebElement element) {
		try {
			if(!isWebElementVisible(driver, element)) {
				moveToElement(driver, element);
			}
			highlightObject(driver, element);
			element.isEnabled();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean isWebElementVisible(WebDriver driver, WebElement element) {
	    Dimension weD = element.getSize();
	    Point weP = element.getLocation();
	    Dimension d = driver.manage().window().getSize();

	    int x = d.getWidth();
	    int y = d.getHeight();
	    int x2 = weD.getWidth() + weP.getX();
	    int y2 = weD.getHeight() + weP.getY();

	    return (x2 <= x && y2 <= y);
	  }
	
	/* Anubhav End*/
	
	// Anubhav : This method will return all mails with the given subject that are unread and received on current date.
		public Map<String, String> readMailBoxForUnreadMailsWithSubjectAndReceivedToday(String expectedSubject, String expectedMessageBody, String userName,
				String password) throws Exception {

			Map<String, String> mailInfo = new HashMap<String, String>();
			boolean noConnection = false;

			try {
				String hostName = "mail2.staffex.com";
				String provider = "imap";

				Properties props = new Properties();

				// Create Session
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore(provider);

				try {
					store.connect(hostName, userName, password);
					noConnection = true;
				} catch (Exception e) {
					Reporter.log(e.getMessage().toString());
					noConnection = false;
				}
				// Open Folder

				Folder inbox = store.getFolder("INBOX");
				inbox.open(Folder.READ_ONLY);

				Date date = new Date();
				date = new Date(date.getYear(), date.getMonth(), date.getDate(), 0, 0, 0);
				SearchTerm term = new AndTerm(new SubjectTerm(expectedSubject), new FlagTerm(new Flags(Flags.Flag.SEEN),false));
				SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, date);
				term = new AndTerm(term, newerThan);
				
				Message[] messages = inbox.search(term);

				List<Message> m = new ArrayList<Message>();
				for (int x = 0; x < messages.length; x++) {
					m.add(messages[x]);
				}

				Collections.reverse(m);
				for (int x = 0; x < m.size(); x++) {
						String mailBody = null;
							mailBody = getTextFromMessage(m.get(x));
							if (mailBody.contains(expectedMessageBody)) {
								mailInfo.put("from", getFrom(m.get(x)));
								mailInfo.put("to", getTo(m.get(x)));
								mailInfo.put("subject", expectedSubject);
								mailInfo.put("mailBody", mailBody);
								mailInfo.put("receivedDate", getReceivedDate(m.get(x)));
								return mailInfo;
							}
				}
				inbox.close(false);
				store.close();
			} catch (Exception e) {
				Reporter.log(e.getMessage().toString());
				throwsException("Unable to Read Email in the Mail Box. Error -"+ e);
			}

			if (!noConnection) {
				throwsException("Please check mail id / password is not correct");
			}
			
			return mailInfo;
		}

}


