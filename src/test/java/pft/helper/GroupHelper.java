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
        selectGroupByIndex(index-1);
        click(GROUP_DELETE_BUTTON);
    }

    public int randomGroupIndex(int number) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(number) + 1;
        return index;
    }

    public int countGroups() {
        return countElements(GROUP_CHECKBOX_XPATH);
    }

    private void selectGroupByIndex(int index) {
        click(By.xpath(GROUP_CHECKBOX_XPATH + "[" + index + "]"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.xpath(GROUP_CHECKBOX_XPATH));
        for (WebElement checkbox : checkboxes){
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.setName(title.substring("Select (".length(),title.length()-")".length()));
            groups.add(group);
        }

        return groups;
    }

    public void initGroupModify(int index) {
        selectGroupByIndex(index);
        click(GROUP_EDIT_BUTTON);
    }

    public void submitGroupModification() {
        click(SUBMIT_GROUP_MODIFICATION_BUTTON_XPATH);
    }


    public String getCurrentName() {
        return driver.findElement(GROUP_NAME_INPUT).getAttribute("value");
    }
}