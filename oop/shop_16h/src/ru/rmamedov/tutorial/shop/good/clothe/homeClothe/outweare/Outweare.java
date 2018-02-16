package ru.rmamedov.tutorial.shop.good.clothe.homeClothe.outweare;

import ru.rmamedov.tutorial.shop.department.Department;
import ru.rmamedov.tutorial.shop.good.clothe.Clothe;

public class Outweare extends Clothe {

    private boolean waterProof;

    public Outweare(String name, String madeInContry, boolean waterProof) {
        super(name, madeInContry);
        this.waterProof = waterProof;
    }

    public Outweare(String name, String madeInContry, String color, boolean waterProof) {
        super(name, madeInContry, color);
        this.waterProof = waterProof;
    }

    public Outweare(String name, int price, String madeInContry, String color, boolean waterProof) {
        super(name, price, madeInContry, color);
        this.waterProof = waterProof;
    }

    public Outweare(String name, int price, int varrenty, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, madeInContry, color);
        this.waterProof = waterProof;
    }

    public Outweare(String name, int price, int varrenty, Department department, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, department, madeInContry, color);
        this.waterProof = waterProof;
    }
}