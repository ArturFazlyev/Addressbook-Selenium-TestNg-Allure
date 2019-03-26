package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
        this.wd = wd;
    }

    public void gotoNewContact() {
        click((By.linkText("add new")));
    }
}
