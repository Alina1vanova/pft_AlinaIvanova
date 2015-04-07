package pft.helper;

import static pft.config.GroupsPageLocators.*;
import static pft.config.HomePageLocators.*;


public class NavigationHelper extends BaseHelper {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (!onMainPage()) {
            click(HOME_LINK_XPATH);
        }
    }

    private boolean onMainPage() {
        return driver.findElements(CONTACTS_TABLE).size() > 0;
    }

    public void groupsPage() {
        if (!onGroupsPage()) {
            click(GROUPS_LINK_XPATH);
        }
    }

    private boolean onGroupsPage() {
        return driver.getCurrentUrl().contains("/groups.php") && driver.findElements(NEW_GROUP_BUTTON).size() > 0;
    }

}
