package com.weguard.pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class DashboardPage {
	WebDriver dpdriver;
	ExtentTest test;
	Logger logger;

	public DashboardPage(WebDriver ddriver, ExtentTest test, Logger logger) {
		dpdriver = ddriver;
		this.test = test;
		this.logger = logger;
		PageFactory.initElements(ddriver, this);
	}

	@FindBy(xpath = "//*[@href=\"#/dashboard\"]")
	@CacheLookup
	WebElement dbURL;

	@FindBy(xpath = "//div[@class='headerLogo ng-tns-c252-5']//img[1]")
	@CacheLookup
	WebElement dashboardLogo;

	@FindBy(xpath = "//*[text()='menu']")
	@CacheLookup
	WebElement HamburgerIcon;

	@FindBy(xpath = "//div[text()[normalize-space()='Active Users']]")
	@CacheLookup
	WebElement ActiveUsers;

	@FindBy(xpath = "(//div[@class='count'])[1]")
	@CacheLookup
	WebElement ActiveUsersCount;

	@FindBy(xpath = "//div[normalize-space()='Active Devices']")
	@CacheLookup
	WebElement ActiveDevices;

	@FindBy(xpath = "(//div[@class='count'])[2]")
	@CacheLookup
	WebElement ActiveDevicesCount;

	@FindBy(xpath = "//div[normalize-space()='Non-Compliant']")
	@CacheLookup
	WebElement NonCompliant;

	@FindBy(xpath = "(//div[@class='count'])[3]")
	@CacheLookup
	WebElement NonCompliantCount;

	@FindBy(xpath = "//div[normalize-space()='Files']")
	@CacheLookup
	WebElement Files;

	@FindBy(xpath = "(//div[@class='count'])[4]")
	@CacheLookup
	WebElement FilesCount;

	@FindBy(xpath = "//div[normalize-space()='Messages']")
	@CacheLookup
	WebElement Messages;

	@FindBy(xpath = "(//div[@class='count'])[5]")
	@CacheLookup
	WebElement MessagesCount;

	@FindBy(xpath = "//div[normalize-space()='Calls']")
	@CacheLookup
	WebElement Calls;

	@FindBy(xpath = "(//div[@class='count'])[6]")
	@CacheLookup
	WebElement CallsCount;

	@FindBy(xpath = "//div[contains(@class,'apexcharts-canvas')][1]")
	@CacheLookup
	WebElement DevicesStatusPieChart;

	@FindBy(xpath = "//p-chart[@type='bar']//div//canvas")
	@CacheLookup
	WebElement DevicesCheckinBarGraph;

	@FindBy(css = "foreignobject")
	@CacheLookup
	WebElement ManufacturerPieChart;

	@FindBy(xpath = "//app-recently-enrolled-devices-table//mat-row[@role='row']")
	@CacheLookup
	List<WebElement> RecentlyEnrolledDevicesList;

	@FindBy(xpath = "//app-high-dataconsuming-devices-table//mat-row[@role='row']")
	@CacheLookup
	List<WebElement> HighDataConsumingDevicesList;

	@FindBy(xpath = "//app-activity-alert")
	@CacheLookup
	List<WebElement> RecentActivity;

	public void getdashboardURL() {
		dbURL.click();
	}

	// Method to get the logo image source URL
	public String getLogo() {
		// Verify if the dashboard logo is displayed
		if (dashboardLogo.isDisplayed()) {
			// Get the value of the src attribute
			return dashboardLogo.getAttribute("src");
		} else {
			return null; // Or handle the case where the logo is not displayed
		}
	}

	public void hamburgerIcon() {
		HamburgerIcon.isDisplayed();
	}

	public void activeUsers() {
		ActiveUsers.isDisplayed();
	}

	public String activeUsersCount() {
		String value1 = ActiveUsersCount.getText();
		return value1;
	}

	public void activeDevices() {
		ActiveDevices.isDisplayed();
	}

	public String activeDevicesCount() {
		String value2 = ActiveDevicesCount.getText();
		return value2;
	}

	public void nonCompliant() {
		NonCompliant.isDisplayed();
	}

	public String nonCompliantCount() {
		String value3 = NonCompliantCount.getText();
		return value3;
	}

	public void files() {
		Files.isDisplayed();
	}

	public String filesCount() {
		String value4 = FilesCount.getText();
		return value4;
	}

	public void messages() {
		Messages.isDisplayed();
	}

	public String messagesCount() {
		String value5 = MessagesCount.getText();
		return value5;
	}

	public void calls() {
		Calls.isDisplayed();
	}

	public String callsCount() {
		String value6 = CallsCount.getText();
		return value6;
	}

	public void devicesStatusPieChart() {
		DevicesStatusPieChart.isDisplayed();
	}

	public void devicesCheckinBarGraph() {
		DevicesCheckinBarGraph.isDisplayed();
	}

	public void manufacturerPieChart() {
		ManufacturerPieChart.isDisplayed();
	}

	public void recentlyEnrolledDevicesList() {
		int rows = RecentlyEnrolledDevicesList.size();
	    logger.info("Number of recently enrolled devices: " + rows);

	    WebDriverWait wait = new WebDriverWait(dpdriver, Duration.ofSeconds(10));

	    for (int i = 1; i < rows; i++) {
	        WebElement element = RecentlyEnrolledDevicesList.get(i);
	        try {
	            wait.until(ExpectedConditions.visibilityOf(element));
	            if (element.isDisplayed()) {
	                test.info(element.getText());
	                logger.info("Recently enrolled device " + i + " is displayed: " + element.getText());
	            } else {
	                logger.info("Recently enrolled device " + i + " is not displayed.");
	            }
	        } catch (Exception e) {
	            logger.error("Element not visible: " + e.getMessage());
	        }

	        if (i % 6 == 0) {
	            logger.info("Displayed 6 items, breaking the loop.");
	            break;
	        }
	    }
	}

	public void highDataConsumingDevicesList() {
		int rows2 = HighDataConsumingDevicesList.size();
	    for (int j=8; j < rows2; j++)
	     {
	    	HighDataConsumingDevicesList.get(j).isDisplayed();
	        test.info(HighDataConsumingDevicesList.get(j).getText());
	        logger.info("High Network Consuming Devices list is displayed.");
		    if ((j + 1) % 13 == 0) {
			       break;
			    }
	     }		
	}

	public int recentActivity() {
		int i = RecentActivity.size();
		return i;
	}

}