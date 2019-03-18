package web.test.addressbook.CreateUser;

import org.testng.annotations.Test;
import web.test.addressbook.CreateUser.GroupData;
import web.test.addressbook.CreateUser.TestBase;

public class CreateNewContact extends TestBase {

  @Test
  public void testCreateNewContact() {
    goToUserPage();
    fillUserForm(new GroupData("User", "User", "Infotecs"));
    submitUserCreation();
    returnToHomePage();

  }

}
