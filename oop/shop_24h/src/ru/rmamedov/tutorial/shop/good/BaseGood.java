package ru.rmamedov.tutorial.shop.good;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;

public class BaseGood {

    private String name;
    private int price;
    private int varrenty;

    private BaseDepartment baseDepartment;

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

    public BaseGood(String name, int price, int varrenty, BaseDepartment baseDepartment) {
        this.name = name;
        this.price = price;
        this.varrenty = varrenty;
        this.baseDepartment = baseDepartment;
    }
}