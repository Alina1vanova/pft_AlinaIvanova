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

        groupHelper
                .initGroupCreation()
                .fillGroupForm(group);

        GroupData newGroup = groupHelper.checkNullValue(group);

        groupHelper
                .submitGroupCreation()
                .returnToGroupsPage();

        oldList.add(newGroup);

        List<GroupData> newList = groupHelper.getGroups();
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
        if (oldList.size() > 0) {
            int index = groupHelper.randomIndex(oldList.size());
            groupHelper
                    .deleteGroup(index)
                    .returnToGroupsPage();
            oldList.remove(index);
        }

        List<GroupData> newList = groupHelper.getGroups();
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
        System.out.println();
        if (oldList.size() > 0) {
            int index = groupHelper.randomIndex(oldList.size());
            groupHelper
                    .initGroupModify(index)
                    .fillGroupForm(group);

            GroupData newGroup = groupHelper.checkNullValue(group);

            groupHelper
                    .submitGroupModification()
                    .returnToGroupsPage();

            oldList.remove(index);
            oldList.add(newGroup);
        }
        List<GroupData> newList = groupHelper.getGroups();
        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }
}