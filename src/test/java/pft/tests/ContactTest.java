package pft.tests;

import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.helper.NavigationHelper;
import pft.helper.ContactHelper;

/**
 * Created by linka on 20.02.2015.
 */
public class ContactTest extends TestBase {

    @Test
    public void addNewContactTest() {
        NavigationHelper navigationHelper = new NavigationHelper(app);
        navigationHelper.openAddNewContact();
        ContactHelper contactHelper = new ContactHelper(app);
        contactHelper.fillContactForm(new ContactData("FirstName", "LastName", "Street 2, House 1", "+38048123564",
                "+380981234567", "+38044881239", "email1@mail.com", "email2@mail.com", "1", "May", "1992", "group 1", "address 2", "12345"));
        contactHelper.submitContactCreation();
        contactHelper.returnToHomePage();
    }
}
