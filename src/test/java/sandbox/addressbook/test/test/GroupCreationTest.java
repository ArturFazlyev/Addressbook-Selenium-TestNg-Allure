package sandbox.addressbook.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.GroupData;
import sandbox.addressbook.test.modele.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new GroupData().withName("test1").withFooter("footer1").withHeader("header1")});
        list.add(new Object[]{new GroupData().withName("test2").withFooter("footer2").withHeader("header2")});
        list.add(new Object[]{new GroupData().withName("test3").withFooter("footer3").withHeader("header3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream()
                .mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}

