package pft.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.helper.NavigationHelper;
import pft.helper.ContactHelper;

/**
 * Created by linka on 20.02.2015.
 */
public class ContactTest extends TestBase {


    @DataProvider(name = "provideContactData")
    public Object[][] provideData() {
        return new Object[][]{
                {new ContactData("FirstName", "LastName", "Street 2, House 1", "+38048123564",
                        "+380981234567", "+38044881239", "email1@mail.com", "email2@mail.com", "1", "May", "1992", "group 1", "address 2", "12345")},
                {new ContactData("", "", "", "", "", "", "", "", null, null, "", null, "", "")}
        };
    }

    @Test(dataProvider = "provideContactData")
    public void createContactTest(ContactData contactData) {
        NavigationHelper navigationHelper = new NavigationHelper(app);
        navigationHelper.openMainPage();
        navigationHelper.openAddNewContact();
        ContactHelper contactHelper = new ContactHelper(app);
        contactHelper.fillContactForm(contactData);
        contactHelper.submitContactCreation();
        contactHelper.returnToHomePage();
    }

    @Test
    public void modifyContactTest() {
        NavigationHelper navigationHelper = app.getNavigationHelper();
        navigationHelper.openMainPage();
        ContactHelper contactHelper = new ContactHelper(app);
        int contactsNumber = contactHelper.getNumberOfContacts();
        contactHelper.initContactModify(contactHelper.randomContactIndex(contactsNumber));
        contactHelper.fillContactForm(new ContactData("ModifiedName", "Modified", null, null,
                "4567", "239", null, "modifiedemail@mail.com", null, null, null, null, "modified address 2", "54321"));
        contactHelper.submitContactEdit();
        contactHelper.returnToHomePage();
    }

}
