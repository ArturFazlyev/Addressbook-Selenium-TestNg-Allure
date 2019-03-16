package addressbook.tests;

import org.testng.annotations.*;


public class GroupDelitionTest extends TestBase {

    @Test
    public void testGroupDelition() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
