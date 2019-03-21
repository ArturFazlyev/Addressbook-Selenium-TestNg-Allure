package web.test.addressbook.CreateUser.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import web.test.addressbook.CreateUser.module.GroupData;

public class GroupHelper {
    private FirefoxDriver wd;

    public GroupHelper(FirefoxDriver wd) {
        this.wd=wd;
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void sumbitCreateGroup() {
      wd.findElement(By.name("submit")).click();
    }

    public void fillGroupFields(GroupData groupData) {
        type("group_name", groupData.getName());
        type("group_header", groupData.getHeader());
        type("group_footer", groupData.getFooter());
    }

    private void type(String locator, String text) {
        wd.findElement(By.name(locator)).click();
        wd.findElement(By.name(locator)).clear();
        wd.findElement(By.name(locator)).sendKeys(text);
    }

    public void initNewGroup() {
      wd.findElement(By.name("new")).click();
    }

    public void goToGroupPage() {
      wd.findElement(By.linkText("groups")).click();
    }

    public void deleteGroup() {
      wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
    }
}
