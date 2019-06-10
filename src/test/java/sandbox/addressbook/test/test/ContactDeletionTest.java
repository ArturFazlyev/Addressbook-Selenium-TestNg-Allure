package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletition() {
        if (app.contact().list().size() == 0){
            app.goTo().contactPage();
            ContactData contact = new ContactData().withFirstname("James").withLastname("Jones")
                    .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                    .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                    .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                    .withBday("17").withBmonth("January").withByear("1985");
            app.contact().fillContactForm(contact);
            app.contact().submitNewContact();
            app.contact().returnHomePage();
        }
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().selectedContact(index);
        app.contact().deleteContact();
        app.getSessionHelper();
        List<ContactData> after= app.contact().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
            Assert.assertEquals(before, after);
        }



}
