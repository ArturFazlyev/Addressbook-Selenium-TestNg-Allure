package addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;


public class GroupDelitionTest extends TestBase {

    @Test
    public void testGroupDelition() {
        goToGroupPage();
        selectGroup();
        selectedGroups();
        returnToGroupPage();
    }


}
