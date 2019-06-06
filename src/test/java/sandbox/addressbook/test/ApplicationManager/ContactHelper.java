package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sandbox.addressbook.test.modele.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void fillContactForm(ContactData contactData) {
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

    public void selectedContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        closeAlert();
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactData contact) {
        fillContactForm(contact);
        submitNewContact();
        returnHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {

        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement elem : elements) {

            String name = elem.findElements(By.tagName("td")).get(2).getText();
            String lname = elem.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));

            contacts.add(new ContactData().withId(id).withFirstname(name)
                    .withLastname(lname));
        }
        return contacts;
    }
}
