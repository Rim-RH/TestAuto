package com.example.PracticeAutomation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import com.practiceautomation.po.ClickEventPage;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class ClickEvents {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	
	ClickEventPage ClickEventPage;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		ClickEventPage = new ClickEventPage(driver);
		baseUrl = "https://practice-automation.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}

//	@Test
//	public void testClickEvent() throws Exception {
//		driver.get("https://practice-automation.com/Click Events/");
//		WebElement Titlepage = driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
//		try {
//			assertEquals("Click Events",
//					driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).getText());
//			driver.findElement(By.xpath("//button[@onclick='catSound()']")).click();
//			driver.findElement(By.id("demo")).click();
//			assertEquals("Meow!", driver.findElement(By.id("demo")).getText());
//			driver.findElement(By.xpath("//button[@onclick='dogSound()']")).click();
//			driver.findElement(By.id("demo")).click();
//			assertEquals("Woof!", driver.findElement(By.id("demo")).getText());
//			driver.findElement(By.xpath("//button[@onclick='pigSound()']")).click();
//			driver.findElement(By.id("main")).click();
//			assertEquals("Oink!", driver.findElement(By.id("demo")).getText());
//			driver.findElement(By.xpath("//button[@onclick='cowSound()']")).click();
//			driver.findElement(By.id("demo")).click();
//			assertEquals("Moo!", driver.findElement(By.id("demo")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//	}

	@Test
	public void testClickEvent2() throws Exception {
		driver.get("https://practice-automation.com/Click Events/");
		try {
		ClickEventPage.getCat().click();
		assertEquals("Meow!", ClickEventPage.getTextDemo().getText());

		ClickEventPage.getDog().click();
		assertEquals("Woof!", ClickEventPage.getTextDemo().getText());

		ClickEventPage.getPig().click();
		assertEquals("Oink!", ClickEventPage.getTextDemo().getText());

		ClickEventPage.getCow().click();
		assertEquals("Moo!", ClickEventPage.getTextDemo().getText());

	ClickEventPage.takeScreenShot("clickevents.jpg");
		
		ClickEventPage.takeScreenShot("getClickEventsHeadLine.jpg",ClickEventPage.getCat());
		
		ClickEventPage.takeScreenShot("clickeventscatbutton.jpg","screenshots",ClickEventPage.getCat());
		
	} catch (Error e) {
		verificationErrors.append(e.toString());
		
	}
			

		
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}