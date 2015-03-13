package pft.data;

import org.testng.annotations.DataProvider;
import pft.helper.GroupHelper;

import java.text.ParseException;
import java.util.*;


/**
 * Created by linka on 27.02.2015.
 */
public class ContactTestData {

    @DataProvider(name = "randomValidContactData")
    private static Iterator<Object[]> randomValidContactData() throws ParseException {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 3; i++) {
            Calendar randomDate = generateDate();
            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString() + " " + generateRandomNumber(1000))
                    .withHome(generateRandomNumber(Integer.MAX_VALUE))
                    .withMobile(generateRandomNumber(Integer.MAX_VALUE))
                    .withWork(generateRandomNumber(Integer.MAX_VALUE))
                    .withEmail(generateRandomString())
                    .withEmail2(generateRandomString())
                    .withBday(randomDate.get(Calendar.DAY_OF_MONTH))
                    .withBmonth(randomDate.get(Calendar.MONTH) + 1)
                    .withYear(randomDate.get(Calendar.YEAR))
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomNumber(Integer.MAX_VALUE));

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

    public static Calendar generateDate() throws ParseException {
        int randomYear = generateIntBetween(1900, 2015);
        int randomDay = generateIntBetween(1, 365);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, randomYear);
        calendar.set(Calendar.DAY_OF_YEAR, randomDay);
        return calendar;
    }

    private static int generateIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

}

