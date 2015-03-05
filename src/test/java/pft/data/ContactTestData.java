package pft.data;

import org.testng.annotations.DataProvider;

import java.util.*;

import static pft.config.Constants.*;

/**
 * Created by linka on 27.02.2015.
 */
public class ContactTestData {


    @DataProvider(name = "randomValidContactData")
    private static Iterator<Object[]> randomValidContactData() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 2; i++) {
            ContactData contact = new ContactData();
            contact.firstname = generateRandomString();
            contact.lastname = generateRandomString();
            contact.address = generateRandomString() + " " + generateRandomNumber(1000);
            contact.home = generateRandomNumber(Integer.MAX_VALUE);
            contact.mobile = generateRandomNumber(Integer.MAX_VALUE);
            contact.work = generateRandomNumber(Integer.MAX_VALUE);
            contact.email = generateRandomString();
            contact.email2 = generateRandomString();
            contact.bday = generateRandomNumber(31);
            if (contact.bday == "") contact.bday = null;
            int randomMonth = generateRandomMonth(MONTHS.size());
            contact.bmonth = MONTHS.get(randomMonth);
            contact.year = generateRandomNumber(100);
            contact.address2 = generateRandomString();
            contact.phone2 = generateRandomNumber(Integer.MAX_VALUE);

            list.add(new Object[]{contact});
        }
        return list.iterator();
    }


    private static String generateRandomString() {
        Random rnd = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int randomNumber = rnd.nextInt(5);

        if (randomNumber == 0) {
            return "";
        } else if (randomNumber == 1) {
            return null;
        } else {
            StringBuffer randomString = new StringBuffer();
            int length = rnd.nextInt(20);
            for (int i = 1; i < length; i++) {
                double index = Math.random() * letters.length();
                randomString.append(letters.charAt((int) index));
            }
            return randomString.toString();
        }
    }

    private static int generateRandomMonth(int boundary) {
        Random rnd = new Random();
        return rnd.nextInt(boundary);
    }

    private static String generateRandomNumber(int boundary) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(5);
        if (randomNumber == 0) {
            return "";
        } else if (randomNumber == 1) {
            return null;
        } else {
            return Integer.toString(rnd.nextInt(boundary) + 1);
        }

    }

}

