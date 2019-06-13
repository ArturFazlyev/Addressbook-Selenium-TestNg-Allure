package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.modele.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

    @Test
    public void initContactCreation() {
        Set<ContactData> before = app.contact().all();
        app.goTo().contactPage();
        ContactData contact = new ContactData().withFirstname("James").withLastname("Jones")
                .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                .withBday("17").withByear("1985");
        app.contact().fillContactForm(contact);
        app.contact().submitNewContact();
        app.contact().returnHomePage();
        Set<ContactData> after = app.contact().all();

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }


}
