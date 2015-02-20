package pft.pages;

import static pft.config.Constants.*;
import static pft.config.GroupsPageXpathes.*;

import org.apache.bcel.generic.NEW;
import pft.helper.Browser;
import pft.helper.GroupData;

public class GroupsPage {
    Browser browser;

    public GroupsPage(Browser browser) {
        this.browser = browser;
    }

    public void initGroupCreation (){
        browser.clickElement(NEW_GROUP_BUTTON_XPATH);
    }

    public void fillGroupForm(GroupData groupData){

    }
}
