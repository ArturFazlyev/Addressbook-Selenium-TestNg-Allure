package web.test.addressbook.CreateUser.test;

import org.testng.annotations.Test;

public class ContactDeletionTest extends BaseTest {

    @Test
    public void testContactDeletition(){
        appManage.getContactHelper().deleteContact();
        appManage.getSessionHelper();


    }
}
