package ru.rmamedov.testFX.interfaces;

import ru.rmamedov.testFX.objects.Person;

public interface AddressBook {

    void add(Person person);
    void update(Person person);
    void delete(Person person);

}
