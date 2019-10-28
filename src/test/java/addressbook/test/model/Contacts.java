package addressbook.test.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

    public Set<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);

    }

    public Contacts(Collection<ContactData> contacts) {
        this.delegate = new HashSet<ContactData>(contacts);

    }



    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contact){
        Contacts contacts = new Contacts();
        contacts.add(contact);
        return contacts;

    }

    public Contacts without(ContactData contact){
        Contacts contacts = new Contacts();
        contacts.remove(contact);
        return contacts;
    }
}
