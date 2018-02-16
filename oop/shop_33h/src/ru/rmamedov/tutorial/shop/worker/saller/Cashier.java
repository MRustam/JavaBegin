package ru.rmamedov.tutorial.shop.worker.saller;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceVisitor;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;
import ru.rmamedov.tutorial.shop.worker.AbstractWorker;

public class Cashier extends AbstractWorker {

    private InterfaceVisitor visitor;

    public Cashier(String name) {
        super(name);
    }


    public void giveDiscontCard() {

        if (visitor.getDiscontCard() && (visitor.getAlredyBoughtList().size() > 3)) {
            visitor.setDiscontCard(true);
        }
    }


    public void sale(InterfaceGood good) {
        visitor.setSpendedMoney(good.getPrice());
        visitor.setAlredyBoughtList(good);
    }
}