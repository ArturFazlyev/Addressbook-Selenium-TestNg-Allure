package web.test.addressbook.CreateUser.test;

import org.testng.annotations.*;

public class GroupDeletionTest extends BaseTest {

    @Test
    public void testGroupDeletion() throws Exception {
        appManage.getGroupHelper().goToGroupPage();
        appManage.getGroupHelper().selectGroup();
        appManage.getGroupHelper().deleteGroup();
        appManage.getGroupHelper().returnToGroupPage();
    }

}
