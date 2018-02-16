package ru.rmamedov.tutorial.shop.good;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceDepartment;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;

public abstract class AbstractGood implements InterfaceGood {

    private String name;
    private int price;
    private int varrenty;
    private InterfaceDepartment department;

    public AbstractGood(String name, int price) {
        this.name = name;
        this.price = price;
        varrenty = 1;
    }

    @Override
    public void setDepartment(InterfaceDepartment department) {
        this.department = department;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getVarrenty() {
        return varrenty;
    }

    @Override
    public String toString() {
        return "This is an exelent chose! \n" + getName() +
                " whith " + getVarrenty() + " year varrenty and price \n" +
                getPrice();
    }

}