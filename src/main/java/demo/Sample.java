package demo;

import java.io.File;
import java.io.IOException;
import java.rmi.activation.ActivationException;
import java.security.acl.AclNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class Sample {
		@Test
		public void testDemo() {
		try {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	//		driver.get("https://www.orangehrm.com");
	//		System.out.println(driver.getTitle());
	//		driver.findElement(By.xpath("//a[@title='Free 30 Day Trial']")).click();
	//		Select select = new Select(driver.findElement(By.name("Country")));
	//		select.selectByValue("India");
	//		System.out.println(driver.findElement(By.name("Country")).getAttribute("value"));
	//		select.selectByIndex(2);
	//		System.out.println(driver.findElement(By.name("Country")).getAttribute("value"));
	//		select.selectByVisibleText("Laos");
	//		System.out.println(driver.findElement(By.name("Country")).getAttribute("value"));
			driver.navigate().to("https://www.spicejet.com/");
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@text='Belagavi (IXG)']")).click();
			driver.findElement(By.xpath("//a[@text='Jaipur (JAI)']")).click();
			driver.findElement(By.className("book")).click();
			driver.findElement(By.className("ui-datepicker-trigger")).click();
	//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\Screenshots\\image.jpeg"));
	//		driver.get("https://www.makemytrip.com/");
	//		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mum");
	//		driver.findElement(By.xpath("//p[contains(text(), 'Mumbai, India')]")).click();
	//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
	//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
	//		Actions actions = new Actions(driver);
	//		WebDriverWait wait = new WebDriverWait(driver, 10);
	//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Mumbai, India')]")));
	//		Action action = actions.moveToElement(driver.findElement(By.xpath("//p[contains(text(), 'Mumbai, India')]"))).click().build();
	//		action.perform();
			System.out.println(driver.getClass());
			System.out.println(driver.getCurrentUrl());
	//		System.out.println(driver.getPageSource());
			driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
			Select select1 = new Select(driver.findElement(By.name("States")));
			select1.selectByVisibleText("Ohio");
			select1.selectByValue("California");
			select1.selectByIndex(2);
	//		select1.deselectByValue("California");
	//		select1.deselectByIndex(2);
			select1.deselectAll();
			driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
