package sandbox.addressbook.test.test;

import org.testng.annotations.Test;

public class GroupModificationTests extends BaseTest{

        @Test
        public void testGroupCreation()  {
            appManage.getGroupHelper().goToGroupPage();
            appManage.getGroupHelper().selectGroup();
            appManage.getGroupHelper().initGroupModification();
            appManage.getGroupHelper().updateGroup();
            appManage.getGroupHelper().returnToGroupPage();
}
    }
