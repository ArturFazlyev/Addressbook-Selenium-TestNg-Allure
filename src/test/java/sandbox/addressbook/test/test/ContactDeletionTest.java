package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test (enabled = false)
    public void testContactDeletition() {
        if (app.getContactHelper().isThereAContact()){
            app.goTo().gotoNewContact();
            app.getContactHelper().createContact(new ContactData("James", "Jones",
                    "Jam.Jones", "QA", "Infotecs",
                    "Manchester, Stadium Old Trafford", "2780857",
                    "89053555178", "james.jones@oldtrafford.com",
                    "17", "January", "1985", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectedContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getSessionHelper();
        List<ContactData> after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
            Assert.assertEquals(before, after);
        }



}
