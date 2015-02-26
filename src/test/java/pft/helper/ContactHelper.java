package pft.helper;

import static pft.config.ContactPageLocators.*;

import org.openqa.selenium.By;
import pft.data.ContactData;

import java.util.Random;


/**
 * Created by linka on 20.02.2015.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillContactForm(ContactData contactData) {
        enterText(FIRST_NAME_INPUT, contactData.getFirstname());
        enterText(LAST_NAME_INPUT, contactData.getLastname());
        enterText(ADDRESS_INPUT, contactData.getAddress());
        enterText(HOME_INPUT, contactData.getHome());
        enterText(MOBILE_INPUT, contactData.getMobile());
        enterText(WORK_INPUT, contactData.getWork());
        enterText(EMAIL_INPUT, contactData.getEmail());
        enterText(EMAIL2_INPUT, contactData.getEmail2());
        selectByText(BDAY_SELECT_XPATH, contactData.getBday());
        selectByText(BMONTH_SELECT_XPATH, contactData.getBmonth());
        enterText(BYEAR_INPUT, contactData.getYear());
//      selectByText(GROUP_SELECT_XPATH, contactData.getGroup());
        enterText(ADDRESS2_INPUT, contactData.getAddress2());
        enterText(HOME2_INPUT, contactData.getPhone2());
    }

    public void initContactModify(int index) {
        click(By.xpath(CONTACT_TABLE_ROW + "[" + index + "]" + CONTACT_EDIT_BUTTON_XPATH));
    }

    private void selectContactByIndex(int index) {
        click(By.xpath(CONTACT_CHECKBOX_XPATH + "[" + index + "]"));
    }

    public int getNumberOfContacts() {
        return Integer.parseInt(getText(NUMBER_OF_CONTACTS));
    }

    public int randomContactIndex(int number) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(number) + 2;
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


}