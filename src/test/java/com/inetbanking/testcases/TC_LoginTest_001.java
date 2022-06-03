package com.inetbanking.testcases;

import com.inetbanking.pageobjects.Loginpage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass{

    @Test
    public void loginTest() throws IOException {

        driver.get(baseURL);
        logger.info("URL is opened");
        Loginpage lp=new Loginpage(driver);
        lp.setUserName(username);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();
        String r= driver.getTitle();
        System.out.println(r);
        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else
        {
            captureScreen(driver,"loginTest");
           Assert.assertTrue(false);
           logger.info("Login test failed");
       }
    }
}
