package generic_utilities;
import java.awt.Window;
import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

/**
 * 
 * @author MADHUSUDAN
 *
 *
 *
 *implcit wait 
 */

public class WebdriverUtilities 
{
	/**
	 * 
	 * @param driver
	 */
public void WaitForPageToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/**
 * it will wait for js elements
 */
public void waitforPageToLoadForJSElemets(WebDriver driver)
{
	driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
}
/**
 * it will check for the element in the GUI for polling time of 500ms
 * 
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * it will check for the element in the GUI for polling time of 500ms
 */
public void waitForTitleContains(WebDriver driver,String title)
{
  WebDriverWait wait =new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.titleContains(title));
	
}
/**
 * here we can change the polling time from default 500ms to any polling time
*/
public void waitForElementToCustom(WebDriver driver,int pollingTime,WebElement element)
{
	FluentWait wait=new FluentWait(driver);
	wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
	wait.ignoring(Exception.class);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * here we are giving custom timeout
 * @throws InterruptedException 
 */
public void waitAndClick(WebElement element) throws InterruptedException
{
	int count=0;
	while(count<10)
	{
		try {
			element.click();
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			count++;
		}
	}
}
	
	/**
	 * used to swith from one window to another window
	 *partialwindow(childwindow)
	 */
	
	public void switchToWindow(WebDriver driver,String partialwindow)
	{
		Set<String> set = driver.getWindowHandles();
	
		
	for (String ids : set) 
	{
	 driver.switchTo().window(ids);
	 String url = driver.getCurrentUrl();
	 if(url.contains(partialwindow))
	 {
		 break;
	 }
	 
	}
		/*Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currectwindow = driver.getTitle();
			if(currectwindow.contains(partialwindow));
			{
				break;
			}
	}*/
	}
	
	/**
	 *switch from one frame to another frame by using index
	 */
	 public void switchToFrame(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);

     }
	 
	 /**
	  * switch from one frame to another frame by using id
	  */
	 
	 public void switchToFrame(WebDriver driver,String id)
	 {
		 driver.switchTo().frame(id);
	 }
	 
	 /**
	  * switch from one frame to aother fram by using absolute xpath
	  */
	 public void switchToFrame(WebDriver driver,WebElement Elementaddress)
	 {
		 driver.switchTo().frame(Elementaddress);
	 }
	 
	 /**
	  * switch back to frame to parentframe
	  */
	 
	 public void switchBackToParentFrame(WebDriver driver)
	 {
		 driver.switchTo().parentFrame();
	 }
	 
	 
	 /**
	  * switch frame to main page
	  */
	 
	 public void switchBackToMainPage(WebDriver driver)
	 {
		 driver.switchTo().defaultContent();
	 }
	 
	 
	 /**
	  *it is used to alert pop up and accept 
	  */
	 
	 public void swithToAlertAndAccept(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
	 }
	 
	 /**
	  * it is used to alert pop up and dismiss
	  */
	 
	 public void switchToAlertAndDismiss(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 
	 /**
	  * it is used to switch to select dropdown by using index
	  */
	 
	 public void selectDropDown(WebElement element,int index)
	 {
		 Select select=new Select(element);
		 select.selectByIndex(index);
	 }
	 /**
	  * it is used to switch to select dropdown by using value
	  */
	 public void selectDropDown(WebElement element,String value)
	 {
		 Select select=new Select(element);
		 select.selectByValue(value);
	 }
	 
	 /**
	  * it is used to switch to select dropdown by using visibletext
	  */
	 
	 public void selectDropDownbyvisibltext(WebElement element,String visibletext)
	 {
		 Select select=new Select(element);
		 select.selectByVisibleText(visibletext);
	 }
	 
	 /**
	  * it is used for mouse over actions
	  */
	 
	 public void mouseOverActions(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	 
	 /**
	  * it is used for right clic actions on element
	  * 
	  */
	 
	 public void rightClickActionOnElement(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 
	 /**
	  * it is used for double click on an element
	  */
public void doubleClickOnAnElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element);
}

/**
 * it is used to click on enter button using keyboard actions
 */

public void clickOnEnterButton(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}

/**
 * it is used to take screenshoot
 * @throws IOException 
 */

public void takeScreenShoot( WebDriver driver,String screenshotname) throws IOException
{
	TakesScreenshot takescreenshot=(TakesScreenshot)driver;
java.io.File SRC= takescreenshot.getScreenshotAs(OutputType.FILE);
java.io.File DST = new java.io.File(IpathConstants.SCREENSHOTPATH+screenshotname+".PNG");
com.google.common.io.Files.copy(SRC, DST);
}

/**
 * IT IS USED TO PERFORM SCROLLBAR ACTIONS
 */
public void scrollBarAction(WebDriver driver)
{
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollBy(0,500)");
}
}
	


