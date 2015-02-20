package pft.tests;

import org.testng.annotations.Test;
import pft.helper.ContactData;
import pft.pages.HomePage;
import pft.pages.NewContactPage;

/**
 * Created by linka on 20.02.2015.
 */
public class NewContactTest extends SetupTest {

    @Test
    public static void addNewContactTest() {
        HomePage homePage = new HomePage(browser);
        homePage.openAddNewContact();
        NewContactPage newContactPage = new NewContactPage(browser);
        newContactPage.fillContactForm(new ContactData("FirstName", "LastName", "Street 2, House 1", "+38048123564",
                "+380981234567", "+38044881239", "email1@mail.com", "email2@mail.com", "1", "May", "1992", "group 1", "address 2", "12345"));
        newContactPage.submitContactCreation();
        newContactPage.returnToHomePage();
    }
}
