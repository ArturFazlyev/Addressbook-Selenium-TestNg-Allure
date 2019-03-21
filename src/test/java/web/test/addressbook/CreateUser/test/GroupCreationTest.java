package web.test.addressbook.CreateUser.test;

import org.testng.annotations.*;
import web.test.addressbook.CreateUser.module.GroupData;

public class GroupCreationTest extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    appManage.getGroupHelper().goToGroupPage();
    appManage.getGroupHelper().initNewGroup();
    appManage.getGroupHelper().fillGroupFields(new GroupData("test1", "test2", "test3"));
    appManage.getGroupHelper().sumbitCreateGroup();
    appManage.getGroupHelper().returnToGroupPage();
  }


}
