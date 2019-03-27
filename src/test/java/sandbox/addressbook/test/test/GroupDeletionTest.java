package sandbox.addressbook.test.test;

import org.testng.annotations.*;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        appManage.getGroupHelper().goToGroupPage();
        appManage.getGroupHelper().selectGroup();
        appManage.getGroupHelper().deleteGroup();
        appManage.getGroupHelper().returnToGroupPage();
    }

}
