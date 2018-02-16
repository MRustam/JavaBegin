package ru.rmamedov.tutorial.shop.good.electronic;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.Good;

public class Electronic extends Good {

    public Electronic(String name) {
        super(name);
    }

    public Electronic(String name, int price) {
        super(name, price);
    }

    public Electronic(String name, int price, int varrenty) {
        super(name, price, varrenty);
    }

    public Electronic(String name, int price, int varrenty, Department department) {
        super(name, price, varrenty, department);
    }

    public void switchOn() {

    }
}