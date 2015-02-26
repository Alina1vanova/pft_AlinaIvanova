package pft.config;

import org.openqa.selenium.By;

public interface GroupsPageLocators {
    By NEW_GROUP_BUTTON_XPATH = new By.ByXPath("//input[@name='new']");
    By GROUP_NAME_INPUT = new By.ByXPath("//input[@name='group_name']");
    By GROUP_HEADER_INPUT = new By.ByXPath("//textarea[@name='group_header']");
    By GROUP_FOOTER_INPUT = new By.ByXPath("//textarea[@name='group_footer']");
    By SUBMIT_GROUP_CREATION_BUTTON_XPATH = new By.ByXPath("//input[@name='submit']");
    By RETURN_TO_GROUPS_LINK_XPATH = new By.ByXPath("//a[.='group page']");
    By GROUP_DELETE_BUTTON = new By.ByXPath("//input[@name='delete']");
    By GROUP_EDIT_BUTTON = new By.ByXPath("//input[@name='edit']");
    By SUBMIT_GROUP_MODIFICATION_BUTTON_XPATH = new By.ByXPath("//input[@name='update']");
    String GROUP_CHECKBOX_XPATH = "//input[@name='selected[]']";

}
