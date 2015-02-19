package pft.pages;

import static pft.config.Constants.*;
import static pft.config.GroupsPageXpathes.*;

import org.apache.bcel.generic.NEW;
import pft.helper.Browser;

public class GroupsPage {
    Browser browser;

    public GroupsPage(Browser browser) {
        this.browser = browser;
        MainPage mainpage = new MainPage(browser);
        mainpage.openGroups();

    }

    public void initGroupCreation (){
        browser.clickElement(NEW_GROUP_BUTTON_XPATH);
    }
}
