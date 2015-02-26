package pft.data;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String email;
    private final String email2;
    private final String bday;
    private final String bmonth;
    private final String year;
    private final String group;
    private final String address2;
    private final String phone2;

    public ContactData(String firstname, String lastname, String address, String home, String mobile, String work,
                       String email, String email2, String bday, String bmonth, String year, String group, String address2, String phone2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.bday = bday;
        this.bmonth = bmonth;
        this.year = year;
        this.group = group;
        this.address2 = address2;
        this.phone2 = phone2;
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

    public String getBday() {
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
}
