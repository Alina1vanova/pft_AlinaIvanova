package pft.tests;

import static pft.config.Constants.*;

import pft.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SetupTest {
    @Test
    public static void loginTest() {
        MainPage mainPage = new MainPage(browser);
        mainPage.openGroups();
        String dashboardPageTitle = browser.getPageTitle();
        Assert.assertEquals(dashboardPageTitle, DASHBOARD_TAB_TITLE,
                "Dashboard page title is not correct: " + dashboardPageTitle);
    }


}