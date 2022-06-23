package generic_utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectrepository.Homepage;
import com.crm.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass 
{
public	static WebDriver sdriver;
public WebDriver driver;
public Databaseutility dbLIB=new Databaseutility();
public ExcelUtilities excelLIB=new ExcelUtilities();
public FileUtilities filLIB=new FileUtilities();
public WebdriverUtilities webLIB=new WebdriverUtilities();
public JavaUtility javaLIB=new JavaUtility();

/**
 * connecting to database
 */
@BeforeSuite(groups = {"smoke","regression"})
public void dbconnection()
{
	dbLIB.databaseopen();
}
/**
 * 
 * opening the browsers
 */
//@Parameters("BROWSER")
@BeforeClass(groups = {"smoke","regression"})
public void launchthebrowser() throws IOException
{
	String BROWSER = filLIB.getPropertyKeyValue("browser");
	String URL = filLIB.getPropertyKeyValue("url");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	sdriver=driver;
	//IMPLICIT WAIT
	webLIB.WaitForPageToLoad(driver);
	
	//ENTER THE URL
	sdriver.get(URL);
	
	//maximize the screen
	driver.manage().window().maximize();
	
}

/**
 * login to application
 * @throws IOException 
 */
@BeforeMethod(groups = {"smoke","regression"})
public void loginToApplication() throws IOException
{
	String USERNAME = filLIB.getPropertyKeyValue("username");
	String PASSWORD = filLIB.getPropertyKeyValue("password");
	
	LoginPage LOGINPG = new LoginPage(driver);
	LOGINPG.Logintoapplication(USERNAME, PASSWORD);
}
/**
 * logout from application
 */
@AfterMethod
public void logoutfromapplication()
{
	
	Homepage homepg = new Homepage(driver);
	homepg.signoutfromapplication(driver);
	
}

/**
 * Close the browser
 */
@AfterClass
public void closebrowser()
{
	driver.quit();
}
@AfterSuite
public void closedbconfig()
{
	dbLIB.databaseclose();
}
 
}
