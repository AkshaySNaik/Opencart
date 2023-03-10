package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rewardspointpage {

	WebDriver ldriver;

	public Rewardspointpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continuebttn;

	@FindBy(linkText = "Order History")
	private WebElement orderhistorylink;
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public Orderhistorypage clickOnOrderHistoryLink() {

		orderhistorylink.click();
		return (new Orderhistorypage(ldriver));
	}

	public Accountpage clickOnContinueButton() {

		continuebttn.click();
		return (new Accountpage(ldriver));
	}

	public String getRewardsPointPageTitle() {

		return (ldriver.getTitle());
	}
}
