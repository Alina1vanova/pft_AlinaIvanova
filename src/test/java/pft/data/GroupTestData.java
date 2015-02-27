package pft.data;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by linka on 27.02.2015.
 */
public class GroupTestData {
    @DataProvider(name = "randomValidGroupData")
    private static Iterator<Object[]> randomValidGroupData() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 2; i++) {
            GroupData group = new GroupData();
            group.setName(generateRandomString());
            group.setHeader(generateRandomString());
            group.setFooter(generateRandomString());
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    private static String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(5) == 0) {
            return "";
        }  else {
            return "test" + rnd.nextInt();
        }

    }
}
