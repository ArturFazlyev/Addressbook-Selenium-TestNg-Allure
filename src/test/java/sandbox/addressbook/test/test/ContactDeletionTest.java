package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletition() {
        if (! app.getContactHelper().isThereAContact()){
            app.goTo().gotoNewContact();
            ContactData contact = new ContactData().withFirstname("James").withLastname("Jones")
                    .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                    .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                    .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                    .withBday("17").withBmonth("January").withByear("1985");
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().submitNewContact();
            app.getContactHelper().returnHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().selectedContact(index);
        app.getContactHelper().deleteContact();
        app.getSessionHelper();
        List<ContactData> after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
            Assert.assertEquals(before, after);
        }



}
