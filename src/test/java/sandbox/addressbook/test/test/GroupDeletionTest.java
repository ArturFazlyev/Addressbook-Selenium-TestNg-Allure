package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        appManage.getNavigationHelper().goToGroupPage();
        int before = appManage.getGroupHelper().getGroupCount();
        if (!appManage.getGroupHelper().isThereAGroup()) {
            appManage.getGroupHelper().createGroup(new GroupData("test1", null,
                    null));
        }
        appManage.getGroupHelper().selectGroup(before - 1);
        appManage.getGroupHelper().deleteSelectGroup();
        int after = appManage.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);

    }

}
