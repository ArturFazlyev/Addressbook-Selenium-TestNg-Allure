package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test(enabled = false)
    public void initContactCreation() {
        List<ContactData> before = appManage.getContactHelper().getContactList();
        appManage.getNavigationHelper().gotoNewContact();
        ContactData contact = new ContactData("James", "Jones",
                "Jam.Jones", "QA", "Infotecs",
                "Manchester, Stadium Old Trafford", "2780857",
                "89053555178", "james.jones@oldtrafford.com",
                "17", "January", "1985", "test1");
        appManage.getContactHelper().fillContactForm(contact);
        appManage.getContactHelper().submitNewContact();
        appManage.getContactHelper().returnHomePage();
        List<ContactData> after = appManage.getContactHelper().getContactList();

        contact.setId(after.stream().max((Comparator<ContactData>) (o1, o2)
                -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);
    }


}
