package pft.helper;

import org.openqa.selenium.WebElement;

import static pft.config.PrintPhonesLocators.*;
import static pft.config.HomePageLocators.*;

import pft.data.ContactData;
import pft.utils.SortedListOf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linka on 16.03.2015.
 */
public class PrintPhonesHelper extends BaseHelper {

    public PrintPhonesHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<ContactData> contacts;

    public SortedListOf<ContactData> getPrintedPhones() {
        manager.navigateTo().mainPage();
        initPrintPhones();
        return getContacts();
    }

    private void initPrintPhones() {
        click(PRINT_PHONES_LINK_XPATH);
    }

    public SortedListOf<ContactData> getContacts() {
        contacts = new SortedListOf<ContactData>();
        List<WebElement> cells = getCells();
        for (WebElement cell : cells) {
            ContactData contact = new ContactData()
                    .withFirstname(findNames(cell).get("firstname"))
                    .withLastname(findNames(cell).get("lastname"))
                    .withTelephone(findTelephone(cell));
            contacts.add(contact);
        }
        return contacts;
    }

    private List<WebElement> getCells() {
        List<WebElement> contactCells = driver.findElements(PRINT_PHONES_CELL);

        System.out.println(contactCells.size() + " size");
        return contactCells;
    }

    private Map<String, String> findNames(WebElement cell) {
        Map<String, String> names = new HashMap();
        String namesString = cell.getText();
        namesString = namesString.substring(0, namesString.indexOf(':'));

        if (namesString.contains(" ")) {
            int space = namesString.indexOf(" ");
            names.put("lastname", namesString.substring(0, space));
            names.put("firstname", namesString.substring(space + 1));
        } else {
            names.put("lastname", "");
            names.put("firstname", namesString);
        }
        return names;
    }

    private String findTelephone(WebElement cell) {

        String cellString = cell.getText();

        for (String str : cellString.split("\n")) {
            if (str.startsWith("H: ")) {
                return str.substring(3).replace(" ", "");
            }
            if (str.startsWith("M: ")) {
                return str.substring(3).replace(" ", "");
            }
            if (str.startsWith("W: ")) {
                return str.substring(3).replace(" ", "");
            }
        }
        return "";
    }
}
