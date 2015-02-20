package pft.tests;

import static pft.config.Constants.*;

import pft.helper.GroupData;
import pft.pages.GroupsPage;
import pft.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest extends SetupTest {
    @Test
    public static void groupCreationTest() {
        MainPage mainPage = new MainPage(browser);
        mainPage.openGroups();
        GroupsPage groupPage = new GroupsPage(browser);
        groupPage.initGroupCreation();
        groupPage.fillGroupForm(new GroupData("1","header 1","footer 1"));

    }


}