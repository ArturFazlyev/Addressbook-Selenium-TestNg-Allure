package addressbook.tests;

import org.testng.annotations.*;


public class GroupDelitionTest extends TestBase {

    @Test
    public void testGroupDelition() {
        app.goToGroupPage();
        app.selectGroup();
        app.selectedGroups();
        app.returnToGroupPage();
    }


}
