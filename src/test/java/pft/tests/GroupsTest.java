package pft.tests;

import org.testng.annotations.DataProvider;
import pft.data.GroupData;
import pft.helper.GroupHelper;
import pft.helper.NavigationHelper;
import org.testng.annotations.Test;

public class GroupsTest extends TestBase {

    @DataProvider(name = "provideGroupData")
    public Object[][] provideData() {
        return new Object[][]{
                {new GroupData("group 1", "header 1", "footer 1")},
                {new GroupData("", "", "")}
        };
    }

    @Test(dataProvider = "provideGroupData")
    public void groupCreationTest(GroupData groupData) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();
        groupHelper.initGroupCreation();
        groupHelper.fillGroupForm(groupData);
        groupHelper.submitGroupCreation();
        groupHelper.returnToGroupsPage();
    }

    @Test
    public void deleteGroup() {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();
        int groupsNumber = groupHelper.getNumberOfGroups();
        groupHelper.deleteGroup(groupHelper.randomGroupIndex(groupsNumber));
        groupHelper.returnToGroupsPage();
    }

    @Test
    public void modifyGroup() {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupData group = new GroupData("modifiedGroup", null, null);
        GroupHelper groupHelper = app.getGroupHelper();
        int groupsNumber = groupHelper.getNumberOfGroups();
        groupHelper.initGroupModify(groupHelper.randomGroupIndex(groupsNumber));
        groupHelper.fillGroupForm(group);
        groupHelper.submitGroupModification();
        groupHelper.returnToGroupsPage();
    }
}