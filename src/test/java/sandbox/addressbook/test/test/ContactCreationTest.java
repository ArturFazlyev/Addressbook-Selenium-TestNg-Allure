package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.modele.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test(enabled = false)
    public void initContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoNewContact();
        ContactData contact = new ContactData("James", "Jones",
                "Jam.Jones", "QA", "Infotecs",
                "Manchester, Stadium Old Trafford", "2780857",
                "89053555178", "james.jones@oldtrafford.com",
                "17", "January", "1985", "test1");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        contact.setId(after.stream().max((Comparator<ContactData>) (o1, o2)
                -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);
    }


}
