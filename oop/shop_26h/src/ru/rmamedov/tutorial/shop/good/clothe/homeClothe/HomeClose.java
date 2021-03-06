package ru.rmamedov.tutorial.shop.good.clothe.homeClothe;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.clothe.Clothe;

public class HomeClose extends Clothe {

     private String material;

    public HomeClose(String name, String madeInContry, String material) {
        super(name, madeInContry);
        this.material = material;
    }

    public HomeClose(String name, String madeInContry, String color, String material) {
        super(name, madeInContry, color);
        this.material = material;
    }

    public HomeClose(String name, int price, String madeInContry, String color, String material) {
        super(name, price, madeInContry, color);
        this.material = material;
    }

    public HomeClose(String name, int price, int varrenty, String madeInContry, String color, String material) {
        super(name, price, varrenty, madeInContry, color);
        this.material = material;
    }

    public HomeClose(String name, int price, int varrenty, BaseDepartment baseDepartment, String madeInContry, String color, String material) {
        super(name, price, varrenty, baseDepartment, madeInContry, color);
        this.material = material;
    }
}