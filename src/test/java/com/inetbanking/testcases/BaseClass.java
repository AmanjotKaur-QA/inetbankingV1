package com.inetbanking.testcases;

import com.inetbanking.utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    Readconfig readconfig1 = new Readconfig();

    public String baseURL = readconfig1.getApplicationURL();
    public String username = readconfig1.getUsername();
    public String password = readconfig1.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void SetUP(String br) {

        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");


        if (br.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (br.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

       @AfterClass
    public void TearDown()
    {
      driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "./screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    public String randomestring()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        return generatedstring;

    }
    public String randomenum()
    {
        String generatedstring2= RandomStringUtils.randomNumeric(4);
        return generatedstring2;

    }
}

