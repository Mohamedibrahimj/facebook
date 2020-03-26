package com.cucumber.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.functionallibrary.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement logo;
	
	@FindBy(xpath = "//strong[text()='0123-456-789']")
	private WebElement contactnumber;
	
	@FindBy(xpath = "//a[@title='Contact Us']")
	private WebElement ContactusTab;
	
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	private WebElement SignInButton;
	
	@FindBy(id = "search_query_top")
	private WebElement SearchBox;
	
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement WomenTab;
	
	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	private WebElement DressesTab;
	
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	private WebElement TshirtsTab;

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getContactnumber() {
		return contactnumber;
	}

	public WebElement getContactusTab() {
		return ContactusTab;
	}

	public WebElement getSignInButton() {
		return SignInButton;
	}

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getWomenTab() {
		return WomenTab;
	}

	public WebElement getDressesTab() {
		return DressesTab;
	}

	public WebElement getTshirtsTab() {
		return TshirtsTab;
	}
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
}
