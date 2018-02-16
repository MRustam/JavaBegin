package ru.rmamedov.tutorial.shop.good.clothe.outweare;

import ru.rmamedov.tutorial.shop.good.clothe.Clothe;
import ru.rmamedov.tutorial.shop.interfaces.goodsBehevior.InterefaceProtect;

public class Outweare extends Clothe implements InterefaceProtect {

    private boolean waterProof;

    public Outweare(String name, int price, String madeInContry,
                    String color, boolean waterProof) {
        super(name, price, madeInContry, color);
        this.waterProof = waterProof;
    }

    public boolean isWaterProof() {
        return waterProof;
    }

    @Override
    public void toProtect() {
        System.out.println("Protect from water");
    }
}