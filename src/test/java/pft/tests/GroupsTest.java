package pft.tests;

import static org.testng.Assert.assertEquals;

import pft.data.GroupData;
import pft.data.GroupTestData;
import pft.helper.GroupHelper;
import pft.helper.NavigationHelper;
import org.testng.annotations.Test;

import java.util.*;

public class GroupsTest extends TestBase {

    @Test(dataProvider = "randomValidGroupData", dataProviderClass = GroupTestData.class)
    public void groupCreationWithValidDataTest(GroupData group) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();

        List<GroupData> oldList = groupHelper.getGroups();

        groupHelper.initGroupCreation();
        groupHelper.fillGroupForm(group);
        GroupData newGroup = groupHelper.checkNullValue(group);
        groupHelper.submitGroupCreation();
        groupHelper.returnToGroupsPage();

        List<GroupData> newList = groupHelper.getGroups();

        oldList.add(newGroup);
        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }

    @Test
    public void deleteGroupTest() {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();

        List<GroupData> oldList = groupHelper.getGroups();

        int index = groupHelper.randomIndex(oldList.size());
        groupHelper.deleteGroup(index);
        groupHelper.returnToGroupsPage();

        List<GroupData> newList = groupHelper.getGroups();

        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test(dataProvider = "randomValidGroupData", dataProviderClass = GroupTestData.class)
    public void modifyGroupTest(GroupData group) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();

        List<GroupData> oldList = groupHelper.getGroups();

        int index = groupHelper.randomIndex(oldList.size());
        groupHelper.initGroupModify(index);
        groupHelper.fillGroupForm(group);
        GroupData newGroup = groupHelper.checkNullValue(group);
        groupHelper.submitGroupModification();
        groupHelper.returnToGroupsPage();

        List<GroupData> newList = groupHelper.getGroups();

        oldList.remove(index);
        oldList.add(newGroup);
        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }
}