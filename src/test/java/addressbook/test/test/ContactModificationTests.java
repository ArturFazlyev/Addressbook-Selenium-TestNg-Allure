package addressbook.test.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import addressbook.test.model.ContactData;
import addressbook.test.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().addContact(new ContactData().withFirstname("James").withLastname("Jones")
                    .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                    .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                    .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                    .withByear("1985"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstname("James").withLastname("Jones")
                .withNickname("Jam.jones");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));

    }

}
