package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.module.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test (enabled = false)
    public void testContactModification(){
        if (! app.getContactHelper().isThereAContact()){
            app.goTo().gotoNewContact();
            app.getContactHelper().createContact(new ContactData("James", "Jones",
                    "Jam.Jones", "QA", "Infotecs",
                    "Manchester, Stadium Old Trafford", "2780857",
                    "89053555178", "james.jones@oldtrafford.com",
                    "17", "January", "1985", "test1"));
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectedContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size() -1).getId(),"James", "Jones",
                "Jam.Jones", "QA", "Infotecs",
                "Manchester, Stadium Old Trafford", "2780857",
                "89053555178", "james.jones@oldtrafford.com", "17",
                "January", "1985", null);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactUpdate();
        app.getSessionHelper();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);

    }

}
