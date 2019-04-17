package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.module.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletition() {
        appManage.getNavigationHelper().gotoNewContact();
        if (! appManage.getContactHelper().isThereAContact()){
            appManage.getContactHelper().createContact(new ContactData("James", "Jones",
                    "Jam.Jones", "QA", "Infotecs",
                    "Manchester, Stadium Old Trafford", "2780857",
                    "89053555178", "james.jones@oldtrafford.com",
                    "17", "January", "1985", "test1"));
        }
        int before = appManage.getContactHelper().getContactCount();
        appManage.getContactHelper().selectedContact(before - 1);
        appManage.getContactHelper().deleteContact();
        appManage.getSessionHelper();
        int after = appManage.getContactHelper().getContactCount();

        Assert.assertEquals(after, before - 1);


    }
}
