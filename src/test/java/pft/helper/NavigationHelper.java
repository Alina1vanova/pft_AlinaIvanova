package pft.helper;

import static pft.config.HomePageXpathes.*;
import static pft.config.Constants.*;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage(){openUrl(MAIN_PAGE_URL);}

    public void openGroups() {
        click(GROUPS_LINK_XPATH);
    }

    public  void openAddNewContact(){
        click(ADD_NEW_LINK_XPATH);
    }
}
