package ru.rmamedov.tutorial.shop.good.electronic;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.BaseGood;

public class Electronic extends BaseGood {

    public Electronic(String name) {
        super(name);
    }

    public Electronic(String name, int price) {
        super(name, price);
    }

    public Electronic(String name, int price, int varrenty) {
        super(name, price, varrenty);
    }

    public Electronic(String name, int price, int varrenty, BaseDepartment baseDepartment) {
        super(name, price, varrenty, baseDepartment);
    }

    public void switchOn() {

    }
}