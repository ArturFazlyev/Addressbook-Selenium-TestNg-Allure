package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
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

        int max = 0;
        for (ContactData c : after ){
            if (c.getId() > max){
                max = c.getId();
            }
        }
        contact.setId(max);
        before.add(contact);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
