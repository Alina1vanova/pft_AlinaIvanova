package pft.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.data.ContactTestData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static pft.helper.ContactHelper.CREATION;
import static pft.helper.ContactHelper.MODIFICATION;

import pft.helper.ContactHelper;
import pft.utils.SortedListOf;


/**
 * Created by linka on 20.02.2015.
 */
public class ContactTest extends TestBase {

    @Test(dataProvider = "randomValidContactData", dataProviderClass = ContactTestData.class)
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
