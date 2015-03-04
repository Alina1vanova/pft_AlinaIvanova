package pft.helper;

import static pft.config.GroupsPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pft.data.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupHelper extends BaseHelper {


    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupCreation() {
        click(NEW_GROUP_BUTTON_XPATH);
    }

    public void fillGroupForm(GroupData groupData) {
        enterText(GROUP_NAME_INPUT, groupData.getName());
        enterText(GROUP_HEADER_INPUT, groupData.getHeader());
        enterText(GROUP_FOOTER_INPUT, groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(SUBMIT_GROUP_CREATION_BUTTON_XPATH);
    }

    public void returnToGroupsPage() {
        click(RETURN_TO_GROUPS_LINK_XPATH);
    }

    public void deleteGroup(int index) {
        selectGroupByIndex(index + 1);
        click(GROUP_DELETE_BUTTON);
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath(GROUP_CHECKBOX_XPATH));
        for (WebElement checkbox : checkboxes) {
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.setName(title.substring("Select (".length(), title.length() - ")".length()));
            groups.add(group);
        }

        return groups;
    }

    public void initGroupModify(int index) {
        selectGroupByIndex(index + 1);
        click(GROUP_EDIT_BUTTON);
    }

    public void submitGroupModification() {
        click(SUBMIT_GROUP_MODIFICATION_BUTTON_XPATH);
    }

    public int randomIndex(int boundary) {
        Random rnd = new Random();
        return Math.abs(rnd.nextInt(boundary - 1));
    }

    private void selectGroupByIndex(int index) {
        click(By.xpath(GROUP_CHECKBOX_XPATH + "[" + index + "]"));
    }

    private String getCurrentName() {
        return driver.findElement(GROUP_NAME_INPUT).getAttribute("value");
    }

    private String getCurrentHeader() {
        return driver.findElement(GROUP_HEADER_INPUT).getText();
    }

    private String getCurrentFooter() {
        return driver.findElement(GROUP_FOOTER_INPUT).getText();
    }

    public GroupData checkNullValue(GroupData testGroup) {
        GroupData group = new GroupData();
        if (testGroup.getName() == null) {
            group.setName(getCurrentName());
        } else {
            group.setName(testGroup.getName());
        }
        return group;
    }
}