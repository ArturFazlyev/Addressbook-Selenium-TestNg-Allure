package sandbox.addressbook.test.test;

import org.testng.annotations.Test;
import sandbox.addressbook.test.module.ContactData;

public class ContactModificationTests extends BaseTest {

    @Test
    public void testContactModification(){
        appManage.getContactHelper().initContactModification();
        appManage.getContactHelper().createNewContact(new ContactData("James", "Jones", "Jam.Jones", "QA", "Infotecs", "Manchester, Stadium Old Trafford", "2780857", "89053555178", "james.jones@oldtrafford.com", "17", "January", "1985"));
        appManage.getContactHelper().submitContactUpdate();
        appManage.getSessionHelper();

    }

}
