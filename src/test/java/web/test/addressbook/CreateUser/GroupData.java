package web.test.addressbook.CreateUser;

public class GroupData {
    private final String firstname;
    private final String lastname;
    private final String company;

    public GroupData(String firstname, String lastname, String company) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }
}
