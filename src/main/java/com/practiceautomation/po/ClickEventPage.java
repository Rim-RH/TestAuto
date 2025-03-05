package com.practiceautomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickEventPage extends PageObject {
	public ClickEventPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath = "//h1[@itemprop='headline']")
	private WebElement headLine;
	
	
	@FindBy(xpath = "//button[@onclick='catSound()']")
	private WebElement Cat;
	@FindBy(xpath = "//button[@onclick='dogSound()']")
	private WebElement Dog;
	@FindBy(xpath = "//b[normalize-space()='Pig']")
	private WebElement Pig;
	@FindBy(xpath = "//b[normalize-space()='Cow']")
	private WebElement Cow;
	@FindBy(id = "demo")
	private WebElement textDemo;

	public WebElement getCat() {
		return Cat;
	}

	public void setCat(WebElement cat) {
		Cat = cat;
	}

	public WebElement getHeadLine() {
		return headLine;
	}

	public void setHeadLine(WebElement headLine) {
		this.headLine = headLine;
	}

	public WebElement getDog() {
		return Dog;
	}

	public void setDog(WebElement dog) {
		Dog = dog;
	}

	public WebElement getPig() {
		return Pig;
	}

	public void setPig(WebElement pig) {
		Pig = pig;
	}

	public WebElement getCow() {
		return Cow;
	}

	public void setCow(WebElement cow) {
		Cow = cow;
	}

	public WebElement getTextDemo() {
		return textDemo;
	}

	public void setTextDemo(WebElement textDemo) {
		this.textDemo = textDemo;
	}
}