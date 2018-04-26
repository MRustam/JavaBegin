package objects;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty phoneNumber = new SimpleStringProperty("");

    public Person() {
    }

    public Person(String name, String phoneNumber) {
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }



    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }



    public SimpleStringProperty nameProperty() {
        return name;
    }
    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
