package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sandbox.addressbook.test.module.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);
        this.wd = wd;
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void sumbitCreateGroup() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupFields(GroupData groupData) {
        type("group_name", groupData.getName());
        type("group_header", groupData.getHeader());
        type("group_footer", groupData.getFooter());
    }

    public void initNewGroup() {
        wd.findElement(By.name("new")).click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }


    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value = '"+ id + "' ]")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void updateGroup() {
        wd.findElement(By.name("update")).click();
    }

    public void create(GroupData group) {
        initNewGroup();
        fillGroupFields(group);
        sumbitCreateGroup();
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupFields(group);
        updateGroup();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void deleteSelectGroup() {
        deleteGroup();
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectGroup();
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


}
