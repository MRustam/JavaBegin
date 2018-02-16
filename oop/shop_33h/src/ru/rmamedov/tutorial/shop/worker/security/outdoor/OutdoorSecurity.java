package ru.rmamedov.tutorial.shop.worker.security.outdoor;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;
import ru.rmamedov.tutorial.shop.interfaces.InterfaceVisitor;
import ru.rmamedov.tutorial.shop.worker.security.AbstractSecurity;

public class OutdoorSecurity extends AbstractSecurity {


    public OutdoorSecurity() {

    }

    public void checkVisitor(InterfaceVisitor visitor) {

        // Price of all bought goods.
        int generalPrice = 0;

        for (InterfaceGood good : visitor.getAlredyBoughtList()) {
            generalPrice += good.getPrice();
        }
        if (visitor.getSpendedMoney() == generalPrice) {
            System.out.println("Thank  you! You can Go!");
        } else {
            visitor.setSpendedMoney(100);
            System.out.println("Do not stole good anywere");
        }
    }
}