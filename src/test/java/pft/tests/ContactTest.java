package pft.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.data.ContactTestData;
import pft.helper.NavigationHelper;
import pft.helper.ContactHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by linka on 20.02.2015.
 */
public class ContactTest extends TestBase {

    List<String> groups = new ArrayList<String>();

    @Test(dataProvider = "randomValidContactData", dataProviderClass = ContactTestData.class)
    public void createContactTest(ContactData contact) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        ContactHelper contactHelper = app.getContactHelper();
        navigationHelper.openMainPage();

        List<ContactData> oldList = contactHelper.getContacts();

        navigationHelper.openAddNewContact();
        contactHelper.fillContactForm(contact);
        ContactData newContact = contactHelper.checkNullValue(contact);
        contactHelper.submitContactCreation();
        contactHelper.returnToHomePage();

        List<ContactData> newList = contactHelper.getContacts();
        oldList.add(newContact);
        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }

    @Test(dataProvider = "randomValidContactData", dataProviderClass = ContactTestData.class)
    public void modifyContactTest(ContactData contact) {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        ContactHelper contactHelper = app.getContactHelper();
        navigationHelper.openMainPage();

        List<ContactData> oldList = contactHelper.getContacts();
        if (oldList.size() > 1) {
            int index = contactHelper.randomIndex(oldList.size());
            contactHelper.initContactModify(index);
            contactHelper.fillContactForm(contact);
            ContactData newContact = contactHelper.checkNullValue(contact);
            contactHelper.submitContactModify();
            contactHelper.returnToHomePage();
            oldList.remove(index - 1);
            oldList.add(newContact);
        }
        List<ContactData> newList = contactHelper.getContacts();
        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }

    @Test
    public void deleteContactTest() {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        ContactHelper contactHelper = app.getContactHelper();

        List<ContactData> oldList = contactHelper.getContacts();

        if (oldList.size() > 1) {
            int index = contactHelper.randomIndex(oldList.size());
            System.out.println(oldList.size() + " size");
            contactHelper.initContactModify(index);
            contactHelper.submitContactDelete();
            contactHelper.returnToHomePage();
            oldList.remove(index - 1);
        }
        List<ContactData> newList = contactHelper.getContacts();
        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }


}
