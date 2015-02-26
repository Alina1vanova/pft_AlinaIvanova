package pft.helper;

import static pft.config.ContactPageXPathes.*;

import pft.data.ContactData;


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

    public void submitContactCreation() {
        click(SUBMIT_CONTACT_CREATION_BUTTON_XPATH);
    }

    public void returnToHomePage() {
        click(RETURN_TO_HOME_LINK_XPATH);
    }
}