package web.test.addressbook.CreateUser.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppManage {
     FirefoxDriver wd;

    private ContactHelper contactHelper = new ContactHelper(wd);


    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        contactHelper = new ContactHelper(wd);
        login("admin", "secret");
    }

    public void login(String username, String password) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void gotoNewContact() {
      wd.findElement(By.linkText("add new")).click();
    }

    public void close() {
        wd.findElement(By.linkText("Logout")).click();
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
