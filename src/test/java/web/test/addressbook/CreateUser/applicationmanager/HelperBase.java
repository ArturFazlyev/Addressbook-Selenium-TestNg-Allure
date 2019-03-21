package web.test.addressbook.CreateUser.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    public FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void select(By locator, String text) {
        new Select(wd.findElement(locator)).selectByVisibleText(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }


    protected void closeAlert() {
        wd.switchTo().alert().accept();


    }

    protected void type(String locator, String text) {
        wd.findElement(By.name(locator)).click();
        wd.findElement(By.name(locator)).clear();
        wd.findElement(By.name(locator)).sendKeys(text);
    }
}
