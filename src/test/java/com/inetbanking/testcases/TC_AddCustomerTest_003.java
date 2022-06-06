package com.inetbanking.testcases;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.Loginpage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		Loginpage lp = new Loginpage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");
		Thread.sleep(3000);

//		if (isAlertPresent() == true) {
//			driver.switchTo().alert().accept();//close alert
//			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
//			logger.warn("Not added customer");
//		} else {
//			Assert.assertTrue(true);
//			logger.info("Add customer");
//			Thread.sleep(3000);
//			driver.switchTo().defaultContent();
//		}

			addcust.custName("Aman");
			addcust.custgender("male");
			addcust.custdob("10", "15", "1985");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("HYD");
			addcust.custstate("AP");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("987890091");

			String email = randomestring() + "@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
			addcust.custsubmit();

			Thread.sleep(3000);

			logger.info("validation started....");

			boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

			if (res == true) {
				Assert.assertTrue(true);
				logger.info("test case passed....");

			} else {
				logger.info("test case failed....");
				captureScreen(driver, "addNewCustomer");
				Assert.assertTrue(false);
			}


	}
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}

	}
	
}
