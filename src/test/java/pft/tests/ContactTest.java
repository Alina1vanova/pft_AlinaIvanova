package pft.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.data.ContactTestData;
import pft.helper.ContactHelper;
import pft.utils.SortedListOf;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static pft.data.ContactDataGenerator.loadContactsFromCsvFile;
import static pft.helper.ContactHelper.*;


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

        SortedListOf<ContactData> oldList = app.getModel().getContacts();
        ContactData newContact = contactHelper.createContact(contact, CREATION);
        SortedListOf<ContactData> newList = app.getModel().getContacts();

        assertThat(newList, equalTo(oldList.withAdded(newContact)));

        if (timeToCheck()) {
            compareImplementationAndModel();
        }
    }

    @Test(dataProvider = "randomValidContactData", dataProviderClass = ContactTestData.class)
    public void modifyContactTest(ContactData contact) {
        ContactHelper contactHelper = app.getContactHelper();
        SortedListOf<ContactData> oldList = app.getModel().getContacts();

        if (!oldList.isEmpty()) {
            int index = contactHelper.randomIndex(oldList.size());
            ContactData newContact = contactHelper.modifyContact(contact, index, MODIFICATION);
            SortedListOf<ContactData> newList = app.getModel().getContacts();

            assertThat(newList, equalTo(oldList.without(index - 1).withAdded(newContact)));
        }
    }

    @Test
    public void deleteContactTest() {
        ContactHelper contactHelper = app.getContactHelper();

        SortedListOf<ContactData> oldList = app.getModel().getContacts();
        if (!oldList.isEmpty()) {
            int index = contactHelper.randomIndex(oldList.size() - 1);
            contactHelper.deleteContact(index);
            SortedListOf<ContactData> newList = app.getModel().getContacts();

            assertThat(newList, equalTo(oldList.without(index)));
        }
        if (timeToCheck()) {
            compareImplementationAndModel();
        }
    }

    public void compareImplementationAndModel() {
        if (app.getBooleanProperty("check.db")) {
            assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
        }
        if (app.getBooleanProperty("check.ui")) {
            assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUIContacts()));
        }
    }
}
