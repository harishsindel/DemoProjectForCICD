package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import supportFiles.logWriter;

public class Sample {
		@Test
		public void testDemo() {
		try {
			logWriter.writeLog("INFO", "class: GetAllCountries", "Pre-Condition setting done.");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("https://www.spicejet.com/");
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@text='Belagavi (IXG)']")).click();
			driver.findElement(By.xpath("//a[@text='Jaipur (JAI)']")).click();
			driver.findElement(By.className("book")).click();
			driver.findElement(By.className("ui-datepicker-trigger")).click();
			System.out.println("******************* "+driver.getClass()+" *******************");
			System.out.println("******************* "+driver.getCurrentUrl()+" *******************");
			driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
			Select select1 = new Select(driver.findElement(By.name("States")));
			select1.selectByVisibleText("Ohio");
			select1.selectByValue("California");
			select1.selectByIndex(2);
			select1.deselectAll();
//			driver.close();
			driver.quit();
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
