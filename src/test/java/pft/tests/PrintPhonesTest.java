package pft.tests;

/**
 * Created by linka on 16.03.2015.
 */

import org.testng.annotations.Test;
import pft.data.ContactData;
import pft.utils.SortedListOf;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrintPhonesTest extends TestBase {

    @Test
    public void printPhones() {
        SortedListOf<ContactData> contactList = app.getContactHelper().getUIContacts();
        SortedListOf<ContactData> printedPhones = app.getPrintPhonesHelper().getPrintedPhones();

        assertThat(contactList.size(), equalTo(printedPhones.size()));
        assertThat(contactList, equalTo(printedPhones));

        for (int i = 0; i < contactList.size(); i++) {
            assertThat(contactList.get(i).getLastname(), equalTo(printedPhones.get(i).getLastname()));
            assertThat(contactList.get(i).getHome(), equalTo(printedPhones.get(i).getHome().replace(" ","")));
        }
    }

}
