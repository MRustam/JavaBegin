package ru.rmamedov.tutorial.shop.good.clothe.outweare.coat;

import ru.rmamedov.tutorial.shop.good.clothe.outweare.Outweare;

public class Coat extends Outweare {

    public Coat(String name, int price, String madeInContry,
                String color, boolean waterProof) {
        super(name, price, madeInContry, color, waterProof);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void toProtect() {
        super.toProtect();
    }
}