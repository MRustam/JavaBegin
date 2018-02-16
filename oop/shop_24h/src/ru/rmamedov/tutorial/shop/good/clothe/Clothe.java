package ru.rmamedov.tutorial.shop.good.clothe;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.BaseGood;

public class Clothe extends BaseGood {

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

    public Clothe(String name, int price, int varrenty, BaseDepartment baseDepartment, String madeInContry, String color) {
        super(name, price, varrenty, baseDepartment);
        this.madeInContry = madeInContry;
        this.color = color;
    }
}