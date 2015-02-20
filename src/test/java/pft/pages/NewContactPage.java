package pft.pages;

import static pft.config.ContactPageXPathes.*;

import pft.helper.Browser;
import pft.helper.ContactData;


/**
 * Created by linka on 20.02.2015.
 */
public class NewContactPage {
    Browser browser;

    public NewContactPage(Browser browser) {
        this.browser = browser;
    }

    public void fillContactForm(ContactData contactData) {
        browser.enterText(FIRST_NAME_INPUT,contactData.getFirstname());
        browser.enterText(LAST_NAME_INPUT,contactData.getLastname());
        browser.enterText(ADDRESS_INPUT,contactData.getAddress());
        browser.enterText(HOME_INPUT,contactData.getHome());
        browser.enterText(MOBILE_INPUT,contactData.getMobile());
        browser.enterText(WORK_INPUT,contactData.getWork());
        browser.enterText(EMAIL_INPUT,contactData.getEmail());
        browser.enterText(EMAIL2_INPUT,contactData.getEmail2());
        browser.selectItem(BDAY_SELECT_XPATH, contactData.getBday());
        browser.selectItem(BMONTH_SELECT_XPATH,contactData.getBmonth());
        browser.enterText(BYEAR_INPUT,contactData.getYear());
        browser.selectItem(GROUP_SELECT_XPATH,contactData.getGroup());
        browser.enterText(ADDRESS2_INPUT,contactData.getAddress2());
        browser.enterText(HOME2_INPUT,contactData.getPhone2());
    }

    public void submitContactCreation() {
        browser.clickElement(SUBMIT_CONTACT_CREATION_BUTTON_XPATH);
    }

    public void returnToHomePage() {
        browser.clickElement(RETURN_TO_HOME_LINK_XPATH);
    }
}
