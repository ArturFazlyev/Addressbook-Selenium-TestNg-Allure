package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sandbox.addressbook.test.module.ContactData;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitNewContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void createNewContact(ContactData contactData) {
        type(("firstname"), contactData.getFirstname());
        type(("lastname"), contactData.getLastname());
        type(("nickname"), contactData.getNickname());
        type(("title"), contactData.getTitle());
        type(("company"), contactData.getCompany());
        type(("address"), contactData.getAddress());
        type(("home"), contactData.getHome());
        type(("mobile"), contactData.getMobile());
        type(("email"), contactData.getEmail());
        click(By.name("bday"));
        select(By.name("bday"), contactData.getBday());
        click(By.xpath("//option[@value='17']"));
        click(By.name("bmonth"));
        select(By.name("bmonth"), contactData.getBmonth());
        click(By.xpath("//option[@value='January']"));
        type(("byear"), contactData.getByear());
    }


    public void submitContactUpdate() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));

    }

    public void deleteContact() {
        click(By.name("selected[]"));
        click(By.xpath("//input[@value='Delete']"));
        closeAlert();
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();


    }

}
