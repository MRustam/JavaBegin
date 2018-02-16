package ru.rmamedov.tutorial.shop.good.clothe.homeClothe.outweare.jacket;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.clothe.homeClothe.outweare.Outweare;

public class Jacket extends Outweare {
    public Jacket(String name, String madeInContry, boolean waterProof) {
        super(name, madeInContry, waterProof);
    }

    public Jacket(String name, String madeInContry, String color, boolean waterProof) {
        super(name, madeInContry, color, waterProof);
    }

    public Jacket(String name, int price, String madeInContry, String color, boolean waterProof) {
        super(name, price, madeInContry, color, waterProof);
    }

    public Jacket(String name, int price, int varrenty, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, madeInContry, color, waterProof);
    }

    public Jacket(String name, int price, int varrenty, BaseDepartment baseDepartment, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, baseDepartment, madeInContry, color, waterProof);
    }
}