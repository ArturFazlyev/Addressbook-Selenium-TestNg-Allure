package sandbox.addressbook.test.test;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sandbox.addressbook.test.modele.ContactData;
import sandbox.addressbook.test.modele.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/java/sandbox/addressbook/test/resourses/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        List<ContactData> contact = (List<ContactData>) xStream.fromXML(xml);
        return contact.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

    }


    @Test(dataProvider = "validContactsFromXML")
    public void initContactCreation(ContactData contact) {
        Contacts before = app.contact().all();
        app.goTo().homePage();
        app.contact().addContact(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

    }

}
