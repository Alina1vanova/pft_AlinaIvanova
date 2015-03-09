package pft.config;

import org.openqa.selenium.By;

/**
 * Created by linka on 20.02.2015.
 */

public interface ContactPageLocators {
    By FIRST_NAME_INPUT = new By.ByXPath("//input[@name='lastname']");
    By LAST_NAME_INPUT = new By.ByXPath("//input[@name='firstname']");
    By ADDRESS_INPUT = new By.ByXPath("//textarea[@name='address']");
    By HOME_INPUT = new By.ByXPath("//input[@name='home']");
    By MOBILE_INPUT = new By.ByXPath("//input[@name='mobile']");
    By WORK_INPUT = new By.ByXPath("//input[@name='work']");
    By EMAIL_INPUT = new By.ByXPath("//input[@name='email']");
    By EMAIL2_INPUT = new By.ByXPath("//input[@name='email2']");
    By BDAY_SELECT_XPATH = new By.ByXPath("//select[@name='bday']");
    By BMONTH_SELECT_XPATH = new By.ByXPath("//select[@name='bmonth']");
    By BYEAR_INPUT = new By.ByXPath("//input[@name='byear']");
    By ADDRESS2_INPUT = new By.ByXPath("//textarea[@name='address2']");
    By HOME2_INPUT = new By.ByXPath("//input[@name='phone2']");
    By SUBMIT_CONTACT_CREATION_BUTTON_XPATH = new By.ByXPath("//input[@value='Enter']");
    By RETURN_TO_HOME_LINK_XPATH = new By.ByXPath("//a[.='home page']");
    By SUBMIT_CONTACT_MODIFICATION_BUTTON_XPATH = new By.ByXPath("//input[@value='Update']");
    By SUBMIT_CONTACT_DELETE_BUTTON_XPATH = new By.ByXPath("//input[@value='Delete']");
    By NUMBER_OF_CONTACTS = new By.ByXPath("//*[@id='search_count']");
    By SELECT_MONTH = new By.ByXPath(".//select[2]/");
    By CONTACT_TABLE_ROWS = new By.ByXPath("//tr[@name='entry']");
    String CONTACT_TABLE_ROW = "//tr";
    String CONTACT_CHECKBOX_XPATH = "//input[@name='selected[]']";
    String CONTACT_EDIT_BUTTON_XPATH = "//img[@title='Edit']";
}
