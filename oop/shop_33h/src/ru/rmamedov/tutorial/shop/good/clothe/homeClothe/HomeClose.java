package ru.rmamedov.tutorial.shop.good.clothe.homeClothe;

import ru.rmamedov.tutorial.shop.department.AbstractDepartment;
import ru.rmamedov.tutorial.shop.good.clothe.Clothe;

public class HomeClose extends Clothe {

     private String material;

    public HomeClose(String name, int price, String madeInContry, String color, String material) {
        super(name, price, madeInContry, color);
        this.material = material;
    }

}