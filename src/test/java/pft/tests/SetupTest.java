package pft.tests;

import pft.helper.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.util.concurrent.TimeUnit;

public class SetupTest {
    public static Browser browser;

    @BeforeSuite(groups = {"setup"})
    public void setup() {
        FirefoxProfile profile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        browser = new Browser(driver);
    }

    @AfterSuite(groups = {"closeDriver"})
    public void closeDriver() {
        browser.closeBrowser();
    }

}
