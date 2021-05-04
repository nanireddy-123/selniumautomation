package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPages {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
	WebElement sigin;
	public WebElement getsignin()
	{
		return sigin;
	}
	
	@FindBy(xpath = "//*[@id=\"continue\"]")
	WebElement continues;
	public WebElement getcontinue()
	{
		return continues;
	}
	
	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	WebElement username;
	public WebElement getusername()
	{
		return username;
	}
	
	
	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement password;
	public WebElement getpassword()
	{
		return password;
	}
	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	WebElement signin;
	public WebElement getlogin()
	{
		return signin;
	}
	
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement searchbar;
	public WebElement getsearchbar()
	{
		return searchbar;
	}
	
	@FindBy(xpath = "//*[@id=\"nav-search-bar-form\"]/div[3]/div")
	WebElement searchbutton;
	public WebElement getsearchbutton() {
		return searchbutton;
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img")
	WebElement product;
	public WebElement getproduct()
	{
		return product;
	}
	
	@FindBy(name = "submit.add-to-cart")
	WebElement cart;
	public WebElement getcart()
	{
		return cart;
	}
	
	@FindBy(xpath = "//*[@id=\"nav-cart-count-container\"]")
	WebElement viewcart;
	public WebElement viewcart()
	{
		return viewcart;
	}
	@FindBy(id = "nav-cart-text-container")
	WebElement checkout;
	public WebElement getviewcart()
	{
		return checkout;
	}
	
	
	
	public AmazonPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
