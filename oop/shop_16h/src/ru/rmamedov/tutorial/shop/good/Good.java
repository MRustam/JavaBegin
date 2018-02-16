package ru.rmamedov.tutorial.shop.good;

import ru.rmamedov.tutorial.shop.department.Department;

public class Good {

    private String name;
    private int price;
    private int varrenty;

    private Department department;

    public Good(String name) {
        this.name = name;
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Good(String name, int price, int varrenty) {
        this.name = name;
        this.price = price;
        this.varrenty = varrenty;
    }

    public Good(String name, int price, int varrenty, Department department) {
        this.name = name;
        this.price = price;
        this.varrenty = varrenty;
        this.department = department;
    }
}