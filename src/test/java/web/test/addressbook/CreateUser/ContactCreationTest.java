package web.test.addressbook.CreateUser;

import org.testng.annotations.*;

public class ContactCreationTest extends BaseTest {

  @Test
  public void initContactCreation(){
    appManage.gotoNewContact();
    appManage.createNewContact(new ContactData("James", "Jones", "Jam.Jones", "QA", "Infotecs", "Manchester, Stadium Old Trafford", "2780857", "89053555178", "james.jones@oldtrafford.com", "17", "January", "1985"));
    appManage.submitNewContact();
    appManage.returnHomePage();
  }


}
