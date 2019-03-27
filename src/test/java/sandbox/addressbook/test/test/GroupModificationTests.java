package sandbox.addressbook.test.test;

import org.testng.annotations.Test;
import sandbox.addressbook.test.module.GroupData;

public class GroupModificationTests extends TestBase {

        @Test
        public void testGroupCreation()  {
            appManage.getGroupHelper().goToGroupPage();
            appManage.getGroupHelper().selectGroup();
            appManage.getGroupHelper().initGroupModification();
            appManage.getGroupHelper().fillGroupFields(new GroupData("test1","test2","test3"));
            appManage.getGroupHelper().updateGroup();
            appManage.getGroupHelper().returnToGroupPage();
}
    }
