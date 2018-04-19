package implementations;

import interfaces.AddressBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Person;

public class AddressBookCollection implements AddressBook {

    private ObservableList<Person> personsList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personsList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personsList.remove(person);
    }

    public ObservableList<Person> getPersonsList() {
        return personsList;
    }

    public void fillData() {
        personsList.add(new Person("Kim", "+987456"));
        personsList.add(new Person("Oleg", "+987009"));
        personsList.add(new Person("Vladimir", "+987676"));
        personsList.add(new Person("Pavel", "+987044"));
        personsList.add(new Person("Olya", "+987749"));
        personsList.add(new Person("Dima", "+987096"));
        personsList.add(new Person("Kiril", "+987877"));
    }

}
