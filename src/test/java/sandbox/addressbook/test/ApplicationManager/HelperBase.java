package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    public WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void select(By locator, String text) {
        new Select(wd.findElement(locator)).selectByVisibleText(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void type(String locator, String text) {
        click(By.name(locator));
        if (text != null) {
            wd.findElement(By.name(locator)).clear();
            wd.findElement(By.name(locator)).sendKeys(text);
        }
    }
}