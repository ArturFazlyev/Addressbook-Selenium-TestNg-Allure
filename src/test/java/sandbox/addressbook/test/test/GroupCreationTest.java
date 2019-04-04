package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    int before = appManage.getGroupHelper().getGroupCount();
    appManage.getNavigationHelper().goToGroupPage();
    appManage.getGroupHelper().createGroup((new GroupData("test1",
            "test2", "test3")));
    int after = appManage.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }


}
