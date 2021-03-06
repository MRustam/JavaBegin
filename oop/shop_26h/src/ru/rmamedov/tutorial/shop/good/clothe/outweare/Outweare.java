package ru.rmamedov.tutorial.shop.good.clothe.outweare;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.clothe.Clothe;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.IProtect;

public class Outweare extends Clothe implements IProtect {

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

    public Outweare(String name, int price, int varrenty, BaseDepartment baseDepartment, String madeInContry, String color, boolean waterProof) {
        super(name, price, varrenty, baseDepartment, madeInContry, color);
        this.waterProof = waterProof;
    }

    @Override
    public void toProtect() {

    }
}