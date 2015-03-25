package pft.tests;

import pft.data.ContactData;
import pft.data.GroupData;
import pft.helper.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeSuite
    public void setUp() {
        app = new ApplicationManager();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public static List<Object[]> wrapGroupsDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group : groups) {
            list.add(new Object[]{group});
        }
        return list;
    }
    public static List<Object[]> wrapContactsDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (ContactData contact : contacts) {
            list.add(new Object[]{contact});
        }
        return list;
    }
}
