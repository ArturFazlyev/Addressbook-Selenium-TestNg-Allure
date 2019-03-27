package sandbox.addressbook.test.test;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletition() {
        appManage.getContactHelper().deleteContact();
        appManage.getSessionHelper();


    }
}
