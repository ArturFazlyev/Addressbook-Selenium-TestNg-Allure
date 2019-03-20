package web.test.addressbook.CreateUser.test;

import org.testng.annotations.*;
import web.test.addressbook.CreateUser.module.ContactData;

public class ContactCreationTest extends BaseTest {

  @Test
  public void initContactCreation(){
    appManage.gotoNewContact();
    appManage.getContactHelper().createNewContact(new ContactData("James", "Jones", "Jam.Jones", "QA", "Infotecs", "Manchester, Stadium Old Trafford", "2780857", "89053555178", "james.jones@oldtrafford.com", "17", "January", "1985"));
    appManage.getContactHelper().submitNewContact();
    appManage.getContactHelper().returnHomePage();
  }


}
