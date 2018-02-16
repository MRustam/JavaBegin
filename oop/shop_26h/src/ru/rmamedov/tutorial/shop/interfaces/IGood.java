package ru.rmamedov.tutorial.shop.interfaces;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;

public interface IGood {

    String getName();
    int getPrice();
    int getVarrenty();
    IDepartment getDepartment();

}