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

import com.practiceautomation.po.BrokenLinksPage;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration; 

public class BrokenLinks {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;

	BrokenLinksPage BrokenLinks;

	@Before

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		baseUrl = "https://practice-automation.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;

		BrokenLinks = new BrokenLinksPage(driver);
	}

	@Test

	public void testBrokenLinks() throws Exception {
		driver.get("https://practice-automation.com/broken-links/");

		try {

			// Broken Links : Titre de la page (Action)

			// Point de Verification: Résultat attendu
			assertEquals("Broken Links", BrokenLinks.getBrokenLink().getText());

			assertEquals("Home", BrokenLinks.getHomeText().getText());

			assertEquals("In an ideal scenario a website should have no broken links. Therefore, it’s important to ensure that all links are working properly. One way to do that is to verify that the HTTP response code is 200 when the link is clicked.",
					BrokenLinks.getIdealScenarioText().getText());

			assertEquals("404", BrokenLinks.getQuatreQuatrePageText().getText());

			assertEquals("missing-page.html", BrokenLinks.getMissingPageText().getText());

			assertEquals("Name", BrokenLinks.getNameText().getText());
 
			assertEquals(2,BrokenLinks.getCode200List().size());
			
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

//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
}
