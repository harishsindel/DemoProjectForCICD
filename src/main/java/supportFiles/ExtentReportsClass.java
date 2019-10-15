package supportFiles;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void startTest()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/SampleExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Sample Extent Report");
		extent.addSystemInfo("Environment", "Automation Testing");
		extent.addSystemInfo("User Name", "harish Sindel");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		System.out.println("Before Test");
	}
	
	@Test
	public void skipTest()
	{
		test = extent.startTest("passTest");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Test Case (skipTest) is passed");
		test.log(LogStatus.PASS, test.addScreenCapture("C:\\Users\\harishsi\\Desktop\\cats.jpg")+"Test Passed");
		
		System.out.println("Test");
	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			
		}
		extent.endTest(test);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
}
