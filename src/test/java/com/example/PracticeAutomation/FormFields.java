package com.example.PracticeAutomation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class FormFields {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	FormFieldsPage formFieldsPage;

	@Before

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		baseUrl = "https://practice-automation.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		formFieldsPage = new FormFieldsPage(driver);
		js = (JavascriptExecutor) driver;
	}

	/*@Test

	public void testFormFields() throws Exception {

		driver.get("https://practice-automation.com/form-fields/");

		try {
			// verifie page Title

			WebElement pageTitle = driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));

			assertEquals("Form Fields", pageTitle.getText());

			// Le champ Name

			WebElement nameInput = driver.findElement(id("name-input"));
			nameInput.click();
			nameInput.sendKeys("rim");

			// Verifier required field message

			WebElement requiredMsg = driver.findElement(By.xpath("//form[@id='feedbackForm']/p"));
			assertTrue(requiredMsg.getText().contains("Required"));

			// tester champ passeword

			WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
			passwordInput.click();
			passwordInput.sendKeys("123456789");

			// Define WebDriverWait For scrolling

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Select dropdown options (yes, no , undecided)

			WebElement dropdown = driver.findElement(By.id("automation"));

			// selection yes
			Select automationDropdown = new Select(dropdown);
			automationDropdown.selectByVisibleText("Yes");
			assertEquals("Yes", automationDropdown.getFirstSelectedOption().getText());

			// Click dropdown une autre fois pour s'assurer qu'il refresh
			dropdown.click();
			Thread.sleep(500);

			// selection No

			automationDropdown.selectByVisibleText("No");
			assertEquals("No", automationDropdown.getFirstSelectedOption().getText());

			dropdown.click();
			Thread.sleep(500);

			// selection Undecided

			automationDropdown.selectByVisibleText("Undecided");
			assertEquals("Undecided", automationDropdown.getFirstSelectedOption().getText());

			// verifier la liste Automation tools

			WebElement selenium = driver.findElement(By.xpath("//li[normalize-space()='Selenium']"));

			js.executeScript("arguments[0].scrollIntoView(true);", selenium);
			assertEquals("Selenium", selenium.getText());

			WebElement playwright = driver.findElement(By.xpath("//li[normalize-space()='Playwright']"));
			js.executeScript("arguments[0].scrollIntoView(true);", playwright);
			assertEquals("playwright", playwright.getText());

			WebElement cypress = driver.findElement(By.xpath("//li[normalize-space()='Cypress']"));
			js.executeScript("arguments[0].scrollIntoView(true);", cypress);
			assertEquals("cypress", cypress.getText());

			WebElement appium = driver.findElement(By.xpath("//li[normalize-space()='Appium']"));
			js.executeScript("arguments[0].scrollIntoView(true);", appium);
			assertEquals("appium", appium.getText());

			WebElement katalon = driver.findElement(By.xpath("//li[normalize-space()='Katalon Studio']"));
			js.executeScript("arguments[0].scrollIntoView(true);", katalon);
			assertEquals("Katalon Studio", katalon.getText());
			Thread.sleep(500);

			// Remplir email et message

			WebElement emailField = driver.findElement(id("email"));
			emailField.click();
			emailField.clear();
			emailField.sendKeys("rim.riahi2018@gmail.com");

			WebElement messageField = driver.findElement(By.id("message"));
			messageField.click();
			messageField.clear();
			// messageField.sendKeys

			// Sumbit
			driver.findElement(By.id("submit-btn")).click();
			assertEquals("Message received!", closeAlertAndGetItsText());

		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	private By id(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Test
	public void testFormFields2() throws Exception {


		driver.get("https://practice-automation.com/form-fields/");

		// verifier Tittle

		assertEquals("Form Fields", formFieldsPage.getTitle().getText());

		// Le champ Name

		formFieldsPage.getNameInput().sendKeys("rim");

		// Password
		formFieldsPage.getPasswordInput().sendKeys("123456789");

		// Required message

		assertEquals("* Required", formFieldsPage.getRequiredText().getText());

		// champ Password

		WebElement passwordInput = formFieldsPage.getPasswordInput();
		passwordInput.click();
		passwordInput.sendKeys("123456789");

        // check drinks
		//formFieldsPage.clickAllFavoritDrink();

		// the drink you want to taste

		formFieldsPage.perform(formFieldsPage.getWaterCheckBox());

		// check colors
		formFieldsPage.perform(formFieldsPage.getColor1());

		// verify dropDown
		formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("Yes");
		formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("No");
		formFieldsPage.getSelect(formFieldsPage.getDropDown()).selectByVisibleText("Undecided");

		// verifier Automation Tools

		assertEquals("Selenium", formFieldsPage.getSeleniumText().getText());
		assertEquals("Playwright", formFieldsPage.getPlayWrightText().getText());
		assertEquals("Cypress", formFieldsPage.getCypressText().getText());
		assertEquals("Appium", formFieldsPage.getAppiumText().getText());
		assertEquals("Katalon Studio", formFieldsPage.getKatalonText().getText());

		// verifier email

		formFieldsPage.getEmailField().sendKeys("rim.riahi2018@gmail.com");

		// verifier message

		formFieldsPage.getMessageField().sendKeys("hello");
		// Submit form

		formFieldsPage.perform(formFieldsPage.getSumbitButton());
		assertEquals("Message received!", closeAlertAndGetItsText());
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
