package sandbox.addressbook.test.Generators;

import sandbox.addressbook.test.modele.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        // число строк в тестовом файле
        int count = Integer.parseInt(args[0]);
        // создание файла
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s; %s; %s; %s; %s; %s\n",
                    contact.getFirstname(), contact.getLastname(), contact.getNickname(),
                    contact.getTitle(), contact.getEmail(), contact.getHome()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withFirstname(String.format("firstname %s", i))
                    .withLastname(String.format("lastname %s", i))
                    .withNickname(String.format("nickname %s", i))
                    .withTitle(String.format("title %s",i))
                    .withEmail(String.format("email %s", i))
                    .withHome(String.format("home %s", i)));
        }
        return contacts;
    }
}
