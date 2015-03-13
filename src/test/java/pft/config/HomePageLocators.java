package pft.config;

import org.openqa.selenium.By;

public interface HomePageLocators {
    By GROUPS_LINK_XPATH = new By.ByXPath("//a[.='groups']");
    By HOME_LINK_XPATH = new By.ByXPath("//a[.='home']");
    By ADD_NEW_LINK_XPATH = new By.ByXPath("//a[.='add new']");
    String GROUP_CHECKBOX_XPATH = "//input[@name='selected[]']";
    By CONTACTS_TABLE = new By.ByXPath("//table[@id='maintable']");

}
