package ru.rmamedov.tutorial.shop.good.clothe.outweare.jacket;

import ru.rmamedov.tutorial.shop.good.clothe.outweare.Outweare;

public class Jacket extends Outweare {


    public Jacket(String name, int price, String madeInContry,
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