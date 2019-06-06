package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.modele.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void initContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoNewContact();
        ContactData contact = new ContactData().withFirstname("James").withLastname("Jones")
                .withNickname("Jam.jones").withTitle("QA").withCompany("Infotecs")
                .withAddress("Manchester, Stadium Old Trafford").withHome("2780857")
                .withMobile("89053555178").withEmail("james.jones@oldtrafford.com")
                .withBday("17").withBmonth("January").withByear("1985");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        contact.withId(after.stream().max((Comparator<ContactData>) (o1, o2)
                -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);
    }


}
