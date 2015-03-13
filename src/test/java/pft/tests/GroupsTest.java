package pft.tests;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import pft.data.GroupData;
import pft.data.GroupTestData;
import pft.helper.GroupHelper;
import org.testng.annotations.Test;
import pft.utils.SortedListOf;


public class GroupsTest extends TestBase {


    @Test(dataProvider = "randomValidGroupData", dataProviderClass = GroupTestData.class)
    public void groupCreationWithValidDataTest(GroupData group) {
        GroupHelper groupHelper = app.getGroupHelper();
        SortedListOf<GroupData> oldList = groupHelper.getGroups();

        GroupData newGroup = groupHelper.createGroup(group);

        SortedListOf<GroupData> newList = groupHelper.getGroups();
        assertThat(newList, equalTo(oldList.withAdded(newGroup)));

    }

    @Test
    public void deleteGroupTest() {
        GroupHelper groupHelper = app.getGroupHelper();
        SortedListOf<GroupData> oldList = groupHelper.getGroups();
        if (!oldList.isEmpty()) {
            int index = groupHelper.randomIndex(oldList.size());

            groupHelper.deleteGroup(index);

            SortedListOf<GroupData> newList = groupHelper.getGroups();
            assertThat(newList, equalTo(oldList.without(index)));

        }
    }

    @Test(dataProvider = "randomValidGroupData", dataProviderClass = GroupTestData.class)
    public void modifyGroupTest(GroupData group) {
        GroupHelper groupHelper = app.getGroupHelper();
        SortedListOf<GroupData> oldList = groupHelper.getGroups();
        if (!oldList.isEmpty()) {
            int index = groupHelper.randomIndex(oldList.size());

            GroupData newGroup = groupHelper.modifyGroup(index, group);

            SortedListOf<GroupData> newList = groupHelper.getGroups();
            assertThat(newList, equalTo(oldList.without(index).withAdded(newGroup)));
        }

    }
}