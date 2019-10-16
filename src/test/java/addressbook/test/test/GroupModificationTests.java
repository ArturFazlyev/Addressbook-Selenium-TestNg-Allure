package addressbook.test.test;

import addressbook.test.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import addressbook.test.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }

    }

    @Test
    public void testGroupCreation() {
        Groups before = app.db().groups();
        GroupData modifiedGroup= before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").
                withHeader("test2").withFooter("test3");
        app.goTo().groupPage();
        app.group().modify(group);
        Groups after = app.db().groups();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}
