package addressbook.test.test;

import addressbook.test.model.Groups;
import org.testng.annotations.*;
import addressbook.test.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertEquals(app.group().getGroupCount(), before.size() - 1);
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletedGroup)));
        verifyGroupListInUI();
    }
}


