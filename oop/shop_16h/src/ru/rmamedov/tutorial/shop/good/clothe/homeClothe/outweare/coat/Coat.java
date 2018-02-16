package ru.rmamedov.tutorial.shop.good.clothe.homeClothe.outweare.coat;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.clothe.homeClothe.outweare.Outweare;

public class Coat extends Outweare {
    public Coat(String name, String madeInContry, boolean waterProof) {
        super(name, madeInContry, waterProof);
    }

    public Coat(String name, String madeInContry, String color, boolean waterProof) {
        super(name, madeInContry, color, waterProof);
    }

    public Coat(String name, int price, String madeInContry, String color, boolean waterProof) {
        super(name, price, madeInContry, color, waterProof);
    }

    public Coat(String name, int price, int varrenty, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, madeInContry, color, waterProof);
    }

    public Coat(String name, int price, int varrenty, Department department, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, department, madeInContry, color, waterProof);
    }
}