package sandbox.addressbook.test.test;

import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        appManage.getNavigationHelper().goToGroupPage();
        if (! appManage.getGroupHelper().isThereAGroup()){
            appManage.getGroupHelper().createGroup(new GroupData("test1", null,
                    null));
        }
        appManage.getGroupHelper().selectGroup();
        appManage.getGroupHelper().deleteGroup();
        appManage.getGroupHelper().returnToGroupPage();
    }

}
