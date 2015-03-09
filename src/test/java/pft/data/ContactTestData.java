package pft.data;

import org.testng.annotations.DataProvider;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static pft.config.Constants.*;

/**
 * Created by linka on 27.02.2015.
 */
public class ContactTestData {


    @DataProvider(name = "randomValidContactData")
    private static Iterator<Object[]> randomValidContactData() throws ParseException {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 3; i++) {
            ContactData contact = new ContactData();
            contact.firstname = generateRandomString();
            contact.lastname = generateRandomString();
            contact.address = generateRandomString() + " " + generateRandomNumber(1000);
            contact.home = generateRandomNumber(Integer.MAX_VALUE);
            contact.mobile = generateRandomNumber(Integer.MAX_VALUE);
            contact.work = generateRandomNumber(Integer.MAX_VALUE);
            contact.email = generateRandomString();
            contact.email2 = generateRandomString();
            Calendar randomDate = generateDate();
            contact.bday = randomDate.get(Calendar.DAY_OF_MONTH);
            contact.bmonth = randomDate.get(Calendar.MONTH) + 1;
            contact.year = randomDate.get(Calendar.YEAR);
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

