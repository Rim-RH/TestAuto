package com.practiceautomation.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BrokenLinksPage extends PageObject {
	
	public BrokenLinksPage (WebDriver driver){
		super(driver);
		// TODO Auto-generated method stub

	}
	
	@FindBy(xpath = "//*[@id='header']/div/a/img")
	private WebElement logo;
	
	
	
	@FindBy(xpath = "HTTP response code")
	private WebElement response;
	
	@FindBy(xpath = "//article[@id='post-1267']/div/p[2]")
	private WebElement idealScenarioText;
	

	@FindBy(xpath = "//td[@class='has-text-align-left'][1]")
	private WebElement missingPageText;
	
	@FindBy(xpath = "//td[@class='has-text-align-left'][2]")
	private WebElement quatreQuatrePageText;
	
	@FindBy(xpath = "//th[@class='has-text-align-left'][1]")
	private WebElement nameText;
	
	@FindBy(xpath = "//th[@class='has-text-align-left'][2]")
	private WebElement statusText;
	
	@FindBy(xpath = "//a[normalize-space()= 'Home']")
	private WebElement homeText;
	
	@FindBy(xpath = "//h1[@itemprop='headline']") 
	private WebElement brokenLink;
	
	@FindBy(xpath = "//p[contains(., '200')]")
	private List<WebElement> code200List;

	public WebElement getLogo() {
		return logo;
	}

	public void setLogo(WebElement logo) {
		this.logo = logo;
	}

	

	public WebElement getResponse() {
		return response;
	}

	public void setResponse(WebElement response) {
		this.response = response;
	}

	public WebElement getIdealScenarioText() {
		return idealScenarioText;
	}

	public void setIdealScenarioText(WebElement idealScenarioText) {
		this.idealScenarioText = idealScenarioText;
	}

	public WebElement getMissingPageText() {
		return missingPageText;
	}

	public void setMissingPageText(WebElement missingPageText) {
		this.missingPageText = missingPageText;
	}

	public WebElement getQuatreQuatrePageText() {
		return quatreQuatrePageText;
	}

	public void setQuatreQuatrePageText(WebElement quatreQuatrePageText) {
		this.quatreQuatrePageText = quatreQuatrePageText;
	}

	public WebElement getNameText() {
		return nameText;
	}

	public void setNameText(WebElement nameText) {
		this.nameText = nameText;
	}

	public WebElement getStatusText() {
		return statusText;
	}

	public void setStatusText(WebElement statusText) {
		this.statusText = statusText;
	}

	public WebElement getHomeText() {
		return homeText;
	}

	public void setHomeText(WebElement homeText) {
		this.homeText = homeText;
	}

	public WebElement getBrokenLink() {
		return brokenLink;
	}

	public void setBrokenLink(WebElement brokenLink) {
		this.brokenLink = brokenLink;
			
		
	}
	
	
	public List<WebElement> getCode200List() {
		return code200List;
	}
	public void setCode200List(List<WebElement> code200List) {
		this.code200List = code200List;
	}
	
	
	
	

}
