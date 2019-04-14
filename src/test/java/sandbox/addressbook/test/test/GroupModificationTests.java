package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.addressbook.test.module.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        appManage.getNavigationHelper().goToGroupPage();
        if (!appManage.getGroupHelper().isThereAGroup()) {
            appManage.getGroupHelper().createGroup(new GroupData("test1", null,
                    null));
        }
        List<GroupData> before = appManage.getGroupHelper().getGroupList();
        appManage.getGroupHelper().selectGroup(before.size() - 1);
        appManage.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"test1",
                "test2", "test3");
        appManage.getGroupHelper().fillGroupFields(group);
        appManage.getGroupHelper().updateGroup();
        appManage.getGroupHelper().returnToGroupPage();
        List<GroupData> after = appManage.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
