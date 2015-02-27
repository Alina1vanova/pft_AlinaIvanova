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
    public void groupCreationWithValidDataTest(GroupData groupData) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();

        List<GroupData> oldList = groupHelper.getGroups();

        groupHelper.initGroupCreation();
        groupHelper.fillGroupForm(groupData);
        if (groupData.getName() == null){
            groupData.setName(groupHelper.getCurrentName());
        }
        groupHelper.submitGroupCreation();
        groupHelper.returnToGroupsPage();

        List<GroupData> newList = groupHelper.getGroups();

        oldList.add(groupData);
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

    //    Random rnd = new Random();
     //   int index = rnd.nextInt(oldList.size()-1);

     int groupsNumber = groupHelper.countGroups();
      int index = groupHelper.randomGroupIndex(groupsNumber);
        groupHelper.deleteGroup(index);
        groupHelper.returnToGroupsPage();

        List<GroupData> newList = groupHelper.getGroups();

        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test(dataProvider = "randomValidGroupData", dataProviderClass = GroupTestData.class)
    public void modifyGroupTest(GroupData groupData) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        navigationHelper.openGroups();
        GroupHelper groupHelper = app.getGroupHelper();

        List<GroupData> oldList = groupHelper.getGroups();
       // Random rnd = new Random();
       // int index = rnd.nextInt(oldList.size()-1);

        int groupsNumber = oldList.size();
        int index = groupHelper.randomGroupIndex(groupsNumber);
        groupHelper.initGroupModify(index);
        groupHelper.fillGroupForm(groupData);
        groupHelper.submitGroupModification();
        groupHelper.returnToGroupsPage();

        List<GroupData> newList = groupHelper.getGroups();

        oldList.remove(index);
        oldList.add(groupData);
        Collections.sort(oldList);

        System.out.println(newList.toString());
        System.out.println(oldList.toString());

        assertEquals(newList, oldList);
    }
}