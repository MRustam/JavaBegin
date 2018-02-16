package ru.rmamedov.tutorial.shop.good.clothe;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.Good;

public class Clothe extends Good {

    private String madeInContry;
    private String color;

    public Clothe(String name, String madeInContry) {
        super(name);
        this.madeInContry = madeInContry;
    }

    public Clothe(String name, String madeInContry, String color) {

        super(name);
        this.madeInContry = madeInContry;
        this.color = color;
    }

    public Clothe(String name, int price, String madeInContry, String color) {
        super(name, price);
        this.madeInContry = madeInContry;
        this.color = color;
    }

    public Clothe(String name, int price, int varrenty, String madeInContry, String color) {
        super(name, price, varrenty);
        this.madeInContry = madeInContry;
        this.color = color;
    }

    public Clothe(String name, int price, int varrenty, Department department, String madeInContry, String color) {
        super(name, price, varrenty, department);
        this.madeInContry = madeInContry;
        this.color = color;
    }
}