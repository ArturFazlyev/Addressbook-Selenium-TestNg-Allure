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
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertEquals(app.group().getGroupCount(), before.size() - 1);
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));
    }
}


