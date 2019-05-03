package sandbox.addressbook.test.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sandbox.addressbook.test.module.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        appManage.getNavigationHelper().goToGroupPage();
        if (!appManage.getGroupHelper().isThereAGroup()) {
            appManage.getGroupHelper().createGroup(new GroupData("test1", null,
                    null));
        }
    }

    @Test
    public void testGroupCreation() {
        List<GroupData> before = appManage.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "test1",
                "test2", "test3");
        appManage.getGroupHelper().modifyGroup(index, group);
        List<GroupData> after = appManage.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
