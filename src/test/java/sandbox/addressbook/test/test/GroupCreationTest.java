package sandbox.addressbook.test.test;

import org.testng.annotations.*;
import sandbox.addressbook.test.module.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManage.getGroupHelper().goToGroupPage();
    appManage.getGroupHelper().initNewGroup();
    appManage.getGroupHelper().fillGroupFields(new GroupData("test1", "test2", "test3"));
    appManage.getGroupHelper().sumbitCreateGroup();
    appManage.getGroupHelper().returnToGroupPage();
  }


}
