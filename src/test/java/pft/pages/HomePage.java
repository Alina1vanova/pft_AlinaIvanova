package pft.pages;

import static pft.config.Constants.*;
import static pft.config.HomePageXpathes.*;
import pft.helper.Browser;

public class HomePage {
    Browser browser;

    public HomePage(Browser browser) {
        this.browser = browser;
        this.browser.openUrl(MAIN_PAGE_URL);
    }

    public void openGroups() {
        browser.clickElement(GROUPS_LINK_XPATH);
    }

    public  void openAddNewContact(){
        browser.clickElement(ADD_NEW_LINK_XPATH);
    }
}
