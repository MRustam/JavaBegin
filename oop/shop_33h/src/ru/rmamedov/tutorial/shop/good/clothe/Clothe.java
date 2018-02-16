package ru.rmamedov.tutorial.shop.good.clothe;

import ru.rmamedov.tutorial.shop.good.AbstractGood;

public class Clothe extends AbstractGood {

    private String madeInContry;
    private String color;

    public Clothe(String name, int price, String madeInContry, String color) {
        super(name, price);
        this.madeInContry = madeInContry;
        this.color = color;
    }
}