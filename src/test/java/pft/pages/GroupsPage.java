package pft.pages;

import static pft.config.GroupsPageXpathes.*;

import pft.helper.Browser;
import pft.helper.GroupData;

public class GroupsPage {
    Browser browser;

    public GroupsPage(Browser browser) {
        this.browser = browser;
    }

    public void initGroupCreation() {
        browser.clickElement(NEW_GROUP_BUTTON_XPATH);
    }

    public void fillGroupForm(GroupData groupData) {
        browser.enterText(GROUP_NAME_INPUT, groupData.getName());
        browser.enterText(GROUP_HEADER_INPUT, groupData.getHeader());
        browser.enterText(GROUP_FOOTER_INPUT, groupData.getFooter());
    }

    public void submitGroupCreation() {
        browser.clickElement(SUBMIT_GROUP_CREATION_BUTTON_XPATH);
    }

    public void returnToGroupsPage() {
        browser.clickElement(RETURN_TO_GROUPS_LINK_XPATH);
    }
}
