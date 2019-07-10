package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sandbox.addressbook.test.modele.ContactData;
import sandbox.addressbook.test.modele.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitNewContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
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
        click(By.xpath("//option[@value='17']"));
        click(By.name("bmonth"));
        click(By.xpath("//option[@value='January']"));
        type(By.name("byear"), contactData.getByear());
        attach(By.name("photo"), contactData.getPhoto());
    }

    public void submitContactUpdate() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void deleteSelectedContact(){
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContactById(int id){
        wd.findElement(By.cssSelector("input[value='"+ id + "']")).click();
    }

    public void delete (ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
        closeAlert();
    }

    public void modify(ContactData contact){
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact);
        submitContactUpdate();
        contactCache = null;
        returnHomePage();
    }

    public void addContact(ContactData contact){
        initContactCreation();
        fillContactForm(contact);
        submitNewContact();
        contactCache = null;
        returnHomePage();
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

      public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement elem : elements) {
            String name = elem.findElements(By.tagName("td")).get(2).getText();
            String lname = elem.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstname(name)
                    .withLastname(lname));
        }
        return new Contacts(contactCache);
    }


}
