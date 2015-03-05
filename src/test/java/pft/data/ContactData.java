package pft.data;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactData implements Comparable<ContactData> {

    public String firstname;
    public String lastname;
    public String address;
    public String home;
    public String mobile;
    public String work;
    public String email;
    public String email2;
    public String bday;
    public String bmonth;
    public String year;
    public String group;
    public String address2;
    public String phone2;

    @Override
    public String toString() {
        return "ContactData[" +
                "firstname=" + firstname +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData contactData = (ContactData) o;
        if (!firstname.equals(contactData.firstname)) return false;
        return true;
    }

    @Override
    public int compareTo(ContactData other) {
        if (this.firstname != null & other.firstname != null) {
            return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
        } else
            return -1;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
