package interfaces;

import objects.Person;

public interface AddressBook {

    public void add(Person person);
    public void update(Person person);
    public void delete(Person person);

}
