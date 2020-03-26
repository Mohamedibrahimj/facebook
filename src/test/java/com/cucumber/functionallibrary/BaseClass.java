package com.cucumber.functionallibrary;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
				
			public static WebDriver driver;
			   
			   public static WebDriver browserlaunch(String browser, String url) throws Exception {
				   if(browser.equalsIgnoreCase("chrome")) {
					   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
					   driver = new ChromeDriver();
				   }
				   else if (browser.equalsIgnoreCase("firFox")) {
					   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
					   driver = new FirefoxDriver();
				  }else {
					throw new Exception("Not a valid browser");
				  }
					driver.get(url);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					return driver;	
				  }
			   
			   //isdisplayed
			   public static boolean elementIsDisplayed(WebElement element) {
				   boolean displayed = element.isDisplayed();
				   return displayed;
			   }
			  //isenabled
			   public static boolean elementIsEnabled(WebElement element) {
				   boolean enabled = element.isEnabled();
				   return enabled;
			   }
			   //is selected
			   public static boolean elementIsSelected(WebElement element) {
				   boolean selected = element.isSelected();
				   return selected;
			   }
			   //get text
			   public static String getText(WebElement element) {
				   String text = element.getText();
				   return text;
			   }
		       //get attribute
			   public static String getAttibute(WebElement element) {
				   String attribute = element.getAttribute(null);
				   return attribute;
			   }
			   //get title
			   public static String getTitle() {
				   String title = driver.getTitle();
				   return title;
			   }
			   //get current URL
			   public static String getCurrentUrl() {
				   String currentUrl = driver.getCurrentUrl();
				   return currentUrl;
			   }
			   //clear the content
			   public static void clearBox(WebElement element) {
				   element.clear();
			   }
			   //sendkeys
			   public static void sendKeys(WebElement element, String value) {
				   element.sendKeys(value);
			   }
			   //click
			   public static void clickFtn(WebElement element) {
				   element.click();
			   }
			   //DropDown
			   public static void dropDown(WebElement element, String by , String value) throws Exception {
				   Select select = new Select(element);
				   if (by.equalsIgnoreCase("Byvalue")) {
					   select.selectByValue(value);
				}else if (by.equalsIgnoreCase("Bytext")) {
					select.selectByVisibleText(value);		
				}else if (by.equalsIgnoreCase("Byint")) {
					select.selectByIndex(Integer.parseInt(value));
				}else {
					throw new Exception("DropDown not working");
				}		   
			   }
			   //double click
			   public static void doubleClickElement(WebElement element) {
				   Actions action = new Actions(driver);
				   action.doubleClick(element).build().perform();	
			   }
			   //mouse hover
			   public static void mouseHoverElement(WebElement element){
				   Actions actions = new Actions(driver);
				   actions.moveToElement(element).build().perform();
			   }
			   //click by mouse
			   public static void clickOnElementByMouse(WebElement element) {
				   Actions actions = new Actions(driver);
				   actions.moveToElement(element).click().build().perform();
			   }
			   //Scroll top and bottom
			   public static void scrollToTopOrBottom(String option) throws Exception {

					if (option.equalsIgnoreCase("Top")) {
						((JavascriptExecutor) driver).executeScript("scroll(0,document.body.scrollHeight)");
					} else if (option.equalsIgnoreCase("bottom")) {
						((JavascriptExecutor) driver).executeScript("scroll(0,-document.body.scrollHeight)");
					} else {
						throw new Exception("invalid Scroll Option");
					}
				}
			   //Alert handling
			   public static void simpleAlerts(String options) throws Exception {

					if (options.equalsIgnoreCase("accept")) {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						driver.switchTo().defaultContent();
					} else {
						throw new Exception("INVALID ALERT OPERATION");
					}
				}

				public static void confirmAlerts(String option) {

					if (option.contains("accept")) {
						Alert alert = driver.switchTo().alert();
						alert.accept();
					} else {
						Alert alert = driver.switchTo().alert();
						alert.dismiss();
					}
				}

				public static void promptAlerts(String option, String value) {
					if (option.contains("accept")) {
						Alert alert = driver.switchTo().alert();
						alert.sendKeys(value);
						alert.accept();
						driver.switchTo().defaultContent();
					} else {
						Alert alert = driver.switchTo().alert();
						alert.sendKeys(value);
						alert.dismiss();
						driver.switchTo().defaultContent();
					}
				}
				//take screenshot
				public static void takeScreenShot(String fileName) throws IOException {
					TakesScreenshot ts = (TakesScreenshot) driver;
					File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
					File des = new File(System.getProperty("user.dir") + "\\Screenshot\\" + fileName + ".png");
					FileUtils.copyFile(screenshotAs, des);
				}
				//navigations
				public static void navigationOption(String option) throws Exception {
					if (option.equalsIgnoreCase("forward")) {
						driver.navigate().forward();
					} else if (option.equalsIgnoreCase("back")) {
						driver.navigate().back();
					} else if (option.equalsIgnoreCase("refresh")) {
						driver.navigate().refresh();
					} else if (option.contains("http")) {
						driver.navigate().to(option);
					} else {
						throw new Exception("Invalid Navigate option");
					}
				}
		}











