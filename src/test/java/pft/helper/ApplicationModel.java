package pft.helper;

import pft.data.ContactData;
import pft.data.GroupData;
import pft.utils.SortedListOf;

/**
 * Created by linka on 15.04.2015.
 */
public class ApplicationModel {
    private SortedListOf<GroupData> groups;
    private SortedListOf<ContactData> contacts;

    public SortedListOf<GroupData> getGroups() {
        return new SortedListOf<GroupData>(groups);
    }

    public void setGroups(SortedListOf<GroupData> groups) {
        this.groups = new SortedListOf<GroupData>(groups);
    }

    public SortedListOf<ContactData> getContacts() {
        return new SortedListOf<ContactData>(contacts);
    }

    public void setContacts(SortedListOf<ContactData> contacts) {
        this.contacts = new SortedListOf<ContactData>(contacts);
    }


    public ApplicationModel addGroup(GroupData group) {
        groups.add(group);
        return this;
    }

    public ApplicationModel removeGroup(int index) {
        groups.remove(index);
        return this;
    }
    public ApplicationModel addContact(ContactData contact) {
        contacts.add(contact);
        return this;
    }

    public ApplicationModel removeContact(int index) {
        contacts.remove(index);
        return this;
    }
}
