package sandbox.addressbook.test.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
        this.wd = wd;
    }

    public void gotoNewContact() {
        click((By.linkText("add new")));
    }
}
