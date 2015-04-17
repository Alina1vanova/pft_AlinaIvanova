package pft.data;

public class ContactData implements Comparable<ContactData> {
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String home;
    private String mobile;
    private String work;
    private String email;
    private String email2;
    private int bday;
    private String bmonth;
    private String year;
    private String group;
    private String address2;
    private String phone2;

    private String telephone;

    public ContactData ContactData() {
        return this;
    }

    @Override
    public String toString() {
        return "ContactData[" +
                "firstname=" + firstname +
                "lastname=" + lastname +
                "mobile=" + mobile +
                "home=" + home +
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }


    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withBday(int bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withYear(String year) {
        this.year = year;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public int getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setBday(int bday) {
        this.bday = bday;
    }

    public void setBmonth(String bmonth) {
        this.bmonth = bmonth;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}