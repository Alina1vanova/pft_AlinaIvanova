package pft.pages;

import static pft.config.Constants.*;
import static pft.config.MainPageXpathes.*;
import pft.helper.Browser;

public class MainPage {
    Browser browser;

    public MainPage(Browser browser) {
        this.browser = browser;
        this.browser.openUrl(LOGIN_PAGE_URL);
    }

    public void openGroups() {
        browser.clickElement(GROUPS_LINK_XPATH);
    }

}
