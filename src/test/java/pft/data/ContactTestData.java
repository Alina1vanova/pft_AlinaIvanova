package pft.data;

import org.testng.annotations.DataProvider;
import pft.tests.TestBase;

import java.text.ParseException;
import java.util.*;

import static pft.data.ContactDataGenerator.generateRandomContacts;

/**
 * Created by linka on 27.02.2015.
 */
public class ContactTestData {

    @DataProvider(name = "randomValidContactData")
    private static Iterator<Object[]> randomValidContactData() throws ParseException {
        return TestBase.wrapContactsDataProvider(generateRandomContacts(3)).iterator();
    }



}

