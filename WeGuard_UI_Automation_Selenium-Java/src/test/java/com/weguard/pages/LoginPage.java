package com.weguard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	WebElement UserId;
	

	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement Password;
	
    @FindBy(xpath = "//mat-slide-toggle[@id='mat-slide-toggle-1']/label/div")
	@CacheLookup
    WebElement RememberMe;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath = "//li[2]/span/span")
	@CacheLookup
	WebElement PortalVersion;
	
	@FindBy(xpath = "/html/body/app-root/app-new-login/div/ul")
	@CacheLookup
	WebElement FooterInformation;

	public void setUserId(String uid) {
		UserId.sendKeys(uid);
	}

	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void rememberMe(String rememberme) {
		RememberMe.click();
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public String portalVersion() {
		String value = PortalVersion.getText();
		return value;
	}
	
	public String footerInformation() {
		String value = FooterInformation.getText();
		return value;
	}
}
