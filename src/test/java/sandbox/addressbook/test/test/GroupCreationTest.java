package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        appManage.getNavigationHelper().goToGroupPage();
        List<GroupData> before = appManage.getGroupHelper().getGroupList();
        appManage.getGroupHelper().createGroup((new GroupData("test1",
                "test2", "test3")));
        List<GroupData> after = appManage.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}

