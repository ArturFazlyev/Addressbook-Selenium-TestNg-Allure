package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import sandbox.addressbook.test.modele.ContactData;

import java.util.Set;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            ContactData contact = new ContactData().withFirstname("James").withLastname("Jones")
                    .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                    .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                    .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                    .withByear("1985");
            app.contact().fillContactForm(contact);
            app.contact().submitNewContact();
            app.contact().returnHomePage();
        }
    }

    @Test
    public void testContactDeletition() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }
}




