package generic_utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

public class Itestlisners implements ITestListener
{

	ExtentReports extents;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) 
	{

		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		
//		String testname = result.getMethod().getMethodName();
//		System.out.println(testname+"==============executing============");
//		test.log(Status.FAIL,result.getMethod().getMethodName());
//		test.log(Status.FAIL, result.getThrowable());
//		EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
//		File src=edriver.getScreenshotAs(OutputType.FILE);
//		try
//		{
//			FileUtils.copyFile(src, new File("./screenShot/"+testname+".PNG"));
//		} catch (Exception e) 
//		{
//	    try 
//	    {
//	    	String screenShotName=WebdriverUtilities.takeScreenShoot(Baseclass.sdriver, result.getMethod().getMethodName());
//	    	test.addScreenCaptureFromPath(screenShotName);
//	    }
//	    catch (Throwable e1)
//	    {
//	    	e.printStackTrace();
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String testname = result.getMethod().getMethodName();
//		Reporter.log("=======Executing======",true);
//		EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		try
//		{
//			FileUtils.copyFile(src, new File("./Screenshots/"+testname+".png"));
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
//
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
