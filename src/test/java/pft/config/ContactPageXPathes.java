package pft.config;

/**
 * Created by linka on 20.02.2015.
 */

public interface ContactPageXPathes {
    String FIRST_NAME_INPUT = "//input[@name='firstname']";
    String LAST_NAME_INPUT = "//input[@name='lastname']";
    String ADDRESS_INPUT = "//textarea[@name='address']";
    String HOME_INPUT = "//input[@name='home']";
    String MOBILE_INPUT = "//input[@name='mobile']";
    String WORK_INPUT = "//input[@name='work']";
    String EMAIL_INPUT = "//input[@name='email']";
    String EMAIL2_INPUT = "//input[@name='email2']";
    String BDAY_SELECT_XPATH = "//select[@name='bday']";
    String BMONTH_SELECT_XPATH = "//select[@name='bmonth']";
    String BYEAR_INPUT = "//input[@name='byear']";
    String ADDRESS2_INPUT = "//textarea[@name='address2']";
    String HOME2_INPUT = "//input[@name='phone2']";
    String SUBMIT_CONTACT_CREATION_BUTTON_XPATH = "//input[@value='Enter']";
    String RETURN_TO_HOME_LINK_XPATH = "//a[.='home page']";
    String CONTACT_CHECKBOX_XPATH = "//input[@name='selected[]']";
    String CONTACT_TABLE_ROW = "//tr";
    String CONTACT_EDIT_BUTTON_XPATH = "//img[@title='Edit']";
    String SUBMIT_CONTACT_MODIFICATION_BUTTON_XPATH = "//input[@value='Update']";
    String SUBMIT_CONTACT_DELETE_BUTTON_XPATH = "//input[@value='Delete']";
}
