package pft.helper;

import static pft.config.ContactPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pft.data.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by linka on 20.02.2015.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillContactForm(ContactData contactData) {
        enterText(FIRST_NAME_INPUT, contactData.firstname);
        enterText(LAST_NAME_INPUT, contactData.lastname);
        enterText(ADDRESS_INPUT, contactData.address);
        enterText(HOME_INPUT, contactData.home);
        enterText(MOBILE_INPUT, contactData.mobile);
        enterText(WORK_INPUT, contactData.work);
        enterText(EMAIL_INPUT, contactData.email);
        enterText(EMAIL2_INPUT, contactData.email2);
        selectByText(BDAY_SELECT_XPATH, contactData.bday);
        selectByText(BMONTH_SELECT_XPATH, contactData.bmonth);
        enterText(BYEAR_INPUT, contactData.year);
//      selectByText(GROUP_SELECT_XPATH, contactData.group);
        enterText(ADDRESS2_INPUT, contactData.address2);
        enterText(HOME2_INPUT, contactData.phone2);
    }

    public void initContactModify(int index) {
        click(By.xpath(CONTACT_TABLE_ROW + "[" + (index+1) + "]" + CONTACT_EDIT_BUTTON_XPATH));
    }

    private void selectContactByIndex(int index) {
        click(By.xpath(CONTACT_CHECKBOX_XPATH + "[" + index + "]"));
    }

    public int countContacts() {
        return Integer.parseInt(getText(NUMBER_OF_CONTACTS));
    }

    public int randomContactIndex(int number) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(number);
        return index;
    }

    public void submitContactCreation() {
        click(SUBMIT_CONTACT_CREATION_BUTTON_XPATH);
    }

    public void submitContactModify() {
        click(SUBMIT_CONTACT_MODIFICATION_BUTTON_XPATH);
    }

    public void submitContactDelete() {
        click(SUBMIT_CONTACT_DELETE_BUTTON_XPATH);
    }

    public void returnToHomePage() {
        click(RETURN_TO_HOME_LINK_XPATH);
    }


    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath(CONTACT_CHECKBOX_XPATH));
        for (WebElement checkbox : checkboxes) {
            int index = checkboxes.indexOf(checkbox)+2;
          //  System.out.println(index +  " index");
            ContactData contact = new ContactData();
            String alt = checkbox.getAttribute("alt");
            //tr[8]/td[2]
            contact.firstname = driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
            contacts.add(contact);
        }

        return contacts;
    }

    public ContactData checkNullValue(ContactData testContact) {
        ContactData contact = new ContactData();
        if (testContact.firstname == null) {
            contact.firstname = (getCurrentFirstName());
        } else {
            contact.firstname = testContact.firstname;
        }
        return contact;
    }

    public int randomIndex(int boundary) {
        Random rnd = new Random();
        return Math.abs(rnd.nextInt(boundary)+1);
    }

    public String getCurrentFirstName() {
        return driver.findElement(FIRST_NAME_INPUT).getAttribute("value");
    }
}