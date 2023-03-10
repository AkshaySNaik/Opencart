package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;

public class TC088_SCupdatewthnegativeqtytest extends BaseClass {

	@Test(dataProvider = "invalidcredentials")
	public void shopCartByAddingNegativeQtyNumber(String validdata) {

		log.info("***** TC088_SCupdatewthnegativeqtytest Started *****");

		String[] data = validdata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.isDispalyedOfProductAvailabity());
		log.info("Availabity Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductAvailabity());

		Assert.assertTrue(prdtpg.isDispalyedOfProductCode());
		log.info("Product Code Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductCode());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed");

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayediMacLink());
		log.info("Success Added Product To Shopping cart Page");

		shopcart.enterQtyField(data[2]);
		shopcart.clickOnQtyUpdateButton();
		
		try {
			
		Assert.assertEquals(shopcart.getNoProductAddedMsgFromShopCartPage(), data[3]);
		log.info("Is Displayed Message For Quantity Number Modified: " + shopcart.getNoProductAddedMsgFromShopCartPage());
		
		}catch(Throwable e) {
			
			shopcart.getBorderNoProductAddedMsgFromShopCartPage();
			Assert.fail("Proper Warning Message Is Not Getting Displayed Informing "
					+ "The User To Provide A Positive Number For Quantity Text Field");
		}

		log.info("***** TC088_SCupdatewthnegativeqtytest Completed *****");
	}

	@DataProvider(name = "invalidcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//shoppingcart.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("invalidqty");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("browser");
			Object prdut = data.get("product");
			Object qtyno = data.get("qtynos");
			Object wrnmsg = data.get("warnmsg");

			arr[i] = brows + "," + prdut + "," + qtyno + "," + wrnmsg;
		}
		return arr;
	}
}
