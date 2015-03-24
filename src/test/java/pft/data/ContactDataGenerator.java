package pft.data;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by linka on 16.03.2015.
 */
public class ContactDataGenerator {
    public static void main(String[] args) throws IOException, ParseException {
        if (args.length < 3) {
            System.out.println("Please specify prameters: <amount of test data> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if (file.exists()) {
            System.out.println("File exists, please remove it manually: " + file);
            return;
        }
        List<ContactData> contacts = generateRandomContacts(amount);
        if (format.equals("csv")) {
            saveContactsToCsvFile(contacts, file);
        } else if (format.equals("xml")) {
            saveContactsToXmlFile(contacts, file);
        } else {
            System.out.println("Unknownformat " + format);
            return;
        }
    }

    private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("contact", ContactData.class);
        String xml = xStream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("contact", ContactData.class);
        return (List<ContactData>) xStream.fromXML(file);

    }

    private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(contact.getFirstname() + "," + contact.getLastname() + ",!" + "\n");
        }
        writer.close();
    }

    public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
        List<ContactData> list = new ArrayList<ContactData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] part = line.split(",");
            ContactData contact = new ContactData().withFirstname(part[0])
                    .withLastname(part[1])
                    .withAddress(part[2])
                    .withTelephone(part[3])
                    .withMobile(part[4])
                    .withWork(part[5])
                    .withEmail(part[6])
                    .withEmail2(part[7])
                    .withBday(Integer.parseInt(part[8]))
                    .withBmonth(Integer.parseInt(part[9]))
                    .withYear(Integer.parseInt(part[10]))
                    .withAddress2(part[11])
                    .withPhone2(part[12]);
            list.add(contact);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }

    public static List<ContactData> generateRandomContacts(int amount) throws ParseException {
        List<ContactData> list = new ArrayList<ContactData>();
        for (int i = 0; i < amount; i++) {
            Calendar randomDate = generateDate();
            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString() + " " + generateRandomNumber(1000))
                    .withTelephone(generateRandomNumber(Integer.MAX_VALUE))
                    .withMobile(generateRandomNumber(Integer.MAX_VALUE))
                    .withWork(generateRandomNumber(Integer.MAX_VALUE))
                    .withEmail(generateRandomString())
                    .withEmail2(generateRandomString())
                    .withBday(randomDate.get(Calendar.DAY_OF_MONTH))
                    .withBmonth(randomDate.get(Calendar.MONTH) + 1)
                    .withYear(randomDate.get(Calendar.YEAR))
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomNumber(Integer.MAX_VALUE));
            list.add(contact);
        }
        return list;
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
