package pft.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Properties;


/**
 * Created by linka on 24.02.2015.
 */

public class ApplicationManager {
    public WebDriver driver;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private PrintPhonesHelper printPhonesHelper;
    private Properties properties;

    public ApplicationManager(Properties properties) {
        this.properties = properties;
        String browser = properties.getProperty("browser");
        if ("firefox".equals(browser)) {
            FirefoxProfile profile = new FirefoxProfile();
            driver = new FirefoxDriver(profile);
        }
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        else if ("chrome".equals(browser)) {
            // System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            throw new Error("Unsupported browser: " + browser);
        }
        driver.get(properties.getProperty("baseURL"));
    }

    public void stop() {
        driver.quit();
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {
        if (groupHelper == null) {
            groupHelper = new GroupHelper(this);
        }
        return groupHelper;
    }

    public PrintPhonesHelper getPrintPhonesHelper() {
        if (printPhonesHelper == null) {
            printPhonesHelper = new PrintPhonesHelper(this);
        }
        return printPhonesHelper;
    }

    public NavigationHelper navigateTo() {
        if (navigationHelper == null) {
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }
}

