package web.test.addressbook.CreateUser.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import web.test.addressbook.CreateUser.module.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitNewContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void createNewContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        click(By.name("bday"));
        select(By.name("bday"), contactData.getBday());
        click(By.xpath("//option[@value='17']"));
        click(By.name("bmonth"));
        select(By.name("bmonth"), contactData.getBmonth());
        click(By.xpath("//option[@value='January']"));
        type(By.name("byear"), contactData.getByear());
    }


    public void submitContactUpdate() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));

    }

    }
