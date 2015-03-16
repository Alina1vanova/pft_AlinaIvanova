package pft.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import static pft.config.Constants.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by linka on 24.02.2015.
 */

public class ApplicationManager {
    public WebDriver driver;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private PrintPhonesHelper printPhonesHelper;

    public ApplicationManager() {
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(MAIN_PAGE_URL);
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

