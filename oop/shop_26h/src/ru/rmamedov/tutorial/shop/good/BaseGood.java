package ru.rmamedov.tutorial.shop.good;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.interfaces.IGood;

public abstract class BaseGood implements IGood {

    private String name;
    private int price;
    private int varrenty;

    private BaseDepartment department;

    public BaseGood(String name) {
        this.name = name;
    }

    public BaseGood(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public BaseGood(String name, int price, int varrenty) {
        this.name = name;
        this.price = price;
        this.varrenty = varrenty;
    }

    public BaseGood(String name, int price, int varrenty, BaseDepartment department) {
        this.name = name;
        this.price = price;
        this.varrenty = varrenty;
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
    public BaseDepartment getDepartment() {
        return department;
    }
}