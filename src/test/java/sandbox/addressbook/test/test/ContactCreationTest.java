package sandbox.addressbook.test.test;

import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.ContactData;
import sandbox.addressbook.test.modele.Contacts;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void initContactCreation() {
        Contacts before = app.contact().all();
        app.goTo().contactPage();
        File photo = new File("src\\test\\java\\sandbox\\addressbook\\test\\resourses\\foto.jpg");
        ContactData contact = new ContactData().withFirstname("James").withLastname("Jones")
                .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                .withBday("17").withByear("1985").withPhoto(photo);
        app.contact().addContact(contact);
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after,
                equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) ->
                        c.getId()).max().getAsInt()))));
    }

}
