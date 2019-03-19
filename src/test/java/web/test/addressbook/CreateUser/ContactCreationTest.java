package web.test.addressbook.CreateUser;

import java.util.concurrent.TimeUnit;

import addressbook.CreateGroup.tests.TestBase;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTest extends BaseTest {

  @Test
  public void initContactCreation() throws Exception {
    gotoNewContact();
    createNewContact(new ContactData("James", "Jones", "Jam.Jones", "QA", "Infotecs", "Manchester, Stadium Old Trafford", "2780857", "89053555178", "james.jones@oldtrafford.com", "17", "January", "1985"));
    submitNewContact();
    returnHomePage();
    close();
  }


}
