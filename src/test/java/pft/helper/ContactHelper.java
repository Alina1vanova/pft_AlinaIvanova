package pft.helper;

import static pft.config.ContactPageLocators.*;
import static pft.config.HomePageLocators.ADD_NEW_LINK_XPATH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pft.data.ContactData;
import pft.utils.SortedListOf;

import java.util.List;
import java.util.Random;


/**
 * Created by linka on 20.02.2015.
 */
public class ContactHelper extends WebDriverBaseHelper {

    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public ContactData createContact(ContactData contact, boolean formType) {
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact, formType);
        ContactData newContact = checkNullValue(contact);
        submitContactCreation();
        returnToHomePage();
        rebuildCache();
        return newContact;
    }

    public ContactData modifyContact(ContactData contact, int index, boolean formType) {
        manager.navigateTo().mainPage();
        initContactModify(index);
        fillContactForm(contact, formType);
        ContactData newContact = checkNullValue(contact);
        submitContactModification();
        returnToHomePage();
        rebuildCache();
        return newContact;
    }

    public void deleteContact(int index) {
        manager.navigateTo().mainPage();
        initContactModify(index);
        submitContactDeletion();
        returnToHomePage();
        rebuildCache();
    }

    private SortedListOf<ContactData> cachedContacts;

    private void initContactCreation() {
        click(ADD_NEW_LINK_XPATH);
    }

    public void fillContactForm(ContactData contactData, boolean formType) {
        enterText(FIRST_NAME_INPUT, contactData.getFirstname());
        enterText(LAST_NAME_INPUT, contactData.getLastname());
        enterText(ADDRESS_INPUT, contactData.getAddress());
        enterText(HOME_INPUT, contactData.getHome());
        enterText(MOBILE_INPUT, contactData.getMobile());
        enterText(WORK_INPUT, contactData.getWork());
        enterText(EMAIL_INPUT, contactData.getEmail());
        enterText(EMAIL2_INPUT, contactData.getEmail2());
        selectByText(BDAY_SELECT_XPATH, Integer.toString(contactData.getBday()));
        selectByIndex(BMONTH_SELECT_XPATH, contactData.getBmonth());
        enterText(BYEAR_INPUT, Integer.toString(contactData.getYear()));
        if (formType == CREATION) {
            selectByText(GROUP_SELECT_XPATH, "group 1");
        } else {
            if (driver.findElements(GROUP_SELECT_XPATH).size() != 0) {
                throw new Error("Group selector exists in contact modification form");
            }
        }
        enterText(ADDRESS2_INPUT, contactData.getAddress2());
        enterText(HOME2_INPUT, contactData.getPhone2());
    }

    public void initContactModify(int index) {
        click(By.xpath(CONTACT_TABLE_ROW + "[" + (index + 1) + "]" + CONTACT_EDIT_BUTTON_XPATH));
    }

    public void submitContactCreation() {
        click(SUBMIT_CONTACT_CREATION_BUTTON_XPATH);
        cachedContacts = null;
    }

    public void submitContactModification() {
        click(SUBMIT_CONTACT_MODIFICATION_BUTTON_XPATH);
        cachedContacts = null;
    }

    public void submitContactDeletion() {
        click(SUBMIT_CONTACT_DELETE_BUTTON_XPATH);
        cachedContacts = null;
    }

    public void returnToHomePage() {
        click(RETURN_TO_HOME_LINK_XPATH);
    }

    public SortedListOf<ContactData> getContacts() {
        if (cachedContacts == null) {
            rebuildCache();
        }
        return cachedContacts;
    }

    private void rebuildCache() {
        cachedContacts = new SortedListOf<ContactData>();
        List<WebElement> rows = getContactRows();
        for (WebElement row : rows) {
            ContactData contact = new ContactData()
                    .withFirstname(row.findElement(By.xpath(".//td[2]")).getText())
                    .withLastname(row.findElement(By.xpath(".//td[3]")).getText())
                    .withEmail(row.findElement(By.xpath(".//td[4]")).getText())
                    .withTelephone(row.findElement(By.xpath(".//td[5]")).getText());
            cachedContacts.add(contact);
        }
    }

    public ContactData checkNullValue(ContactData testContact) {
        ContactData contact = new ContactData();
        if (testContact.getFirstname() == null) {
            contact.setFirstname(getCurrentFirstName());
        } else {
            contact.setFirstname(testContact.getFirstname());
        }
        return contact;
    }

    public int randomIndex(int boundary) {
        Random rnd = new Random();
        return Math.abs(rnd.nextInt(boundary) + 1);
    }

    public String getCurrentFirstName() {
        return driver.findElement(FIRST_NAME_INPUT).getAttribute("value");
    }

    public List<WebElement> getContactRows() {
        List<WebElement> contactRows = driver.findElements(CONTACT_TABLE_ROWS);
        return contactRows;
    }

}