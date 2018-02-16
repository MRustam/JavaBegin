package ru.rmamedov.tutorial.shop.good.clothe.homeClothe.bathrobe;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.clothe.homeClothe.HomeClose;

public class Bathrobe extends HomeClose {
    public Bathrobe(String name, String madeInContry, String material) {
        super(name, madeInContry, material);
    }

    public Bathrobe(String name, String madeInContry, String color, String material) {
        super(name, madeInContry, color, material);
    }

    public Bathrobe(String name, int price, String madeInContry, String color, String material) {
        super(name, price, madeInContry, color, material);
    }

    public Bathrobe(String name, int price, int varrenty, String madeInContry, String color, String material) {
        super(name, price, varrenty, madeInContry, color, material);
    }

    public Bathrobe(String name, int price, int varrenty, BaseDepartment baseDepartment, String madeInContry, String color, String material) {
        super(name, price, varrenty, baseDepartment, madeInContry, color, material);
    }
}