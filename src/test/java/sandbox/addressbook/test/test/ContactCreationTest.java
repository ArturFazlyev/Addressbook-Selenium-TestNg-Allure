package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void initContactCreation() {
       int before = appManage.getContactHelper().getContactCount();
        appManage.getNavigationHelper().gotoNewContact();
        appManage.getContactHelper().fillContactForm(new ContactData("James", "Jones",
                "Jam.Jones", "QA", "Infotecs",
                "Manchester, Stadium Old Trafford", "2780857",
                "89053555178", "james.jones@oldtrafford.com",
                "17", "January", "1985", "test1"));
        appManage.getContactHelper().submitNewContact();
        appManage.getContactHelper().returnHomePage();
        int after = appManage.getContactHelper().getContactCount();

        Assert.assertEquals(after, before + 1);
    }


}
