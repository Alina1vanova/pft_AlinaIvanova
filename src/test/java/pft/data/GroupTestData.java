package pft.data;

import org.testng.annotations.DataProvider;
import pft.tests.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static pft.data.GroupDataGenerator.generateRandomGroups;

/**
 * Created by linka on 27.02.2015.
 */
public class GroupTestData {
    @DataProvider(name = "randomValidGroupData")
    private static Iterator<Object[]> randomValidGroupData() {
        return TestBase.wrapGroupsDataProvider(generateRandomGroups(3)).iterator();
    }


}
