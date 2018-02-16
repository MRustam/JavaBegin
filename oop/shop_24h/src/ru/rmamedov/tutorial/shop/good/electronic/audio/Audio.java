package ru.rmamedov.tutorial.shop.good.electronic.audio;

import ru.rmamedov.tutorial.shop.department.BaseDepartment;
import ru.rmamedov.tutorial.shop.good.electronic.Electronic;

public class Audio  extends Electronic {

    private int outputPower;

    public Audio(String name, int outputPower) {
        super(name);
        this.outputPower = outputPower;
    }

    public Audio(String name, int price, int outputPower) {
        super(name, price);
        this.outputPower = outputPower;
    }

    public Audio(String name, int price, int varrenty, int outputPower) {
        super(name, price, varrenty);
        this.outputPower = outputPower;
    }

    public Audio(String name, int price, int varrenty, BaseDepartment baseDepartment, int outputPower) {
        super(name, price, varrenty, baseDepartment);
        this.outputPower = outputPower;
    }
}