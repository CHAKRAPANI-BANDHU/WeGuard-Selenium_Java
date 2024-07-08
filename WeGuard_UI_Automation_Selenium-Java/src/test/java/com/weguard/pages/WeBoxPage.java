package com.weguard.pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;

public class WeBoxPage {
	WebDriver weboxdriver;
	ExtentTest test;
	Logger logger;

	public WeBoxPage(WebDriver rdriver, ExtentTest test, Logger logger) {
		weboxdriver = rdriver;
		this.test = test;
		this.logger = logger; 
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@href=\"#/webox\"]")
	@CacheLookup
	WebElement WeBoxURL;
	
	@FindBy(xpath = "//section[@class='policies']//mat-card")
	@CacheLookup
	List<WebElement> PoliciesListInWeBox;
	
	
	public void weboxURLClick() {
		WeBoxURL.click();
	}
	
	public void policiesListInWeBox() {
    // Find all the mat-row elements inside the element for devices
		int rows1 = PoliciesListInWeBox.size();
	    for (int i=0; i < rows1; i++)
	     {
	    	PoliciesListInWeBox.get(i).isDisplayed();
	        test.info(PoliciesListInWeBox.get(i).getText());
	        logger.info("Devices List is displayed.");
	     }		
	}
}



