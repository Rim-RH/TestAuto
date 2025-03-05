package com.exemple.practiceautomation.bdd;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.practiceautomation.po.ClickEventPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	ClickEventPage clickEventPage;

	
	@Given("I am in page click events")
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		clickEventPage = new ClickEventPage(driver);
		baseUrl = "https://practice-automation.com/";
		driver.get("https://practice-automation.com/Click Events/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}
		



@When("I click for the animal")
public void i_click_for_the_animal() {
	 clickEventPage.getCat().click();
}

@Then("I verify the sound displayed")
public void i_verify_the_sound_displayed() {
	assertEquals("Meow!",clickEventPage.getTextDemo().getText());
}

@When("I click for the animal dog")
public void i_click_for_the_animal_dog() {
	clickEventPage.getDog().click();
}

@Then("I verify the sound displayed of dog")
public void i_verify_the_sound_displayed_of_dog() {
	assertEquals("Woof!",clickEventPage.getTextDemo().getText());
}

@When("I click for the animal pig")
public void i_click_for_the_animal_pig() {
	clickEventPage.getPig().click();
}

@Then("I verify the sound displayed of pig")
public void i_verify_the_sound_displayed_of_pig() {
	assertEquals("Oink!",clickEventPage.getTextDemo().getText());
}

@When("I click for the animal cow")
public void i_click_for_the_animal_cow() {
	clickEventPage.getCow().click();
}

@Then("I verify the sound displayed of cow")
public void i_verify_the_sound_displayed_of_cow() {
	assertEquals("Moo!",clickEventPage.getTextDemo().getText());
}

// with TDD

@When("I click for the {string}")
public void i_click_for_the(String animal) {
	driver.findElement(By.xpath("//button[@onclick='"+animal+"Sound()']")).click();	
}

@Then("I verify the {string} displayed")
public void i_verify_the_displayed(String sound) {
	assertEquals(sound,clickEventPage.getTextDemo().getText());
	
    
}
	
// without DDT
@When("I click for the cat")
public void i_click_for_the_cat() {
	clickEventPage.getCat().click();
}

@Then("I verify the Meow! displayed")
public void i_verify_the_meow_displayed() {
	assertEquals("Meow!",clickEventPage.getTextDemo().getText());
}

@When("I click for the dog")
public void i_click_for_the_dog() {
	clickEventPage.getDog().click(); 
}

@Then("I verify the Woof! displayed")
public void i_verify_the_woof_displayed() {
	assertEquals("Woof!",clickEventPage.getTextDemo().getText()); 
}

@When("I click for the pig")
public void i_click_for_the_pig() {
	clickEventPage.getPig().click();
}

@Then("I verify the Oink! displayed")
public void i_verify_the_oink_displayed() {
	assertEquals("Oink!",clickEventPage.getTextDemo().getText()); 
}

@When("I click for the cow")
public void i_click_for_the_cow() {
	clickEventPage.getCow().click();
}

@Then("I verify the Moo! displayed")
public void i_verify_the_moo_displayed() {
	assertEquals("Moo!",clickEventPage.getTextDemo().getText()); 
}


}
