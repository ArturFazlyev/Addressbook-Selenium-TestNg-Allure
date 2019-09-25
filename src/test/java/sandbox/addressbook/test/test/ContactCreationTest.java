package sandbox.addressbook.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.ContactData;
import sandbox.addressbook.test.modele.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/java/sandbox/addressbook/test/resourses/contacts.json")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1])
            .withNickname(split[2]).withTitle(split[3]).withHome(split[4])});
            line = reader.readLine();
        }
        return list.iterator();

    }


    @Test(dataProvider = "validContacts")
    public void initContactCreation(ContactData contact) {
        Contacts before = app.contact().all();
        app.goTo().homePage();
        app.contact().addContact(contact);
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

    }

}
