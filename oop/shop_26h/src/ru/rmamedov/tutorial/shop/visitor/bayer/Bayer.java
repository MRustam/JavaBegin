package ru.rmamedov.tutorial.shop.visitor.bayer;

import ru.rmamedov.tutorial.shop.visitor.BaseVisitor;

public class Bayer extends BaseVisitor {

    private int spended;
    private int bought;
    private int creditStory;
    private boolean discontCard;
    private boolean enoughMoney;

    public Bayer(String name, int spended) {
        super(name);
        this.spended = spended;
    }

    public Bayer(String name, int spended, int bought) {
        super(name);
        this.spended = spended;
        this.bought = bought;
    }

    public Bayer(String name, int spended, int bought, int creditStory) {
        super(name);
        this.spended = spended;
        this.bought = bought;
        this.creditStory = creditStory;
    }

    public Bayer(String name, int spended, int bought, int creditStory, boolean discontCard, boolean enoughMoney) {
        super(name);
        this.spended = spended;
        this.bought = bought;
        this.creditStory = creditStory;
        this.discontCard = discontCard;
        this.enoughMoney = enoughMoney;
    }
}