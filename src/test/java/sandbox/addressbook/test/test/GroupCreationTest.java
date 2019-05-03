package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        appManage.getNavigationHelper().goToGroupPage();
        List<GroupData> before = appManage.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test2",
                "test2", "test3");
        appManage.getGroupHelper().createGroup(group);
        List<GroupData> after = appManage.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}

