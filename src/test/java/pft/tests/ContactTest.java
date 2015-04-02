package pft.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.data.ContactTestData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static pft.data.ContactDataGenerator.loadContactsFromCsvFile;
import static pft.data.ContactDataGenerator.loadContactsFromXmlFile;
import static pft.helper.ContactHelper.CREATION;
import static pft.helper.ContactHelper.MODIFICATION;

import pft.helper.ContactHelper;
import pft.utils.SortedListOf;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


/**
 * Created by linka on 20.02.2015.
 */
public class ContactTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        return wrapContactsDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
        //return wrapContactsDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
    }

    @Test(dataProvider = "contactsFromFile")
    public void createContactTest(ContactData contact) {
        ContactHelper contactHelper = app.getContactHelper();
        SortedListOf<ContactData> oldList = contactHelper.getContacts();

        ContactData newContact = contactHelper.createContact(contact, CREATION);

        SortedListOf<ContactData> newList = contactHelper.getContacts();
        assertThat(newList, equalTo(oldList.withAdded(newContact)));
    }

    @Test(dataProvider = "randomValidContactData", dataProviderClass = ContactTestData.class)
    public void modifyContactTest(ContactData contact) {
        ContactHelper contactHelper = app.getContactHelper();
        SortedListOf<ContactData> oldList = contactHelper.getContacts();

        if (!oldList.isEmpty()) {
            int index = contactHelper.randomIndex(oldList.size());

            ContactData newContact = contactHelper.modifyContact(contact, index, MODIFICATION);

            SortedListOf<ContactData> newList = contactHelper.getContacts();
            assertThat(newList, equalTo(oldList.without(index - 1).withAdded(newContact)));
        }
    }

    @Test
    public void deleteContactTest() {
        ContactHelper contactHelper = app.getContactHelper();
        SortedListOf<ContactData> oldList = contactHelper.getContacts();

        if (!oldList.isEmpty()) {
            int index = contactHelper.randomIndex(oldList.size());

            contactHelper.deleteContact(index);

            SortedListOf<ContactData> newList = contactHelper.getContacts();
            assertThat(newList, equalTo(oldList.without(index - 1)));
        }
    }

}
