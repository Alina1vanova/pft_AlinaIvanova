package pft.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pft.data.GroupData;
import pft.data.GroupTestData;
import pft.helper.GroupHelper;
import pft.utils.SortedListOf;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static pft.data.GroupDataGenerator.loadGroupsFromCsvFile;
import static pft.data.GroupDataGenerator.loadGroupsFromXmlFile;


public class GroupsTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> groupsFromFile() throws IOException {
        return wrapGroupsDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
        // return wrapGroupsDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
    }

    @Test(dataProvider = "groupsFromFile")
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