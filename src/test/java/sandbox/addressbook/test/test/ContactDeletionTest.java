package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.module.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletition() {
        if (! appManage.getContactHelper().isThereAContact()){
            appManage.getNavigationHelper().gotoNewContact();
            appManage.getContactHelper().createContact(new ContactData("James", "Jones",
                    "Jam.Jones", "QA", "Infotecs",
                    "Manchester, Stadium Old Trafford", "2780857",
                    "89053555178", "james.jones@oldtrafford.com",
                    "17", "January", "1985", "test1"));
        }
        List<ContactData> before = appManage.getContactHelper().getContactList();
        appManage.getContactHelper().selectedContact(before.size() - 1);
        appManage.getContactHelper().deleteContact();
        appManage.getSessionHelper();
        List<ContactData> after= appManage.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
            Assert.assertEquals(before, after);
        }



}
