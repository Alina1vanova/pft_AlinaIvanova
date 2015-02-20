package pft.tests;

import org.testng.annotations.DataProvider;
import pft.helper.GroupData;
import pft.pages.GroupsPage;
import pft.pages.HomePage;
import org.testng.annotations.Test;

public class GroupsTest extends SetupTest {

    @DataProvider(name = "provideGroupData")
    public Object[][] provideData() {

        return new Object[][] {
                { new GroupData("group 1", "header 1", "footer 1")},
                { new GroupData("", "", "")}
        };
    }

    @Test(dataProvider = "provideGroupData")
    public static void groupCreationTest(GroupData groupData) {
        HomePage homePage = new HomePage(browser);
        homePage.openGroups();
        GroupsPage groupPage = new GroupsPage(browser);
        groupPage.initGroupCreation();
        groupPage.fillGroupForm(groupData);
        groupPage.submitGroupCreation();
        groupPage.returnToGroupsPage();

    }

}