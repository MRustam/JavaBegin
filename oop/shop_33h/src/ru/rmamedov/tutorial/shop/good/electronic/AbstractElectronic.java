package ru.rmamedov.tutorial.shop.good.electronic;

import ru.rmamedov.tutorial.shop.good.AbstractGood;

public abstract class AbstractElectronic extends AbstractGood {

    public AbstractElectronic(String name, int price) {
        super(name, price);
    }

    public void switchOn() {
        System.out.println("switched to electrecity");
    }
}