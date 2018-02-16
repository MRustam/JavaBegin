package ru.rmamedov.tutorial.shop.worker.consutant;

import ru.rmamedov.tutorial.shop.interfaces.InterfaceGood;
import ru.rmamedov.tutorial.shop.worker.AbstractWorker;

public class Consultant extends AbstractWorker {

    public Consultant(String name) {
        super(name);
    }


    // Describe good.
    public void describeGood(InterfaceGood good) {
            System.out.println(good);
    }
}