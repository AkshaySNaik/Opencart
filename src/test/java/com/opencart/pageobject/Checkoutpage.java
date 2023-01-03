package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Checkoutpage {

	WebDriver ldriver;

	public Checkoutpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-payment-firstname")
	private WebElement firstname;

	@FindBy(id = "input-payment-lastname")
	private WebElement lastname;

	@FindBy(id = "input-payment-company")
	private WebElement compnyname;

	@FindBy(id = "input-payment-address-1")
	private WebElement addres1;

	@FindBy(id = "input-payment-address-2")
	private WebElement addres2;

	@FindBy(id = "input-payment-city")
	private WebElement cityname;

	@FindBy(id = "input-payment-postcode")
	private WebElement postcode;

	@FindBy(id = "input-payment-country")
	private WebElement contryoption;

	@FindBy(id = "input-payment-zone")
	private WebElement zoneoption;

	@FindBy(id = "button-payment-address")
	private WebElement billdetailscontinuebttn;

	@FindBy(id = "button-shipping-address")
	private WebElement shippaddresbutton;

	@FindBy(id = "button-shipping-method")
	private WebElement shipmethodbutton;

	@FindBy(name = "agree")
	private WebElement agreecheckbox;

	@FindBy(id = "button-payment-method")
	private WebElement paymentbutton;

	@FindBy(id = "button-confirm")
	private WebElement orderconfrmbuttom;

	@FindBy(id = "button-login")
	private WebElement buttonlogin;

	@FindBy(xpath = "//*[@id='collapse-checkout-option']/div/div/div[1]/div[2]/label/input")
	private WebElement guestcheckbox;

	@FindBy(id = "button-account")
	private WebElement guestcheckoutcontinuebttn;

	@FindBy(id = "button-guest")
	private WebElement guestcontinuebttn;

	@FindBy(id = "input-payment-email")
	private WebElement emalpaymnt;

	@FindBy(id = "input-payment-telephone")
	private WebElement telepaymnt;

	@FindBy(name = "account")
	private WebElement registercheckoutcontinuebttn;

	@FindBy(id = "input-payment-password")
	private WebElement password;

	@FindBy(id = "input-payment-confirm")
	private WebElement conpassword;

	@FindBy(name = "agree")
	private WebElement privercypolicycheckbox;

	@FindBy(id = "button-register")
	private WebElement continueregbttn;

	/////////////////////////////////////////////////////////////////////////////

	public void clickOnRegisterContinueButton() {

		continueregbttn.click();
	}

	public void clickOnPrivercyPolicy() {

		privercypolicycheckbox.click();
	}

	public void enterPasswordInTextField(String pass) {

		password.sendKeys(pass);
	}

	public void enteConfirmPasswordInTextField(String conpass) {

		conpassword.sendKeys(conpass);
	}

	public void clickOnRegisterCheckoutRadioButton() {

		registercheckoutcontinuebttn.click();
	}

	public void enterEmailForPayment(String payemail) {

		emalpaymnt.sendKeys(payemail);
	}

	public void enterTelephoneForPayment(String paytele) {

		telepaymnt.sendKeys(paytele);
	}

	public void clickOnGuestContinueButton() {

		guestcontinuebttn.click();
	}

	public void clickOnGuestCheckoutContinueButton() {

		guestcheckoutcontinuebttn.click();
	}

	public void clickOnGuestCheckoutRadioButton() {

		guestcheckbox.click();
	}

	public void clickOnLoginButton() {

		buttonlogin.click();
	}

	public Orderplacedpage clickOnOrderConfirmButton() {

		try {
			orderconfrmbuttom.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return (new Orderplacedpage(ldriver));
	}

	public void clickOnAgreeCheckBox() {

		ReadJavascriptExecutor.clickElementByJavaScript(agreecheckbox, ldriver);

	}

	public void clickOnPaymentButtonContinueButton() {

		try {
			paymentbutton.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnShippingMethodContinueButton() {

		try {
			shipmethodbutton.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnShippingAddressContinueButton() {

		try {
			shippaddresbutton.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnBillContinueButton() {

		try {
			billdetailscontinuebttn.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectZone(int in) {

		Select select = new Select(zoneoption);
		select.selectByIndex(in);
	}

	public void selectCountry(String txt) {

		Select select = new Select(contryoption);
		select.selectByVisibleText(txt);
	}

	public void enterPostalCode(String pcode) {

		postcode.sendKeys(pcode);
	}

	public void enterCityName(String cname) {

		cityname.sendKeys(cname);
	}

	public void enterAddress2(String add2) {

		addres2.sendKeys(add2);
	}

	public void enterAddress1(String add1) {

		addres1.sendKeys(add1);
	}

	public void enterCompanyName(String cmyname) {

		compnyname.sendKeys(cmyname);
	}

	public void enterLastName(String lname) {

		lastname.sendKeys(lname);
	}

	public void enterFirstName(String fname) {

		firstname.sendKeys(fname);
	}

	public String getCheckoutPageTitle() {

		return (ldriver.getTitle());
	}

}
