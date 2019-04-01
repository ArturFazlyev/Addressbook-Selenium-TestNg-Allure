package sandbox.addressbook.test.test;

import org.testng.annotations.Test;
import sandbox.addressbook.test.module.GroupData;

public class GroupModificationTests extends TestBase {

        @Test
        public void testGroupCreation()  {
            appManage.getNavigationHelper().goToGroupPage();
            if (! appManage.getGroupHelper().isThereAGroup()){
                appManage.getGroupHelper().createGroup(new GroupData("test1", null,
                        null));
            }
            appManage.getGroupHelper().selectGroup();
            appManage.getGroupHelper().initGroupModification();
            appManage.getGroupHelper().fillGroupFields(new GroupData("test1",
                    "test2","test3"));
            appManage.getGroupHelper().updateGroup();
            appManage.getGroupHelper().returnToGroupPage();
}
    }
