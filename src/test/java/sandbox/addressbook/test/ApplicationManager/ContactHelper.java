package sandbox.addressbook.test.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sandbox.addressbook.test.modele.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        click(By.xpath("//option[@value='17']"));
        click(By.name("bmonth"));
        click(By.xpath("//option[@value='January']"));
        type(("byear"), contactData.getByear());
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
        closeAlert();
    }

    public void modify(ContactData contact){
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact);
        submitContactUpdate();
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

      public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
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
