package Util;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

public class MyWait {

// This is mywait class from gaurav and this is unused 

	private void checkPageIsLoaded(WebDriver driver) throws Exception {
	try {			
		driver.getCurrentUrl();
	} catch (Exception E) {
		throw new Exception(E.getMessage());	
		}	
	}

	WebDriver switchFrame(WebDriver driver, WebElement frame) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		Thread.sleep(2000);
		return driver;
	}

	WebDriver switchFrame(WebDriver driver, String frame) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		// Thread.sleep(5000);
		return driver;
	}

	WebDriver switchFrameByClass(WebDriver driver, String className) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(className)));
		// Thread.sleep(5000);
		return driver;
	}

	WebDriver switchFrameById(WebDriver driver, String frameId) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		// Thread.sleep(5000);
		return driver;
	}

	WebElement getElement(WebDriver driver, String locatorType, String value) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		try {
			if (locatorType.equalsIgnoreCase("id")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.id(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("name")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("className")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.className(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("linkText")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.linkText(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.partialLinkText(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("cssSelector") || locatorType.equalsIgnoreCase("css")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.cssSelector(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("tagName")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.tagName(value));
					}
				});
				return foo;
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath(value));
					}
				});
				return foo;
			} else {
				throw new Exception("Element not defined properly : " + locatorType + " : " + value);
			}
		} catch (Exception e) {
			throw new Exception("Element not found : " + locatorType + " : " + value + "\n" + e.getMessage());
		} finally {

		}
	}

	WebElement getElementOnClickable(WebDriver driver, String locatorType, String value) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		try {

			if (locatorType.equalsIgnoreCase("id")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			} else if (locatorType.equalsIgnoreCase("name")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
			} else if (locatorType.equalsIgnoreCase("className")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
			} else if (locatorType.equalsIgnoreCase("linkText")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
			} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(value)));
			} else if (locatorType.equalsIgnoreCase("cssSelector")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
			} else if (locatorType.equalsIgnoreCase("tagName")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.tagName(value)));
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
			} else {
				throw new Exception("Element not defined properly : " + locatorType + " : " + value);
			}
		} catch (Exception e) {
			throw new Exception("Element not found : " + locatorType + " : " + value + "\n" + e.getMessage());
		} finally {

		}
	}

	WebElement getElementOnClickable(WebDriver driver, WebElement element) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20, 100);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	Alert getAlert(WebDriver driver) throws Exception {

		// checkPageIsLoaded(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20, 50);

		try {
			Alert foo = wait.until(new Function<WebDriver, Alert>() {
				@Override
				public Alert apply(WebDriver driver) {
					return driver.switchTo().alert();
				}
			});
			return foo;
		} catch (Exception e) {
			throw new Exception("Test case Expected and alert message to appear, which is not found");
		} finally {
		}
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) throws Exception {
		checkPageIsLoaded(driver);
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 20, 50)
				.ignoring(StaleElementReferenceException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				element.getText();
				return element != null && (element.isDisplayed() || element.isEnabled());
			}
		});
	}

}
