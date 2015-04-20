package pft.helper;

import static pft.config.ContactPageLocators.*;
import static pft.config.HomePageLocators.ADD_NEW_LINK_XPATH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    public static boolean CONTACTS_EQUAL = false;

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
        manager.getModel().addContact(newContact);
        return newContact;
    }

    public ContactData modifyContact(ContactData contact, int index, boolean formType) {
        CONTACTS_EQUAL = false;
        manager.navigateTo().mainPage();
        initContactModify(index);
        compareContacts(index);
        fillContactForm(contact, formType);
        ContactData newContact = checkNullValue(contact);
        submitContactModification();
        returnToHomePage();
        manager.getModel().removeContact(index - 1).addContact(newContact);
        return newContact;
    }

    private void compareContacts(int index) {
        ContactData contactFromDB = manager.getHibernateHelper().listContacts().get(index - 1);
        Assert.assertEquals(getCurrentFirstname(), contactFromDB.getFirstname(), "UI firstname doesn't equal DB");
        Assert.assertEquals(getCurrentLastname(), contactFromDB.getLastname(), "UI lastname doesn't equal DB");
        Assert.assertEquals(getCurrentHome(), contactFromDB.getHome(), "UI home phone doesn't equal DB");
        Assert.assertEquals(getCurrentMobile(), contactFromDB.getMobile(), "UI mobile phone doesn't equal DB");
    }

    public void deleteContact(int index) {
        manager.navigateTo().mainPage();
        initContactModify(index);
        submitContactDeletion();
        returnToHomePage();
        manager.getModel().removeContact(index);
    }

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
        selectByIndex(BMONTH_SELECT_XPATH, Integer.parseInt(contactData.getBmonth()));
        enterText(BYEAR_INPUT, contactData.getYear());
        if (formType == CREATION) {
//            selectByText(GROUP_SELECT_XPATH, "group 1");
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
    }

    public void submitContactModification() {
        click(SUBMIT_CONTACT_MODIFICATION_BUTTON_XPATH);
    }

    public void submitContactDeletion() {
        click(SUBMIT_CONTACT_DELETE_BUTTON_XPATH);
    }

    public void returnToHomePage() {
        click(RETURN_TO_HOME_LINK_XPATH);
    }

    public SortedListOf<ContactData> getUIContacts() {
        SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
        List<WebElement> rows = getContactRows();
        for (WebElement row : rows) {
            ContactData contact = new ContactData()
                    .withFirstname(row.findElement(By.xpath(".//td[2]")).getText())
                    .withLastname(row.findElement(By.xpath(".//td[3]")).getText())
                    .withEmail(row.findElement(By.xpath(".//td[4]")).getText())
                    .withHome(row.findElement(By.xpath(".//td[5]")).getText());
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData checkNullValue(ContactData testContact) {
        ContactData contact = new ContactData();
        if (testContact.getFirstname() == null) {
            contact.setFirstname(getCurrentFirstname());
        } else {
            contact.setFirstname(testContact.getFirstname());
        }
        return contact;
    }

    public int randomIndex(int boundary) {
        Random rnd = new Random();
        return Math.abs(rnd.nextInt(boundary) + 1);
    }

    public String getCurrentFirstname() {
        return driver.findElement(FIRST_NAME_INPUT).getAttribute("value");
    }

    public String getCurrentLastname() {
        return driver.findElement(LAST_NAME_INPUT).getAttribute("value");
    }

    public String getCurrentMobile() {
        return driver.findElement(MOBILE_INPUT).getAttribute("value");
    }

    public String getCurrentHome() {
        return driver.findElement(HOME_INPUT).getAttribute("value");
    }

    public List<WebElement> getContactRows() {
        List<WebElement> contactRows = driver.findElements(CONTACT_TABLE_ROWS);
        return contactRows;
    }

}