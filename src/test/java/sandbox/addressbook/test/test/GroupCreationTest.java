package sandbox.addressbook.test.test;

import org.testng.Assert;
import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManage.getNavigationHelper().goToGroupPage();
    int before = appManage.getGroupHelper().getGroupCount();
    appManage.getGroupHelper().createGroup((new GroupData("test1",
              "test2", "test3")));
      int after = appManage.getGroupHelper().getGroupCount();
      Assert.assertEquals(after, before + 1);
    }

  }

