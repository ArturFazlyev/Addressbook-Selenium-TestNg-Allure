package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
        this.wd = wd;
    }

    public void homePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

    public void groupPage() {
        if (!isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1"))
                .getText().equals("Groups") && isElementPresent(By.name("new"))) {
            return;
        } else {
            wd.findElement(By.linkText("groups")).click();

        }


    }
}
